package com.lmt.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

/**
 * 一对多，一个作者有多本书
 *
 * @author MT-Lin
 * @date 2018/05/08
 */
@Alias("Author")
public class Author {

    private String id;
    private String fullName;
    private Date gmtCreate;
    private Date gmtModified;
    private List<Book> books;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", books=" + books +
                '}';
    }
}
