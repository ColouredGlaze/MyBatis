package com.lmt.dao;

import com.lmt.entity.Computer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 电脑DAO
 *
 * @author MT-Lin
 * @date 2018/05/12
 */
public interface ComputerDao {

    /**
     * 保存电脑信息
     *
     * @param computer 要保存的电脑信息
     * @return 保存结果（1：成功）
     */
    int insert(Computer computer);

    /**
     * 批量保存电脑信息
     *
     * @param computers 要保存的电脑信息
     * @return 保存结果
     */
    int insertAll(List<Computer> computers);

    /**
     * 根据ID查询电脑信息
     *
     * @param id 电脑ID
     * @return 查询结果
     */
    Computer get(String id);

    /**
     * 查询所有电脑
     *
     * @return 所有电脑数据
     */
    List<Computer> listAll();

    /**
     * 更新电脑信息（使用 trim 标签）
     * @param computer 要更新的电脑信息
     * @return 更新结果（1：成功）
     */
    int updateByTrim(Computer computer);

    /**
     * 更新电脑信息（使用 set 标签）
     * @param computer 要更新的电脑信息
     * @return 更新结果（1：成功）
     */
    int updateBySet(Computer computer);

    /**
     * 根据品牌名字和拥有者查询（使用 trim 标签）
     *
     * @param trademark 品牌名字
     * @param owner 拥有者名字
     * @return 拥有者的所有电脑
     */
    List<Computer> listByTrademarkAndOwnerByTrim(@Param("trademark") String trademark, @Param("owner") String owner);

    /**
     * 根据电脑属性查询（使用 where if 标签）
     *
     * @param computer 电脑属性
     * @return 符合该电脑属性的电脑信息
     */
    List<Computer> listByTrademarkAndOwnerByWhere(Computer computer);

    /**
     * 根据品牌名字和拥有者查询（使用 choose when otherwise 标签）
     *
     * @param computer 电脑属性
     * @return 符合该电脑属性的电脑信息
     */
    List<Computer> listByTrademarkAndOwnerByChoose(Computer computer);

    /**
     * 删除电脑信息
     *
     * @param id 要删除的电脑的ID
     * @return 删除结果（1：成功）
     */
    int delete(String id);

    /**
     * 批量删除电脑信息（使用 foreach 标签）
     * @param computers 要删除的电脑信息
     * @return 删除结果
     */
    int deleteAll(List<Computer> computers);
}
