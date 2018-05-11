package com.lmt.mapper;

import com.lmt.MyBatisTest;
import com.lmt.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.Reader;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest extends MyBatisTest {

    private static StudentMapper studentMapper;

    @BeforeClass
    public static void setMapper() {
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @Test
    public void A_insert() {
        Student student = new Student();
        student.setStuName("琉璃书");
        student.setStuAge(23);
        int insertResult = studentMapper.insert(student);
        assertEquals(1, insertResult);
        idTemp = student.getId();
        System.out.println("After Insert Student ID:" + student.getId());
    }

    @Test
    public void B_get() {
        Student student = studentMapper.get(idTemp);
        System.out.println("Get Student:" + student);
        assertNotNull(student);
    }

    @Test
    public void C_listAll() {
        List<Student> students = studentMapper.listAll();
        System.out.println("List All Student:" + students);
        assertNotEquals(0, students.size());
    }

    @Test
    public void D_update() {
        Student student = studentMapper.get(idTemp);
        System.out.println("Update Before Student:" + student);
        student.setStuName("琉璃梳");
        int updateResult = studentMapper.update(student);
        assertEquals(1, updateResult);
        sqlSession.commit();
        Student afterUpdateStudent = studentMapper.get(idTemp);
        System.out.println("Update After Student:" + afterUpdateStudent);
        assertNotEquals(student.getStuName(), afterUpdateStudent.getStuName());
    }

    @Test
    public void E_delete() {
        int deleteResult = studentMapper.delete(idTemp);
        assertEquals(1, deleteResult);
        Student student = studentMapper.get(idTemp);
        System.out.println("After Delete Student: " + student);
        assertNull(student);
    }
}