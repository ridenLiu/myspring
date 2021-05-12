package springdemo.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springdemo.jdbc.config.SpringConfig;
import springdemo.jdbc.dao.StudentDao;
import springdemo.jdbc.entity.Student;

public class SpringMain {

    public static void main(String[] args) {
        System.out.println("start");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentDao dao = app.getBean(StudentDao.class);
        System.out.println(dao.selectByPk("S1101001"));
        System.out.println("over");
    }
}
