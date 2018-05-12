package com.lmt.dao;

import com.lmt.MyBatisTest;
import com.lmt.entity.Computer;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComputerDaoTest extends MyBatisTest {

    private static ComputerDao computerDao;

    @BeforeClass
    public static void setDao(){
        computerDao = sqlSession.getMapper(ComputerDao.class);
    }

    @Test
    public void A_A_insert() {
        Computer computer = new Computer();
        computer.setTrademark("小米电脑");
        computer.setOwner("荆天明");
        int insertResult = computerDao.insert(computer);
        assertEquals(1, insertResult);
        idTemp = computer.getId();
        System.out.println("Insert Result Computer ID: " + idTemp);
    }

    @Test
    public void A_B_insertAll() {
        Computer computerA = new Computer();
        computerA.setTrademark("华为电脑");
        computerA.setOwner("高月");
        Computer computerB = new Computer();
        computerB.setTrademark("华硕电脑");
        computerB.setOwner("雪女");
        List<Computer> computers = new ArrayList<>();
        computers.add(computerA);
        computers.add(computerB);
        int insertAllResult = computerDao.insertAll(computers);
        assertEquals(2, insertAllResult);
        System.out.println("Insert All Result Count: " + insertAllResult);
    }

    @Test
    public void B_A_get() {
        Computer computer = computerDao.get(idTemp);
        assertNotNull(computer);
        System.out.println("Get Computer: " + computer);
    }

    @Test
    public void B_B_ListAll() {
        List<Computer> computers = computerDao.listAll();
        assertNotEquals(0, computers.size());
        System.out.println("List All Computer: " + computers);
    }

    @Test
    public void C_C_updateByTrim() {
        Computer computer = new Computer();
        computer.setId(idTemp);
        System.out.println("Before Update(By Trim) Computer: " + computerDao.get(idTemp));
        computer.setTrademark("荆天明的专属小米电脑");
        int updateResult = computerDao.updateByTrim(computer);
        sqlSession.commit();
        assertEquals(1, updateResult);
        Computer computerAfterUpdate = computerDao.get(idTemp);
        System.out.println("After Update(By Trim) Computer: " + computerAfterUpdate);
    }

    @Test
    public void C_C_updateBySet() {
        Computer computer = new Computer();
        computer.setId(idTemp);
        System.out.println("Before Update(By Set) Computer: " + computerDao.get(idTemp));
        computer.setOwner("荆天明的儿子");
        int updateResult = computerDao.updateBySet(computer);
        sqlSession.commit();
        assertEquals(1, updateResult);
        Computer computerAfterUpdate = computerDao.get(idTemp);
        System.out.println("After Update(By Set) Computer: " + computerAfterUpdate);
    }

    @Test
    public void D_A_listByTrademarkAndOwnerByTrim() {
        String trademark = "电脑";
        String owner = "高";
        List<Computer> computers = computerDao.listByTrademarkAndOwnerByTrim(trademark, owner);
        assertNotEquals(0, computers.size());
        System.out.println("listByTrademarkAndOwnerByTrim: " + computers);
    }

    @Test
    public void D_B_listByTrademarkAndOwnerByWhere() {
        String trademark = "电脑";
        String owner = "雪";
        Computer computer = new Computer();
        computer.setTrademark(trademark);
        computer.setOwner(owner);
        List<Computer> computers = computerDao.listByTrademarkAndOwnerByWhere(computer);
        assertNotEquals(0, computers.size());
        System.out.println("listByTrademarkAndOwnerByWhere: " + computers);
    }

    @Test
    public void D_C_listByTrademarkAndOwnerByChoose() {
        String trademark = "电脑";
        Computer computer = new Computer();
        computer.setTrademark(trademark);
        computer.setOwner("");
        List<Computer> computers = computerDao.listByTrademarkAndOwnerByChoose(computer);
        assertNotEquals(0, computers.size());
        System.out.println("listByTrademarkAndOwnerByChoose: " + computers);
    }

    @Test
    public void E_A_delete() {
        int deleteResult = computerDao.delete(idTemp);
        assertEquals(1, deleteResult);
        Computer computer = computerDao.get(idTemp);
        System.out.println("After Delete Computer: " + computer);
    }

    @Test
    public void E_B_deleteAll() {
        List<Computer> computers = computerDao.listAll();
        int deleteResult = computerDao.deleteAll(computers);
        assertEquals(computers.size(), deleteResult);
        System.out.println("Delete All Result Count: " + deleteResult);
    }
}