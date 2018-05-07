package com.lmt.dao;

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
public class StudentDaoTest {

    private static SqlSession sqlSession;
    private static StudentDao studentDao;
    private static String idTemp;

    @BeforeClass
    public static void setEnvironment() throws Exception{
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = sqlSessionFactory.openSession();
        studentDao = sqlSession.getMapper(StudentDao.class);
    }

    @AfterClass
    public static void clearResources(){
        sqlSession.close();
    }

    @Before
    public void setUp(){
    }

    @After
    public void tearDown(){
        sqlSession.commit();
    }

    @Test
    public void A_insert() {
        Student student = new Student();
        student.setStuName("九离殇");
        student.setStuAge(23);
        int insertResult = studentDao.insert(student);
        assertEquals(1, insertResult);
        idTemp = student.getId();
        System.err.println("After Insert Student ID:" + student.getId());
    }

    @Test
    public void B_get() {
        Student student = studentDao.get(idTemp);
        assertNotNull(student);
        System.err.println("Get Student:" + student);
    }

    @Test
    public void C_listAll() {
        List<Student> students = studentDao.listAll();
        assertNotEquals(0, students.size());
        System.err.println("List All Student:" + students);
    }

    @Test
    public void D_update() {
        Student student = studentDao.get(idTemp);
        System.err.println("Update Before Student:" + student);
        student.setStuName("酒离殇");
        int updateResult = studentDao.update(student);
        assertEquals(1, updateResult);
        sqlSession.commit();
        student = studentDao.get(idTemp);
        assertNotNull(student);
        System.err.println("Update After Student:" + student);
    }

    @Test
    public void E_delete() {
        int deleteResult = studentDao.delete(idTemp);
        assertEquals(1, deleteResult);
        Student student = studentDao.get(idTemp);
        System.err.println("After Delete Student:" + student);
        assertNull(student);
    }
}