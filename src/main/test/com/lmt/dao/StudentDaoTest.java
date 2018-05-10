package com.lmt.dao;

import com.lmt.MyBatisTest;
import com.lmt.entity.Student;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentDaoTest extends MyBatisTest {

    private static StudentDao studentDao;

    @BeforeClass
    public static void setDao() {
        studentDao = sqlSession.getMapper(StudentDao.class);
    }

    @Test
    public void A_insert() {
        Student student = new Student();
        student.setStuName("九离殇");
        student.setStuAge(23);
        int insertResult = studentDao.insert(student);
        assertEquals(1, insertResult);
        idTemp = student.getId();
        System.out.println("After Insert Student ID:" + student.getId());
    }

    @Test
    public void B_get() {
        Student student = studentDao.get(idTemp);
        assertNotNull(student);
        System.out.println("Get Student:" + student);
    }

    @Test
    public void C_listAll() {
        List<Student> students = studentDao.listAll();
        assertNotEquals(0, students.size());
        System.out.println("List All Student:" + students);
    }

    @Test
    public void D_update() {
        Student student = studentDao.get(idTemp);
        System.out.println("Update Before Student:" + student);
        student.setStuName("酒离殇");
        int updateResult = studentDao.update(student);
        assertEquals(1, updateResult);
        sqlSession.commit();
        student = studentDao.get(idTemp);
        assertNotNull(student);
        System.out.println("Update After Student:" + student);
    }

    @Test
    public void E_delete() {
        int deleteResult = studentDao.delete(idTemp);
        assertEquals(1, deleteResult);
        Student student = studentDao.get(idTemp);
        System.out.println("After Delete Student:" + student);
        assertNull(student);
    }
}