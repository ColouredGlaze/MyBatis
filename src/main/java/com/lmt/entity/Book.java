package com.lmt.entity;

import com.lmt.mybatis.MyBatisEntity;
import org.apache.ibatis.type.Alias;

/**
 * 一对多，书
 *
 * @author MT-Lin
 * @date 2018/05/08
 */
@Alias("Book")
public class Book extends MyBatisEntity {

    private String title;
    private Author author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
