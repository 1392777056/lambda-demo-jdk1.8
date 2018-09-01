package com.baidu.demo;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/8/19 21:24
 */
public class MyLambda2 {

    public static void main(String[] args) {

        method(() -> System.out.println("吃饭"));

        method2(10,20,(a,b) -> a + b);

    }

    private static void method(LambdaEat lambda) {
        lambda.eat();
    }

    private static void method2(int one,int two,LambdaNum lambdaNum) {
        int result = lambdaNum.getNum(one,two);
        System.out.println("结果：" + result);

    }


}
