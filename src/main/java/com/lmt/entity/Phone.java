package com.lmt.entity;

import com.lmt.mybatis.MyBatisEntity;

/**
 * 一对一关联，一个手机号码对应一个帐号
 *
 * @author MT-Lin
 * @date 2018/05/08
 */
public class Phone extends MyBatisEntity {

    private String phoneNumber;
    private Account account;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", account=" + account +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
