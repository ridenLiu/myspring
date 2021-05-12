package com.riden.spring;

import com.riden.spring.config.SpringConfig;
import com.riden.spring.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {SpringConfig.class})

// SpringJUnitConfig和上面两个注解的效果一样
@SpringJUnitConfig(classes = {SpringConfig.class})
public class Junit5Main {

    @Autowired
    Student s;

    @Test
    public void test() {
        System.out.println(s);
    }

}
