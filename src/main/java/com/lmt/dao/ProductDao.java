package com.lmt.dao;

import com.lmt.entity.Product;

/**
 * 产品Dao
 *
 * @author MT-Lin
 * @date 2018/05/10
 */
public interface ProductDao {

    /**
     * 保存产品信息
     *
     * @param product 要保存的产品信息
     * @return 保存结果（1：成功）
     */
    int insert(Product product);

    /**
     * 删除产品
     *
     * @param id 要删除的产品的ID
     * @return 删除结果（1：成功）
     */
    int delete(String id);

    /**
     * 查询产品信息
     *
     * @param id 产品ID
     * @return 查询结果
     */
    Product get(String id);
}
