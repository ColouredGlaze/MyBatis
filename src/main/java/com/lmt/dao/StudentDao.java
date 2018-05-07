package com.lmt.dao;

import com.lmt.entity.Student;

import java.util.List;

/**
 * 学生DAO
 *
 * @author MT-Lin
 * @date 2018/05/06
 */
public interface StudentDao {

    /**
     * 保存学生数据
     *
     * @param student 要保存的学生
     * @return 数据库影响条数
     */
    int insert(Student student);

    /**
     * 根据ID查询学生
     *
     * @param id 学生ID
     * @return 查询结果
     */
    Student get(String id);

    /**
     * 查询所有学生
     * @return 所有学生数据
     */
    List<Student> listAll();

    /**
     * 更新学生数据
     * @param student 要更新的学生
     * @return 数据库影响条数
     */
    int update(Student student);

    /**
     * 删除学生数据
     *
     * @param id 要删除的学生的ID
     * @return 数据库影响条数
     */
    int delete(String id);
}
