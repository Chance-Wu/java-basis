```text
在面向对象的世界里，我们说万事万物皆对象。在Java语言中，只有两样不是面向对象：`普通数据类型`和`java中的静态`。
* 普通数据类型：例如  int a=5;  这就不是一个对象。但是普通数据类型都有封装类来弥补这个缺陷。
* java中的静态：不论是静态成员变量还是方法，java中的静态东西并不是属于某个对象，而是属于某个类。
```

* 类：`类只是对一项事物的抽象概括，可以包含该事务的一些属性定义，以及操作属性的方法。`
* 实例：`实例化就相当于为这个描述开辟了一块内存，可以改变这块区域里的各种属性（成员变量），当然，也可以实例化多块区域，只是不同的对象而已。`
* Class对象：`注意这里C大写了，与类概念区分开，在java里，Class是一个实实在在的类，在包java.lang下，有这样一个Class.java文件，它跟我们自己定义的类一样，是一个实实在在的类，Class对象就是这个Class类的实例了。在Java里，所有的类的根源都是Object类，而Class也不例外，它是继承自Object的一个特殊的类，它内部可以记录类的成员、接口等信息，也就是在Java里，Class是一个用来表示类的类。抓住关键一点，Class是一个实实在在的类，可以为它创建实例，也就是Class对象，也可以叫做Class实例）。`

类只是信息描述的，写明了有哪些内部属性及接口，你可以理解为是定义了一套规则；而Class对象在java里被用来对类的情况进行表述的一个实例，也就是是类的实际表征，可以理解为是对规则的图表化，这样JVM才能直观的看懂，可以看做是一个模版；而类的实例化对象，就是通过模版，开辟出的一块内存进行实际的使用。

1、Class类的对象
--
既然万事万物皆对象，那么每写的一个类是不是一个对象呢？当然，所写的任何一个类都属于对象。那么这些类都是谁的对象呢？其实这些类都是java.lang.Class类的实例对象。比如：

`我们写了一个Student的类，那么这个类是不是一个对象？当然是一个对象。那么是谁的对象呢？Class类的对象。`

2、创建Class类对象
--
看一下Class类中的构造方法：
```text
private Class(ClassLoader loader) {
    // 初始化classLoader的最终字段。 非空的初始化值
    // 防止将来的JIT优化假设此final字段为null。
    classLoader = loader;
}
```

* 私有构造函数。
* 只能由Java虚拟机来创建Class类对象。不使用此构造函数，并防止生成默认构造函数。

3、通过 类名.Class 方式创建了一个Class类的对象
--
这种方式透露了一个信息：`任何一个类中隐藏了一个静态的成员变量class`。

```text
Class<Person> personClass = Person.class;
```

4、通过该类的实例对象的getClass()方法获取Class类的实例对象
--
getClass()方法又是从哪个地方冒出来的呢？如果一个类没有明确指明继承哪个类，就会默认继承Object。在Object类中有个：
`public final native Class<?> getClass();`方法

```text
Person person = new Person();
Class<? extends Person> personClass2 = person.getClass();
```

person代表的是Person类的实例对象，personClass1和personClass2都代表的是Class类的实例对象。

> 官方解释：personClass1和personClass2都表示了Person类的类类型（class type）。
> Person类的类类型：本身Person类就是一个Class类的类型的对象。

上面的person是Person类型。同理，Person类是Class类型的，转个弯即Person类是类类型的。
所以personClass1和personClass2就是类类型，然而为了加以区分不同类的类类型，我们称之为该类的类类型。
因此personClass1和personClass2称为Person类的类类型。

Person类的对象是person；Person类的Class对象是personClass1和personClass2。

5、通过forName("全限定类名")创建Student类的类类型
--
注意：forName()方法里一定要写全限定性名（包名+类名），不然报异常ClassNotFoundException

```text
Class<?> personClass3 = null;
try {
    personClass3 = Class.forName("com.chance.basis.entity.Person");
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
```

6、通过Class类中的newInstance()方法来定义类实例化的对象
--
注意：`使用newInstance方法创建实例，要求类中要有个无参的构造函数，因为newInstance()方法会默认的调用无参的构造函数。`
如果这里面没有一个默认的构造方法，不可以采用类类型直接调用newInstance()方法实例化对象，只能先通过getConstructors方法获取全部的构造函数，然后找到匹配的构造函数使用newInstance方法传入参数才可以实例化对象。

* 如果是A类的类类型创建出来的就是A类的对象，如果是B类的类类型创建出来的就是B类的对象。
* 也因此导致java源码并不知道具体是哪个类的类类型来创建实例对象的，所以通过该类的类类型创建该类的实例对象Java直接返回一个Object类型，这样就需要通过强制的类型转换。

```text
Class personClass3 = null;
try {
    personClass3 = Class.forName("com.chance.basis.entity.Person");
    Person person3 = (Person) personClass3.newInstance();
} catch (Exception e) {
    e.printStackTrace();
}
```

7、总结
--
一个类只可能是Class类的一个实例对象，也就是说不管创建了多少该类的类类型对象，也不管用了何种方式创建该类的类类型对象，最终都是同一个。

