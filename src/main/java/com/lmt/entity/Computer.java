package com.lmt.entity;

import com.lmt.mybatis.MyBatisEntity;
import org.apache.ibatis.type.Alias;

/**
 * Mybatis标签的使用
 *
 * @author MT-Lin
 * @date 2018/05/12
 */
@Alias("Computer")
public class Computer extends MyBatisEntity {

    private String trademark;
    private String owner;

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "trademark='" + trademark + '\'' +
                ", owner='" + owner + '\'' +
                ", id='" + id + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
