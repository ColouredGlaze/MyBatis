package com.lmt.dao;

import com.lmt.MyBatisTest;
import com.lmt.entity.Account;
import com.lmt.entity.Phone;
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
public class PhoneDaoTest extends MyBatisTest {

    private static PhoneDao phoneDao;
    private static String accountIdTemp = "fbed4cfa52c211e8a8f754e1ad6e4031";
    private static String idTemp;

    @BeforeClass
    public static void setDao() {
        phoneDao = getSqlSession().getMapper(PhoneDao.class);
    }

    @Test
    public void A_insert() {
        Phone phone = new Phone();
        phone.setPhoneNumber("1**********");
        Account account = new Account();
        account.setId(accountIdTemp);
        phone.setAccount(account);
        int insertResult = phoneDao.insert(phone);
        assertEquals(1, insertResult);
        idTemp = phone.getId();
        System.out.println("Insert Phone: " + phone);
    }

    @Test
    public void B_get() {
        Phone phone = phoneDao.get(idTemp);
        System.out.println("Get Phone: " + phone);
        assertNotNull(phone);
    }

    @Test
    public void C_listAll(){
        List<Phone> phones = phoneDao.listAll();
        System.out.println("List All Phone: " + phones);
        assertNotEquals(0, phones.size());
    }

    @Test
    public void D_delete() {
        /**
         * MyBatis没有提供级联删除的功能，要么自己一条一条在代码里面删除，要么建表的时候使用级联删除，这里采用建表的时候使用级联删除：
         * CONSTRAINT `fk_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE
         */
        int deleteResult = phoneDao.delete(idTemp);
        assertEquals(1, deleteResult);
        Phone phone = phoneDao.get(idTemp);
        System.out.println("After Delete Phone: " + phone);
        assertNull(phone);
    }
}