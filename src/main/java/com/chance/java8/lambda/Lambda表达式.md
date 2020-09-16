因为接口中可以增加默认的方法实现。那么肯定要简化开发才出现的这个么设计。所以会从各个我们以前的List、Set等等所有接口中看到默认的方法实现。

```
List<String> names = Arrays.asList("perter", "anna", "mike", "xenia");

// 1.jdk 1.8之前的写法
Collections.sort(names, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
});

// 2.jdk 1.8
Collections.sort(names, (String a, String b) -> {
    return b.compareTo(a);
});

// 3.简化（当然过你的实现不是一行代码，那么不能这么干）
Collections.sort(names, (String a, String b) -> b.compareTo(a));
// 4.java.util.List 集合现在已经添加了 sort 方法。而且 Java 编译器能够根据类型推断机制判断出参数类型，这样，连入参的类型都可以省略
Collections.sort(names, (a, b) -> b.compareTo(a));

// 5.Comparator接口中还提供了stack默认方法，也就是说接口中不是只可有default默认实现，还可以有静态方法
Collections.sort(names, Comparator.reverseOrder());
```

