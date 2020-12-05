注解的底层是使用 `反射` 实现的。注解类里面，`只支持基本类型、String及枚举类型，里面所有的属性被定义成方法，并允许提供默认值`。

注解本质就是继承了Annotation接口的接口。

可以通过反编译得到结果。一个注解准确意义上来说，只不过是一种特殊的注释而已，如果没有解析它的代码，它可能连注释都不如。

解析一个类或者方法的注解往往有两种形式，一种是编译期直接的扫描，一种是运行期反射。
编译器的扫描指的是编译器在对 java 代码编译字节码的过程中会检测到某个类或者方法被一些注解修饰，这时它就会对于这些注解进行某些处理。

典型的就是注解 @Override，一旦编译器检测到某个方法被修饰了 @Override 注解，编译器就会检查当前方法的方法签名是否真正重写了父类的某个方法，也就是比较父类中是否具有一个同样的方法签名。

这一种情况只适用于那些编译器已经熟知的注解类，比如 JDK 内置的几个注解，而你自定义的注解，编译器是不知道你这个注解的作用的，当然也不知道该如何处理，往往只是会根据该注解的作用范围来选择是否编译进字节码文件，仅此而已。

1、什么是注解
--
注解也叫 _元数据_，JDK 1.5引入的一个特性，用于对代码进行说明，可以对包、类、接口、字段、方法参数、局部变量等进行注解。

常用注解分为3类：

> 1）Java自带的标准注解/内建注解，使用这些注解后编译器就会进行检查
```text
@Override 修饰对父类进行重写的方法
@Deprecated 标明某个类、方法或属性过时
@SuppressWarnings 抑制编译器生成警告信息。可以修饰类、方法、方法参数、属性和局部变量
```

> 2）`元注解`：用于定义注解的注解
```text
@Target 标明注解使用的范围
@Retention 标明注解被保留
@Documented 标明是否生成文档
@Inherited 标明是否允许子类继承父类中的注解
```
```text
@Target注解用于什么地方：
ANNOTATION_TYPE,//给注解注解（这貌似把自己不当类来看）
ElementType.FIELD  //注解作用于变量
ElementType.METHOD //注解作用于方法
ElementType.PARAMETER //注解作用于参数
ElementType.CONSTRUCTOR //注解作用于构造方法
ElementType.LOCAL_VARIABLE //注解作用于局部变量
ElementType.PACKAGE //注解作用于包

@Retention注解允许状态：
RetentionPolicy.SOURCE //源码状态运行，注解将编译器丢弃（该类型的注解信息只会保留在源码里，源码经过编译后，注解信息会被丢弃，不会保留在编译好的class文件里）
RetentionPolicy.CLASS //编译类文件时运行，注解在class中可用，但会被JVM丢弃（该类型的注解信息会保留在源码里和class文件里，在执行的时候，不会加载到虚拟机中）
RetentionPolicy.RUNTIME //运行时运行，JVM将在运行期也保留注解信息，因此可以通过反射机制读取注解信息（源码、class文件和执行的时候都有注解信息）

* 运行时注解就是运行时运用反射，动态获取对象、属性、方法等，一般的IoC框架就是这样，可能会牺牲一点效率。
* 编译时注解就是在程序编译是根据注解进行一些额外的操作，ButterKnife运用的就是编译时注解，ButterKnife在我们编译时，就根据注解，自动生成了一些辅助类。要玩编译时注解呢，你得先依赖apt，然后自己写一个类继承AbstractProcessor，重写process方法，在里面实现如何把配置或注解的信息变成所需要的类。

@Documented注解表示会被包含在javaapi文档中（当一个注解被@Documented元注解锁修饰时，那么无论在哪里使用这个注解，都会被Javadoc工具文档化）。

```

> 3）自定义注解

2、注解的用途
--
XML和注解区别：
* 注解：分散式的元数据，与源代码紧绑定。
* xml：是一种集中式的元数据，与源代码无绑定。

注解的主要用途：
```markdown
* 生成文档，通过代码里标识的元数据生成javadoc文档。
* 编译检查，通过代码里标识的元数据让编译器在编译期间进行检查验证。
* 编译时动态处理，编译时通过代码里标识的元数据动态处理，例如动态生成代码。
* 运行时动态处理，运行时通过代码里标识的元数据动态处理，例如使用反射注入实例
```

3、自定义实现运行时注解
--
```java
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CustomAnnotation {

    /**
     * 返回name，默认值为""
     *
     * @return
     */
    String name() default "";

    /**
     * 返回id，默认值为0
     *
     * @return
     */
    int id() default 0;
}
```

通过下面的方法将这个注解打印出来：
```
@Test
@CustomAnnotation(name = "chance", id = 1)
public void test() {

    Class<AnnotationTest> clazz = AnnotationTest.class;
    Method[] methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
        CustomAnnotation customAnnotation = method.getAnnotation(CustomAnnotation.class);
        if (customAnnotation != null) {
            System.out.println("annotation: " + "name------>" + customAnnotation.name() + "------>id------>" + customAnnotation.id());
        }
    }
}
```

4、AbstractProcessor类
--
运行时注解会影响程序的性能，毕竟在运行的时候有一个查找的过程。

编译时注解：在我们编译时，就根据注解，自动生成了一些辅助类。

要玩编译时注解，得先依赖apt，然后自己写一个类继承AbstractProcessor,重写process方法，在里面实现如何把配置或注解的信息变成所需要的类。这样在虚拟机进行编译的时候就会做相应的处理。

> 以下方法主要表明会处理哪些注解：
```
public Set<String> getSupportedOptions() {
    SupportedOptions so = this.getClass().getAnnotation(SupportedOptions.class);
    if  (so == null)
        return Collections.emptySet();
    else
        return arrayToSet(so.value());
}

public Set<String> getSupportedAnnotationTypes() {
    SupportedAnnotationTypes sat = this.getClass().getAnnotation(SupportedAnnotationTypes.class);
    if  (sat == null) {
        if (isInitialized())
            processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING,
                                                     "No SupportedAnnotationTypes annotation " +
                                                     "found on " + this.getClass().getName() +
                                                     ", returning an empty set.");
        return Collections.emptySet();
    }
    else
        return arrayToSet(sat.value());
}
```

> 然后就是在编译的时候的具体处理过程，这个过程主要是先找到并解析注解，然后生成java文件，这样在虚拟机真正执行的时候就不用去查找和解析，也就不会耗时了。

5、注解与反射
--
注解的本质就是一个继承了 Annotation 接口的接口，现在我们就来从虚拟机的层面看看，注解的本质到底是什么。

首先自定义一个注解类型：
```java
@Target(value = {ElementType.FIELD,ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Hello {
    
    String value();
}
```

这里指定了Hello这个注解只能修饰字段和方法，并且该注解永久存活，以便我们反射获取。

虚拟机规范定义了一系列和注解相关的属性表，也就是说，无论是字段、方法或是类本身，如果被注解修饰了，就可以被写进字节码文件。属性表有以下几种：
```text
RuntimeVisibleAnnotations：运行时可见的注解
RuntimeInVisibleAnnotations：运行时不可见的注解
RuntimeVisibleParameterAnnotations：运行时可见的方法参数注解
RuntimeInVisibleParameterAnnotations：运行时不可见的方法参数注解
AnnotationDefault：注解类元素的默认值
```

给大家看虚拟机的这几个注解相关的属性表的目的在于，让大家从整体上构建一个基本的印象，注解在字节码文件中是如何存储的。
所以，对于一个类或者接口来说，Class 类中提供了以下一些方法用于反射注解。
```text
getAnnotation：返回指定的注解
isAnnotationPresent：判定当前元素是否被指定注解修饰
getAnnotations：返回所有的注解
getDeclaredAnnotation：返回本元素的指定注解
getDeclaredAnnotations：返回本元素的所有注解，不包含父类继承而来的
```

方法、字段中相关反射注解的方法基本是类似的，下面看一个完整的例子。
首先设置一个虚拟机启动参数，用于捕获JDK动态代理类。

`-Dsun.misc.ProxyGenerator.saveGeneratedFiles=true`

```java
public class AnnotationTest {

    @Hello("hello")
    public static void main(String[] args) throws NoSuchMethodException {

        Class cls = AnnotationTest.class;
        Method method = cls.getMethod("main", String[].class);
        Hello hello = method.getAnnotation(Hello.class);

    }
}
```

注解本质上是继承了 Annotation 接口的接口，而当你通过反射，也就是这里的 getAnnotation 方法去获取一个注解类实例的时候，
其实 JDK 是通过动态代理机制生成一个实现我们注解（接口）的代理类。

* 代理类实现接口 Hello 并重写其所有方法，包括 value 方法以及接口 Hello 从 Annotation 接口继承而来的方法。
* 而这个关键的 InvocationHandler 实例是谁？
* AnnotationInvocationHandler 是 JAVA 中专门用于处理注解的 Handler。

```java
class AnnotationInvocationHandler implements InvocationHandler, Serializable {
    private static final long serialVersionUID = 6182022883658399397L;
    private final Class<? extends Annotation> type;
    private final Map<String, Object> memberValues;
    private transient volatile Method[] memberMethods = null;

    AnnotationInvocationHandler(Class<? extends Annotation> var1, Map<String, Object> var2) {
        Class[] var3 = var1.getInterfaces();
        if (var1.isAnnotation() && var3.length == 1 && var3[0] == Annotation.class) {
            this.type = var1;
            this.memberValues = var2;
        } else {
            throw new AnnotationFormatError("Attempt to create proxy for a non-annotation type.");
        }
    }
    
    // ......
}    
```

这里有一个memberValue，它是一个Map键值对，键是我们注解属性名称，值就是该属性当初被赋上的值。

```
public Object invoke(Object var1, Method var2, Object[] var3) {
    String var4 = var2.getName();
    Class[] var5 = var2.getParameterTypes();
    if (var4.equals("equals") && var5.length == 1 && var5[0] == Object.class) {
        return this.equalsImpl(var3[0]);
    } else if (var5.length != 0) {
        throw new AssertionError("Too many parameters for an annotation method");
    } else {
        byte var7 = -1;
        switch(var4.hashCode()) {
        case -1776922004:
            if (var4.equals("toString")) {
                var7 = 0;
            }
            break;
        case 147696667:
            if (var4.equals("hashCode")) {
                var7 = 1;
            }
            break;
        case 1444986633:
            if (var4.equals("annotationType")) {
                var7 = 2;
            }
        }

        switch(var7) {
        case 0:
            return this.toStringImpl();
        case 1:
            return this.hashCodeImpl();
        case 2:
            return this.type;
        default:
            Object var6 = this.memberValues.get(var4);
            if (var6 == null) {
                throw new IncompleteAnnotationException(this.type, var4);
            } else if (var6 instanceof ExceptionProxy) {
                throw ((ExceptionProxy)var6).generateException();
            } else {
                if (var6.getClass().isArray() && Array.getLength(var6) != 0) {
                    var6 = this.cloneArray(var6);
                }

                return var6;
            }
        }
    }
}
```

* 这个 invoke 方法就很有意思了，我们的代理类代理了 Hello 接口中所有的方法，所以对于代理类中任何方法的调用都会被转到这里来。
* var2 指向被调用的方法实例，而这里首先用变量 var4 获取该方法的简明名称，接着 switch 结构判断当前的调用方法是谁，如果是 Annotation 中的四大方法，将 var7 赋上特定的值。
* 如果当前调用的方法是 toString，equals，hashCode，annotationType 的话，AnnotationInvocationHandler 实例中已经预定义好了这些方法的实现，直接调用即可。
* 那么假如 var7 没有匹配上这四种方法，说明当前的方法调用的是自定义注解字节声明的方法，例如我们 Hello 注解的 value 方法。这种情况下，将从我们的注解 map 中获取这个注解属性对应的值。


最后我们再总结一下整个反射注解的工作原理：
* 首先，我们通过键值对的形式可以为注解属性赋值，像这样：@Hello（value = "hello"）。
* 接着，你用注解修饰某个元素，编译器将在编译期扫描每个类或者方法上的注解，会做一个基本的检查，你的这个注解是否允许作用在当前位置，最后会将注解信息写入元素的属性表。
* 然后，当你进行反射的时候，虚拟机将所有生命周期在 RUNTIME 的注解取出来放到一个 map 中，并创建一个 AnnotationInvocationHandler 实例，把这个 map 传递给它。
* 最后，虚拟机将采用 JDK 动态代理机制生成一个目标注解的代理类，并初始化好处理器。

那么这样，一个注解的实例就创建出来了，它本质上就是一个代理类，你应当去理解好 AnnotationInvocationHandler 中 invoke 方法的实现逻辑，这是核心。一句话概括就是，通过方法名返回注解属性值。

6、实现原理
--
三要素：
* 注解声明（元注解）
* 使用注解的元素（在你需要的地方加上对应的注解）
* 操作注解使其起作用（注解处理器）

> 注解使用的核心，到底java是如何去处理注解的呢

> 从getAnnotation进去可以看到java.lang.class实现了AnnotationElement接口：
```java
public final class Class<T> implements java.io.Serializable,
                              GenericDeclaration,
                              Type,
                              AnnotatedElement {

}
```

> java.lang.reflect.AnnotatedElement 接口是所有程序元素（Class、Method和Constructor）的父接口，所以程序通过反射获取了某个类的AnnotatedElement对象之后，程序就可以调用该对象的如下四个个方法来访问Annotation信息：
```text
方法1：<T extends Annotation> T getAnnotation(Class<T> annotationClass): 返回改程序元素上存在的、指定类型的注解，如果该类型注解不存在，则返回null。
　　方法2：Annotation[] getAnnotations():返回该程序元素上存在的所有注解。
　    方法3：boolean is AnnotationPresent(Class<?extends Annotation> annotationClass):判断该程序元素上是否包含指定类型的注解，存在则返回true，否则返回false.
　　方法4：Annotation[] getDeclaredAnnotations()：返回直接存在于此元素上的所有注释。与此接口中的其他方法不同，该方法将忽略继承的注释。（如果没有注释直接存在于此元素上，则返回长度为零的一个数组。）该方法的调用者可以随意修改返回的数组；这不会对其他调用者返回的数组产生任何影响
```

