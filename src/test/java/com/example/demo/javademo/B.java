package com.example.demo.javademo;

/**
 * Created by constanting on 2018/7/8.
 */
public class B extends A{

    static {
        System.out.println("static B");
    }

    public B(){
        System.out.println("B");
    }

//    public static void main(String[] args) {
//        A a = new B();
//        System.out.println("----------------------");
//        a = new B();
//    }

    public static void main(String[] args) {
        System.out.println(demo());
    }


    static String demo(){
        try{
            return "try";
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return "finally";
        }
    }

}
