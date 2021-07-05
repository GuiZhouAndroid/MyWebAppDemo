package com.example.MyWebAppDemo.model;

public class StudentBean {
    private Integer stu_id;//学生id
    private String stu_no;//学号
    private String stu_name;//姓名
    private String stu_class;//班级
    private String stu_age;//年龄
    private String stu_sex;//性别
    private String stu_birthday;//生日

    public StudentBean() {

    }

    public StudentBean(Integer stu_id, String stu_no, String stu_name, String stu_class, String stu_age, String stu_sex, String stu_birthday) {
        this.stu_id = stu_id;
        this.stu_no = stu_no;
        this.stu_name = stu_name;
        this.stu_class = stu_class;
        this.stu_age = stu_age;
        this.stu_sex = stu_sex;
        this.stu_birthday = stu_birthday;
    }


    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_no() {
        return stu_no;
    }

    public void setStu_no(String stu_no) {
        this.stu_no = stu_no;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_class() {
        return stu_class;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }

    public String getStu_age() {
        return stu_age;
    }

    public void setStu_age(String stu_age) {
        this.stu_age = stu_age;
    }

    public String getStu_sex() {
        return stu_sex;
    }

    public void setStu_sex(String stu_sex) {
        this.stu_sex = stu_sex;
    }

    public String getStu_birthday() {
        return stu_birthday;
    }

    public void setStu_birthday(String stu_birthday) {
        this.stu_birthday = stu_birthday;
    }
    @Override
    public String toString() {
        return "StudentBean{" +
                "stu_id=" + stu_id +
                ", stu_no='" + stu_no + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", stu_class='" + stu_class + '\'' +
                ", stu_age='" + stu_age + '\'' +
                ", stu_sex='" + stu_sex + '\'' +
                ", stu_birthday='" + stu_birthday + '\'' +
                '}';
    }
}
