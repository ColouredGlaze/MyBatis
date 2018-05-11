package com.lmt.mybatis;

import java.util.Date;
import java.util.Objects;

/**
 * 包含公共字段
 *
 * @author MT-Lin
 * @date 2018/05/10
 */
public class MyBatisEntity {

    protected String id;
    protected Date gmtCreate;
    protected Date gmtModified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
