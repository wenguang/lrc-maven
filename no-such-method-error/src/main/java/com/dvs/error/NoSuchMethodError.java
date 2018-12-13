package com.dvs.error;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NoSuchMethodError {
    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        String str = (String)cxt.getBean("str");
        System.out.println(str);
    }
}
