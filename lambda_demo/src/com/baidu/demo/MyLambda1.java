package com.baidu.demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/8/19 21:05
 */
public class MyLambda1 {

    public static void main(String[] args) {

        User[] array = {
          new User(1,"张三",18),
          new User(2,"张三",20),
          new User(1,"张三",19)
        };

        // 使用传统的方式去排序
        /* Arrays.sort(array, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        });*/

        // 使用标准的Lambda 方式去排序
        /*Arrays.sort(array,(User o1,User o2) -> {
            return o1.getAge() - o2.getAge();
        });*/

        // 使用省略的Lambda 方式去排序
        Arrays.sort(array,(a,b) -> a.getAge() - b.getAge());

        // 后面会学习到
        Arrays.sort(array,Comparator.comparingInt(User::getAge));

        for (User user : array) {
            System.out.println(user);
        }


    }

}
