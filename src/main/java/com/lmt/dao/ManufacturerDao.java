package com.lmt.dao;

import com.lmt.entity.Manufacturer;

/**
 * 制造商Dao
 *
 * @author MT-Lin
 * @date 2018/05/10
 */
public interface ManufacturerDao {

    /**
     * 保存制造商信息
     *
     * @param manufacturer 要保存的制造商信息
     * @return 保存结果（1：成功）
     */
    int insert(Manufacturer manufacturer);

    /**
     * 删除制造商
     *
     * @param id 要删除的制造商的ID
     * @return 删除结果（1：成功）
     */
    int delete(String id);

    /**
     * 查询制造商信息
     *
     * @param id 制造商ID
     * @return 查询结果
     */
    Manufacturer get(String id);
}
