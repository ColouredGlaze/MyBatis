package com.lmt.dao;

import com.lmt.entity.Book;

/**
 * 一对多，书本DAO
 *
 * @author MT-Lin
 * @date 2018/05/08
 */
public interface BookDao {

    /**
     * 保存书本
     *
     * @param book 要保存的书本信息
     * @return 保存结果（1：成功）
     */
    int insert(Book book);

    /**
     * 根据ID查询书本
     *
     * @param id 书本ID
     * @return 查询结果
     */
    Book get(String id);

    /**
     * 删除书本
     *
     * @param id 要删除的书本的ID
     * @return 删除结果（1：成功）
     */
    int delete(String id);
}
