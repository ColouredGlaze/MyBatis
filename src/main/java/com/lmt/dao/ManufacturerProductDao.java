package com.lmt.dao;

import com.lmt.entity.ManufacturerProduct;
import org.apache.ibatis.annotations.Param;

/**
 * 制造商-产品Dao
 *
 * @author MT-Lin
 * @date 2018/05/10
 */
public interface ManufacturerProductDao {

    /**
     * 保存产品-制造商信息
     *
     * @param manufacturerProduct 制造商-产品信息
     * @return 保存结果（1：成功）
     */
    int insert(ManufacturerProduct manufacturerProduct);

    /**
     * 查询制造商-产品信息
     *
     * @param manufacturerId 制造商ID
     * @param productId 产品ID
     * @return 查询结果，因为制造商ID和产品ID不可能同时相同，同时相同就重复了，所以返回的是一个对象，数据库中需要为manufacturer_id列和
     * product_id列创建唯一约束
     */
    ManufacturerProduct get(@Param("manufacturerId") String manufacturerId, @Param("productId") String productId);
}
