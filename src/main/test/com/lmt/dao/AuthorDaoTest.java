package com.lmt.dao;

import com.lmt.MyBatisTest;
import com.lmt.entity.Author;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorDaoTest extends MyBatisTest {

    private static AuthorDao authorDao;

    /**
     * 作者卡勒德·胡赛尼（追风筝的人、灿烂千阳、群山回唱）的ID
     */
    private static String authorIdTemp = "7b9ff9a9540011e88b7854e1ad6e4031";

    @BeforeClass
    public static void setDao(){
        authorDao = sqlSession.getMapper(AuthorDao.class);
    }

    @Test
    public void A_insert() {
        Author author = new Author();
        author.setFullName("路遥（测试）");
        int insertResult = authorDao.insert(author);
        assertEquals(1, insertResult);
        idTemp = author.getId();
        System.out.println("Insert Author ID: " + idTemp);
    }

    @Test
    public void B_getAuthorAndBooks() {
        Author author = authorDao.getAuthorAndBooks(authorIdTemp);
        System.out.println("Get getAuthorAndBooks（卡勒德·胡赛尼）: " + author);
        assertNotNull(author);

    }

    @Test
    public void C_delete() {
        int deleteResult = authorDao.delete(idTemp);
        assertEquals(1, deleteResult);
        Author author = authorDao.getAuthorAndBooks(idTemp);
        System.out.println("After Delete Author: " + author);
        assertNull(author);
    }
}