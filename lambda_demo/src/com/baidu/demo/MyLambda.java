package com.baidu.demo;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/8/19 20:53
 */

/**
 * ==========================    JDK 1.8的 新特性    ==========================
 * Lambda的省略规则：
 * 1、参数类型可以省略。
 * 2、如果参数有且仅有一个语句，那么小括号可以省略。
 * 3、如果大括号中有且仅有一个语句，那么无论有没有返回值，return、分号和大括号都可以省略。
 *
 *
 * Lambda的原则：可推导可省略。
 *
 * Lambda使用的前提：
 *      1.必须是接口
 *      2.接口上有且仅有一个抽象方法（注：可以加上@FunctionalInterface去判断是否是lambda，和@Override本质上是相同的）
 *      3.必须有上下文推导
 *
 * 方法引用：为了减少重复代码使用 --- 反正重复造轮子 （重要的两种）   一共四种；
 * 1. 对象名::成员方法
 * 2. 类名称::静态方法
 * 3. super::父类方法
 * 4. this::本类方法
 *
 * 5、构造器的使用
 * 类名称::new
 *
 * 6、数组的引用
 * String::new
 *
 * 其实使用Lambda作为方法返回值或者方法参数，本质上就是使用函数式接口作为返回值以及参数。
 *
 * 方法引用 ---  System.out::println
 *
 * 还提供了四个常用的函数接口
 * Supplier   提供者 提供一个对象
 * Comsumer   消费者 怎么去消费一个
 * Predicate  条件规则
 * Function   实现 例如将 字符串 转换成为 数字
 *
 */
public class MyLambda {

    public static void main(String[] args) {

        // 使用传统的方式去开启线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("传统方式去开启线程！");
            }
        }).start();

        // 使用Lambda 标准格式去开启线程
        new Thread(() -> {
            System.out.println("Lambda标准格式去开启线程！");
        }).start();

        // 使用Lambda 省略格式去开启线程
        new Thread(() -> System.out.println("Lambda省略格式去开启线程！")).start();

    }

}
