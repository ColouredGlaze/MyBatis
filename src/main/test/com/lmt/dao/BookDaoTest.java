package com.lmt.dao;

import com.lmt.MyBatisTest;
import com.lmt.entity.Author;
import com.lmt.entity.Book;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookDaoTest extends MyBatisTest {

    private static BookDao bookDao;

    /**
     * 作者路遥的ID
     */
    private static String authorIdTemp = "327e64eb540211e88b7854e1ad6e4031";

    @BeforeClass
    public static void setDao(){
        bookDao = sqlSession.getMapper(BookDao.class);
    }

    @Test
    public void A_insert() {
        Book book = new Book();
        book.setTitle("平凡的世界");
        Author author = new Author();
        author.setId(authorIdTemp);
        book.setAuthor(author);
        int insertResult = bookDao.insert(book);
        assertEquals(1, insertResult);
        idTemp = book.getId();
        System.out.println("After Insert Book ID:" + book.getId());
    }

    @Test
    public void B_get() {
        Book book = bookDao.get(idTemp);
        assertNotNull(book);
        System.out.println("Get Book:" + book);
    }

    @Test
    public void E_delete() {
        int deleteResult = bookDao.delete(idTemp);
        assertEquals(1, deleteResult);
        Book book = bookDao.get(idTemp);
        System.out.println("After Delete Book:" + book);
        assertNull(book);
    }
}