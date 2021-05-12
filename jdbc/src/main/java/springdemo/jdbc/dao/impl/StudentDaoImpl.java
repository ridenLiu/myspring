package springdemo.jdbc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springdemo.jdbc.dao.StudentDao;
import springdemo.jdbc.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Student selectByPk(String id) {
        String sql = "select * from student_copy1 where studentno = ?";
        Student res = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), id);
        return res;
    }

    /**
     * 模拟一个转账
     * <p>
     * Transactional注解用于开启事务,可以放到类上或方法上
     * 该注解中可以配置一下参数:
     * 1. propagation 事务传播行为:
     * 在事务方法中调用其他方法,或在其他方法中调用事务方法的处理方式
     * <p>
     * 2. isolation 事务隔离级别: 处理多事务之间的相互影响
     * 2.1 脏读: 一个未提交事务读取到另外一个未提交事务的数据
     * 2.2 不可重复读: 一个未提交的事务读取到另外一个以及提交事务的数据
     * 2.3 幻读:
     * <p>
     * 3. timeout 超时限制,默认值为-1(不设置超时),单位为秒
     * <p>
     * 4. readOnly 是否只读,默认值为false,如果为true那么就只能查询数据库,不能修改
     * <p>
     * 5. rollbackFor 出现那些异常进行事务回滚
     * <p>
     * 5. noRollbackFor 出现那些异常不进行回滚
     */
    @Override
    @Transactional
    public void change() {
        String sql1 = "UPDATE mytest.student_copy1 t SET t.money = t.money-10 WHERE t.studentno = 'S1101001'";
        String sql2 = "UPDATE mytest.student_copy1 t SET t.money = t.money+10 WHERE t.studentno = 'S1101002'";
        jdbcTemplate.update(sql1);
//        int a = 10/0;
        jdbcTemplate.update(sql2);
    }
}
