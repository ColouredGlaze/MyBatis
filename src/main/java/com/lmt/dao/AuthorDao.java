package com.lmt.dao;

import com.lmt.entity.Author;

/**
 * 一对多，作者Dao
 *
 * @author MT-Lin
 * @date 2018/05/08
 */
public interface AuthorDao {

    /**
     * 保存作者
     *
     * @param author 要保存的作者信息
     * @return 保存结果（1：成功）
     */
    int insert(Author author);

    /**
     * 根据ID查询作者以及作者的所有书本
     *
     * @param authorId 作者ID
     * @return 查询结果
     */
    Author getAuthorAndBooks(String authorId);

    /**
     * 删除作者
     *
     * @param id 要删除的作者的ID
     * @return 删除结果（1：成功）
     */
    int delete(String id);
}
