instanceof 严格来说是Java中的一个双目运算符，用来测试一个对象是否为一个类的实例，用法为：
`boolean result = obj instanceof Class` 

其中 obj 为一个对象，Class 表示一个类或者一个接口，当 obj 为 Class 的对象，或者是其直接或间接子类，或者是其接口的实现类，结果result 都返回 true，否则返回false。

> 注意：编译器会检查 obj 是否能转换成右边的class类型，如果不能转换则直接报错，如果不能确定类型，则通过编译，具体看运行时定。

1、obj必须为引用类型，不能是基本类型（byte，short，int，long，double，float，boolean，char）
--
instanceof 运算符只能用作对象的判断。

2、obj为null
--
Java中除了8种基本类型和引用类型，还有一种特殊的 `null类型`。
该类型没有名字，所以不可能声明为null类型的变量或者转换为null类型，null引用是null类型表达式唯一可能的值，null引用也可以转换为任意类引用类型。
我们不需要对null类型有多深刻的了解，只需要知道null是可以成为任意引用类型的特殊符号。

在 JavaSE规范 中对 instanceof 运算符的规定就是：`如果 obj 为 null，那么将返回 false`。

3、obj为class类的实例对象
--


4、obj为class接口的实现类
--


5、 obj为class类的直接或者间接子类
--


6、问题
--
编译器会检查 obj 是否能转换成右边的class类型，如果不能转换则直接报错，如果不能确定类型，则通过编译，具体看运行时定。

```
Person p1 = new Person();
 
System.out.println(p1 instanceof String);//编译报错
System.out.println(p1 instanceof List);//false
System.out.println(p1 instanceof List<?>);//false
System.out.println(p1 instanceof List<Person>);//编译报错
```

* 表达式 obj instanceof T，instanceof 运算符的 obj 操作数的类型必须是引用类型或空类型; 否则，会发生编译时错误。 
* 如果 obj 强制转换为 T 时发生编译错误，则关系表达式的 instanceof 同样会产生编译时错误。在这种情况下，表达式实例的结果永远为false。
* 在运行时，如果 T 的值不为null，并且 obj 可以转换为 T 而不引发ClassCastException，则instanceof运算符的结果为true。 否则结果是错误的
* 简单来说就是：如果 obj 不为 null 并且 (T) obj 不抛 ClassCastException 异常则该表达式值为 true ，否则值为 false 。
  
所以对于上面提出的问题就很好理解了，为什么 p1 instanceof String 编译报错，因为(String)p1 是不能通过编译的，而 (List)p1 可以通过编译。

7、instanceof的实现策略
--
1、obj如果为null，则返回false；否则设S为obj的类型对象，剩下的问题就是检查S是否为T的子类型；

2、如果S == T，则返回true；

3、接下来分为3种情况，之所以要分情况是因为instanceof要做的是“子类型检查”，而Java语言的类型系统里数组类型、接口类型与普通类类型三者的子类型规定都不一样，必须分开来讨论。

　　①、S是数组类型：如果 T 是一个类类型，那么T必须是Object；如果 T 是接口类型，那么 T 必须是由数组实现的接口之一；

　　②、接口类型：对接口类型的 instanceof 就直接遍历S里记录的它所实现的接口，看有没有跟T一致的；

　　③、类类型：对类类型的 instanceof 则是遍历S的super链（继承链）一直到Object，看有没有跟T一致的。遍历类的super链意味着这个算法的性能会受类的继承深度的影响。

