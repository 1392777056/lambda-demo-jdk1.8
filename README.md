package com.dezheyun.common.lambda;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author dezhe
 * @Date 2019/7/19 9:30
 *
 * java.util.function
 *
 * 常见的函数式接口：
 * Supplier   用来提供一个数据-->生产者
 * 可以调用抽象方法get来拿到一个指定的泛型的结果数据
 * Comsumer   消费者   制定以及好的方案然后在往里添加东西进行操作
 * Predicate  如果希望描述某种类型进行判断方法，那么可以使用Predicate<T> 接口
 * function  接口当中的andThen可以将两个function函数操作组合起来，成为新的函数模型
 *
 *
 * 主要事项：
 * 如果Lambda当中希望使用所在方法外面的局部变量，
 * 那么这个局部变量是有效final的。
 */
public class SupplierTest {

    public static void main(String[] args) {
        getSupplier(() ->1);
        int[] arr = {10,20,100,500,80};
        //定义一个方法，用来打印数组中的最大值，但是这个方法本身并不关心如何拿到最大值
        Supplier<Integer> supplier = () -> {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i]>max){
                    max = arr[i];
                }
            }
            return max;
        };
        getMaxNum(supplier);
        //consumer
        getConsumer(s -> System.out.println(s.toUpperCase()));
        getConsumer(System.out::print);
        System.out.println("===");
        towComsumer(s -> System.out.println(s.toUpperCase()),s -> System.out.println(s.toLowerCase()));
        System.out.println("===================");
        String[] array = {"迪丽热巴,女","古力娜扎,女","马尔扎哈,男"};
        threeComsumer(array,s -> System.out.print("姓名:"+s.split(",")[0]),s -> System.out.print("性别："+ s.split(",")[1]));
        System.out.println("===================");
        //Predicate  传递进去的如何进行判断的规则方案
        onePredicateTest(s -> s.length() < 5);
        twoPredicateTest(s -> s.length()>9,s -> s.startsWith("c"));
        orPredicateTest(s -> s.length()>3,s -> s.startsWith("c"));
        negatePredicateTest(s -> s.startsWith("s"));
        String[] arrs = {"迪丽热巴,女","古力娜扎,女","马尔扎哈,男","赵丽颖,女"};
        ArrayList<String> list = getOpREDICATE(s -> s.split(",")[1].equals("女"), s -> s.split(",")[0].length() == 4, arrs);
        list.forEach(System.out::println);

        //function
        System.out.println("--------------------");
        getFunction(Integer::parseInt);
        method(Integer::parseInt,s->s+10);
        System.out.println("--------------------");
        String str = "赵丽颖,20";
        functionMethod(str,s -> s.split(",")[1],Integer::parseInt,s->s+=100);
    }

    /**
     * 将字符串截取数字年龄部分，得到字符串
     * 将上一步的字符串转换成为int类型的数字
     * 将上一步的int数字累加100  得到结果int数字
     */
    private static void functionMethod(String str,Function<String,String> one,Function<String,Integer> two,Function<Integer,Integer> three) {
        int num = one.andThen(two).andThen(three).apply(str);
        System.out.println(num);
    }

    private static void method(Function<String,Integer> one,Function<Integer,Integer> two){
        int num = one.andThen(two).apply("10");
        System.out.println(num);
    }

    private static void getFunction(Function<String,Integer> function) {
        Integer apply = function.apply("23");
        int num = apply + 10;
        System.out.println(num);
    }

    /**
     * 数组中有多条 姓名+性别 的信息，将字符串筛选到集合ArrayList中，需要满足两个条件 必须为女生，姓名为4个字
     */
    private static ArrayList<String> getOpREDICATE(Predicate<String> one,Predicate<String> two,String[] arr){
        ArrayList<String> list = new ArrayList<>();
        for (String array : arr) {
            if (one.and(two).test(array)){
                list.add(array);
            }
        }
        return list;
    }


    private static void negatePredicateTest(Predicate<String> one){
        boolean ceshei = one.negate().test("ceshei");
        System.out.println(ceshei);
    }

    private static void orPredicateTest(Predicate<String> one,Predicate<String> two){
        boolean ceshei = one.or(two).test("ceshei");
        System.out.println(ceshei);
    }

    private static void twoPredicateTest(Predicate<String> one,Predicate<String> two){
        boolean ceshei = one.and(two).test("ceshei");
        System.out.println(ceshei);
    }

    private static void onePredicateTest(Predicate<String> predicate){
        boolean test = predicate.test("111");
        System.out.println(test);
    }


    private static void threeComsumer(String[] arr,Consumer<String> one,Consumer<String> two){
        for (String s : arr) {
            one.andThen(two).accept(s);
        }
    }

    private static void towComsumer(Consumer<String> one,Consumer<String> two){
        one.andThen(two).accept("hello");
    }

    private static void getConsumer(Consumer<String> consumer){
        consumer.accept("hello");
    }

    private static void getMaxNum(Supplier<Integer> supplier){
        Integer integer = supplier.get();
        System.out.println(integer);
    }

    private static void getSupplier(Supplier<Integer> supplier){
        Integer s = supplier.get();
        System.out.println(s);
    }

}
