package com.lmt.entity;

import com.lmt.mybatis.MyBatisEntity;

/**
 * 一对一关联，一个帐号对应一个手机号
 *
 * @author MT-Lin
 * @date 2018/05/08
 */
public class Account extends MyBatisEntity {

    private String accountEmail;

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", accountEmail='" + accountEmail + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
