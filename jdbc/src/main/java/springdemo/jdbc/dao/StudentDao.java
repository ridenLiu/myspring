package springdemo.jdbc.dao;

import springdemo.jdbc.entity.Student;


public interface StudentDao {

    Student selectByPk(String id);

    void change();

}
