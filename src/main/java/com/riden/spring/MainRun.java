package com.riden.spring;

import com.riden.spring.config.SpringConfig;
import com.riden.spring.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class MainRun {


    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student s2 = app.getBean(Student.class);
        System.out.println(s2);
    }

}
