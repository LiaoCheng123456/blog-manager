package com.service.blog.test;

public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.say();
                }
            }).start();
        }
    }

    public static void say(){
        hello();
        hello();
        hello();
        hello();
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }


    public static void hello() {
//        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
