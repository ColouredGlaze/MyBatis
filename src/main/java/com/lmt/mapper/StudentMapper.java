package com.lmt.mapper;

import com.lmt.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 注解方式配置Mapper，不需要Mapper.xml配置文件
 *
 * @author MT-Lin
 * @date 2018/05/07
 */
public interface StudentMapper {

    /**
     * 保存学生数据
     *
     * @param student 要保存的学生
     * @return 数据库影响条数
     */
    @SelectKey(statement = "SELECT REPLACE(UUID(), '-', '') AS id FROM DUAL",
            keyProperty = "id",
            resultType = String.class,
            before = true)
    @Insert("INSERT INTO student(id, stu_name, stu_age) VALUES (#{id}, #{stuName}, #{stuAge})")
    int insert(Student student);

    /**
     * 根据ID查询学生
     *
     * @param id 学生ID
     * @return 查询结果
     */
    @Results(id = "studentResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "stuName", column = "stu_name"),
            @Result(property = "stuAge", column = "stu_age"),
            @Result(property = "gmtCreate", column = "gmt_Create"),
            @Result(property = "gmtModified", column = "gmt_modified")
    })
    @Select("SELECT * FROM student WHERE id = #{id}")
    Student get(String id);

    /**
     * 查询所有学生
     * @return 所有学生数据
     */
    @Results(id = "studentResults", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "stuName", column = "stu_name"),
            @Result(property = "stuAge", column = "stu_age"),
            @Result(property = "gmtCreate", column = "gmt_Create"),
            @Result(property = "gmtModified", column = "gmt_modified")
    })
    @Select("SELECT * FROM student")
    List<Student> listAll();

    /**
     * 更新学生数据
     * @param student 要更新的学生
     * @return 数据库影响条数
     */
    @Update("UPDATE student SET stu_name = #{stuName}, stu_age = #{stuAge} WHERE id = #{id}")
    int update(Student student);

    /**
     * 删除学生数据
     *
     * @param id 要删除的学生的ID
     * @return 数据库影响条数
     */
    @Delete("DELETE FROM student WHERE id = #{id}")
    int delete(String id);
}
