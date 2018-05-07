package com.lmt.mapper;

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
public class StudentMapperTest {

    private static SqlSession sqlSession;
    private static StudentMapper studentMapper;
    private static String idTemp;

    @BeforeClass
    public static void setEnvironment() throws Exception{
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = sqlSessionFactory.openSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);
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
        student.setStuName("琉璃书");
        student.setStuAge(23);
        int insertResult = studentMapper.insert(student);
        assertEquals(1, insertResult);
        idTemp = student.getId();
        System.err.println("After Insert Student ID:" + student.getId());
    }

    @Test
    public void B_get() {
        Student student = studentMapper.get(idTemp);
        assertNotNull(student);
        System.err.println("Get Student:" + student);
    }

    @Test
    public void C_listAll() {
        List<Student> students = studentMapper.listAll();
        assertNotEquals(0, students.size());
        System.err.println("List All Student:" + students);
    }

    @Test
    public void D_update() {
        Student student = studentMapper.get(idTemp);
        System.err.println("Update Before Student:" + student);
        student.setStuName("琉璃梳");
        int updateResult = studentMapper.update(student);
        assertEquals(1, updateResult);
        sqlSession.commit();
        student = studentMapper.get(idTemp);
        assertNotNull(student);
        System.err.println("Update After Student:" + student);
    }

    @Test
    public void E_delete() {
        int deleteResult = studentMapper.delete(idTemp);
        assertEquals(1, deleteResult);
        Student student = studentMapper.get(idTemp);
        System.err.println("After Delete Student: " + student);
        assertNull(student);
    }
}