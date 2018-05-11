package com.lmt.entity;

import com.lmt.mybatis.MyBatisEntity;

/**
 * 学生
 *
 * @author MT-Lin
 * @date 2018/05/06
 */
public class Student extends MyBatisEntity {

    private String stuName;
    private int stuAge;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
