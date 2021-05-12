package logger.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Student {
    private String studentno;

    private Integer loginpwd;

    private String studentname;

    private String sex;

    private Integer gradeid;

    private String phone;

    private String address;

    private Date borndate;

    private String email;

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    public Integer getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(Integer loginpwd) {
        this.loginpwd = loginpwd;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentno=").append(studentno);
        sb.append(", loginpwd=").append(loginpwd);
        sb.append(", studentname=").append(studentname);
        sb.append(", sex=").append(sex);
        sb.append(", gradeid=").append(gradeid);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append(", borndate=").append(borndate);
        sb.append(", email=").append(email);
        sb.append("]");
        return sb.toString();
    }
}
