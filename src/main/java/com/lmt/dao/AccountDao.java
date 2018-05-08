package com.lmt.dao;

import com.lmt.entity.Account;

/**
 * 帐号Dao
 *
 * @author MT-Lin
 * @date 2018/05/08
 */
public interface AccountDao {

    /**
     * 保存帐号
     *
     * @param account 要保存的帐号信息
     * @return 保存结果（1：成功）
     */
    int insert(Account account);

    /**
     * 根据ID查询帐号
     *
     * @param id 帐号ID
     * @return 查询结果
     */
    Account get(String id);

    /**
     * 删除帐号
     *
     * @param id 要删除的帐号的ID
     * @return 删除结果（1：成功）
     */
    int delete(String id);
}
