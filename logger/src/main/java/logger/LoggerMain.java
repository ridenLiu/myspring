package logger;

import logger.config.SpringConfig;
import logger.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class LoggerMain {

    static final Logger log = LoggerFactory.getLogger(LoggerMain.class);

    public static void main(String[] args) {
        log.info("==========start=============");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student s = app.getBean(Student.class);
        System.out.println(s);
        log.info("==========end=============");
    }

}
