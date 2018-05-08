package com.lmt.dao;

import com.lmt.entity.Phone;

import java.util.List;

/**
 * 一对一关联，电话Dao
 *
 * @author MT-Lin
 * @date 2018/05/08
 */
public interface PhoneDao {

    /**
     * 保存电话信息
     *
     * @param phone 要保存的电话信息
     * @return 保存结果
     */
    int insert(Phone phone);

    /**
     * 根据电话ID查找
     *
     * @param phoneId 电话ID
     * @return 查询结果
     */
    Phone get(String phoneId);

    /**
     * 获取所有电话信息
     *
     * @return 所有电话数据
     */
    List<Phone> listAll();

    /**
     * 删除电话信息
     *
     * @param id 要删除的电话信息的ID
     * @return 删除结果
     */
    int delete(String id);
}
