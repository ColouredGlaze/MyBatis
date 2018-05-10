package com.lmt.dao;

import com.lmt.MyBatisTest;
import com.lmt.entity.Account;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountDaoTest extends MyBatisTest {

    private static AccountDao accountDao;

    @BeforeClass
    public static void setDao() {
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    @Test
    public void A_insert() {
        Account account = new Account();
        account.setAccountEmail("ming******@outlook.com");
        int insertResult = accountDao.insert(account);
        assertEquals(1, insertResult);
        idTemp = account.getId();
        System.out.println("Insert Account ID: " + idTemp);
    }

    @Test
    public void B_get(){
        Account account = accountDao.get(idTemp);
        System.out.println("Get Account: " + account);
        assertNotNull(account);
    }

    @Test
    public void C_delete(){
        int deleteResult = accountDao.delete(idTemp);
        assertEquals(1, deleteResult);
        Account account = accountDao.get(idTemp);
        System.out.println("After Delete Account: " + account);
        assertNull(account);
    }
}