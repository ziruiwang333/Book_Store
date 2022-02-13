package com.bookstore.test;

import java.lang.reflect.Method;

public class UserServletTest {

    public static void main(String[] args) {
        String action = "regist";
        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login(){
        System.out.println("login");
    }

    public void regist(){
        System.out.println("regist");
    }

    public void updateUser(){
        System.out.println("updateUser");
    }

}
