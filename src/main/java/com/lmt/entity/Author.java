package com.lmt.entity;

import com.lmt.mybatis.MyBatisEntity;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 一对多，一个作者有多本书
 *
 * @author MT-Lin
 * @date 2018/05/08
 */
@Alias("Author")
public class Author extends MyBatisEntity {

    private String fullName;
    private List<Book> books;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
