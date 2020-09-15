package com.chance.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-02-09
 */
public class FilteringApples {
    public static void main(String... args) {

        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);

        // []
        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 ||
                "brown".equals(a.getColor()));
        System.out.println(weirdApples);

        //将其转换为stream，进行并行处理，然后再转换回List
        List<Apple> heavyApples3 = inventory.stream()
                .filter((Apple a) -> a.getWeight() > 150)
                .collect(Collectors.toList());
        System.out.println(heavyApples3);

        //将其转换为parallelStream，进行并行处理，然后再转换回List
        List<Apple> heavyApples4 = inventory.parallelStream()
                .filter((Apple a) -> a.getWeight() > 150)
                .collect(Collectors.toList());
        System.out.println(heavyApples4);

        prettyPrintApple(inventory, new AppleFancyFormatter());

        //使用匿名类实现ApplePredicate的对象
        List<Apple> redApples = filterApples1(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        List<Apple> result = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));

        List<Apple> red = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));

        List<Integer> numbers = Arrays.asList(4, 5, 6, 7);
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);

        //使用匿名函数
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        //使用Lambda表达式
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("Hello world!"));
        Predicate<Apple> p = (Apple a) -> ("red").equals(a.getColor());

    }

    /**
     * 筛选出绿苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, String color,
                                           int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            boolean existed = (flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight);
            if (existed) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 筛选出重量超过150g的苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    /**
     * 筛选苹果
     *
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 接受一个ApplePredicate对象
     *
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterApples1(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory,
                                        AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    /**
     * 将List类型抽象化
     *
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    /**
     * Apple类
     */
    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
