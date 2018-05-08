package com.lmt;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import java.io.Reader;

/**
 * MyBatis测试类，负责创建SqlSession以及SqlSession的Commit
 *
 * @author MT-Lin
 * @date 2018/05/08
 */
public class MyBatisTest {

    private static SqlSession sqlSession;

    @BeforeClass
    public static void setEnvironment() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = sqlSessionFactory.openSession();
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

    protected static SqlSession getSqlSession() {
        return sqlSession;
    }
}
