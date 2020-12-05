1、对象的创建
--
在语言层面上，创建对象（例如克隆、反序列化）通常仅仅是一个new关键字而已，而在虚拟机中，对象（讨论的对象仅限于普通对象，不包括数组和Class对象等）的创建又是怎样一个过程呢？

```
1.在类加载检查通过后，接下来虚拟机将为新生对象分配内存。对象分配空间的任务等同于把一块确定大小的内存从Java堆中划分出来。

假设Java堆中内存是绝对规整的，所有用过的内存都放在一边，空闲的内存放在另一边，中间放着一个指针作为分界点的指示器，那所分配内存就仅仅是把那个指针向空闲那边挪动一段与对象大小相等的距离。这种分配方式称为“指针碰撞”(Bump the Pointer)。

如果Java堆中的内存不是规整的，已使用的内存和空闲的内存相互交错，虚拟机就必须维护一个列表，记录上哪些内存块是可用的，在分配的时候从列表中找到一块足够大的空间划分给对象实例，并更新列表上的记录，这种分配方式称为"空闲列表"（Free List）。

选择哪种分配方式由Java堆是否规整决定，而Java堆是否规整又由所采用的垃圾收集器是否带有压缩整理功能决定。因此，在使用Serial、ParNew等带Compact过程的收集器时，系统采用的分配算法是指针碰撞，而使用CMS这种基于Mark-Sweep算法的收集器时，通常采用空闲列表。

2.除如何划分可用空间之外，还有另外一个需要考虑的问题是对象创建在虚拟机中非常频繁的行为，即使是仅仅修改一个指针所指向的位置，在并发情况下也并不是线程安全的，可能出现正在给对象A分配内存，指针还没来得及修改，对象B又同时使用了原来的指针来分配内存的情况。解决这个问题有两种方案，一种是对分配内存空间的动作进行同步处理——实际上虚拟机采用CAS配上失败重试的方式保证更新操作的原子性；

另一种是把内存分配的动作按照线程划分在不同的空间之中进行，即每个线程在Java堆中预先分配一小块内存，称为本地线程分配缓冲 (Thread Local Allocation Buffer,TLAB)。哪个线程要分配内存，就在哪个线程的TLAB上分配，只有TLAB用完并分配新的TLAB时，才需要同步锁定。虚拟机是否使用TLAB，可以通过-XX: +/-UseTLAB参数来设定。

3.内存分配完成后，虚拟机需要将分配到的内存空间都初始化为零值(不包括对象头)，如果使用TLAB，这一工作过程也可以提前至TLAB分配时进行。这一步操作保证了对象的实例字段在 Java代码中可以不赋初始值就直接使用，程序能访问到这些字段的数据类型所对应的零值。

4.接下来，虚拟机要对对象进行必要的设置，例如这个对象是哪个类的实例、如何才能找到类的元数据信息、对象的哈希码、对象的GC分代年龄等信息。这些信息存放在对象的对象头 (Object Header)之中。根据虚拟机当前的运行状态的不同，如是否启用偏向锁等，对象头会有不同的设置方式。

5.在上面工作都完成之后，从虚拟机的视角来看，一个新的对象已经产生了，但从Java程序的视角来看，对象创建才刚刚开始——<init>方法还没有执行，所有的字段都还为零。所以，一般来说(由字节码中是否跟随invokespecial指令所决定)，执行new指令之后会接着执行<init>方法，把对象按照程序员的意愿进行初始化，这样一个真正可用的对象才算完全产生出来。
```

HotSpot虚拟机 bytecodeInterpreter.cpp中的代码片段(这个解释器实现很少有机会实际使用，因为大部分平台上都使用模板解释器;当代码通过JIT编译器执行时差异就更大了。不过，这段代码用于了解HotSpot的运作过程是没有什么问题的)。
```
// 确保常量池中存放的是已解释的类
if (!constants->tag_at(index).is_unresolved_klass()) {
  // 确保klass已初始化并且没有一个finalizer
  Klass* entry = constants->slot_at(index).get_klass();
  assert(entry->is_klass(), "Should be resolved klass");
  Klass* k_entry = (Klass*) entry;
  assert(k_entry->oop_is_instance(), "Should be InstanceKlass");
  InstanceKlass* ik = (InstanceKlass*) k_entry;
  // 确保对象所述类型已经经过初始化阶段
  if ( ik->is_initialized() && ik->can_be_fastpath_allocated() ) {
    // 取对象长度
    size_t obj_size = ik->size_helper();
    oop result = NULL;
    // 记录是否需要将对象所有字段置零值
    bool need_zero = !ZeroTLAB;
    // 是否在TLAB中分配对象
    if (UseTLAB) {
      result = (oop) THREAD->tlab().allocate(obj_size);
    }
    if (result == NULL) {
      need_zero = true;
// 尝试在eden中分配对象
retry:
      HeapWord* compare_to = *Universe::heap()->top_addr();
      HeapWord* new_top = compare_to + obj_size;
      // cmpxchg是x86中的CAS指令，这里是一个C++方法，通 过CAS方式分配空间，如果并发失败，转到retry中重试，直至成功分配为止
      if (new_top <= *Universe::heap()->end_addr()) {
        if (Atomic::cmpxchg_ptr(new_top, Universe::heap()->top_addr(), compare_to) != compare_to) {
          goto retry;
        }
        result = (oop) compare_to;
      }
    }
    if (result != NULL) {
      // 如果需要，则为对象初始化零值
      if (need_zero ) {
        HeapWord* to_zero = (HeapWord*) result + sizeof(oopDesc) / oopSize;
        obj_size -= sizeof(oopDesc) / oopSize;
        if (obj_size > 0 ) {
          memset(to_zero, 0, obj_size * HeapWordSize);
        }
      }
      // 根据是否启用偏向锁来设置对象头信息
      if (UseBiasedLocking) {
        result->set_mark(ik->prototype_header());
      } else {
        result->set_mark(markOopDesc::prototype());
      }
      result->set_klass_gap(0);
      result->set_klass(k_entry);
      // 将对象引用入栈，继续执行下一条指令
      SET_STACK_OBJECT(result, 0);
      UPDATE_PC_AND_TOS_AND_CONTINUE(3, 1);
    }
  }
}
```

2、对象的内存布局
--
在HotSpot虚拟机中，对象在内存中存储的布局可以分为3块区域：
* 对象头(Header)：包括两部分信息
    * 第一部分用于存储对象自身的运行时数据，如哈希码(HashCode)、GC分代年龄、锁状态标志、线程持有的锁、偏向线程ID、偏向时间戳等，这部分数据的长度在32位和64位的虚拟机(未开启压缩指针)中分别为32bit和64bit，官方称它为“Mark Word”。对象需要存储的运行时数据很多，其实已经超出了32位、64位Bitmap结构所能录的限度，但是对象头信息是与对象自身定义的数据无关的额外存储成本，考虑到虚拟机的空间效率，Mark Word被设计成一个非固定的数据结构以便在极小的空间内存储尽量多的信息，它会根据对象的状态复用自己的存储空间。例如，在32位的HotSpot虚拟机中，如果对象处于未被锁定的状态下，那么Mark Word的32bit空间中的 25bit用于存储对象哈希码，4bit用于存储对象分代年龄，2bit用于存储锁标志位，1bit固定为0，而在其他状态(轻量级锁定、重量级锁定、GC标记、可偏向)下对象的存储内容见表。
    
    
|存储内容|标志位|状态|
|---|---|---|---|
|
* 实例数据(Instance Data)
* 对齐填充(Padding)



































