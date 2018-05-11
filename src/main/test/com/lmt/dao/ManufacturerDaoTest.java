package com.lmt.dao;

import com.lmt.MyBatisTest;
import com.lmt.entity.Manufacturer;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManufacturerDaoTest extends MyBatisTest {

    private static ManufacturerDao manufacturerDao;

    /**
     * A：高月制造商
     * B：少司命制造商
     * C：荆天明制造商
     */
    private static String manufacturerId_A = "050d31ac54ba11e8b2e954e1ad6e4031";
    private static String manufacturerId_B = "0f77dbc054ba11e8b2e954e1ad6e4031";
    private static String manufacturerId_C = "fb8333a954b911e8b2e954e1ad6e4031";

    @BeforeClass
    public static void setDao(){
        manufacturerDao = sqlSession.getMapper(ManufacturerDao.class);
    }

    @Test
    public void A_insert() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setNameOfManufacturer("我不是制造商");
        int insertResult = manufacturerDao.insert(manufacturer);
        System.out.println("Insert Manufacturer Result ID: " + manufacturer.getId());
        assertEquals(1, insertResult);
        idTemp = manufacturer.getId();
    }


    @Test
    public void B_get() {
        Manufacturer manufacturer = manufacturerDao.get(idTemp);
        System.out.println("Get Manufacturer: " + manufacturer);
        assertNotNull(manufacturer);

        Manufacturer manufacturer_A = manufacturerDao.get(manufacturerId_A);
        System.out.println("Get Manufacturer_A: " + manufacturer_A);
        assertNotNull(manufacturer_A);

        Manufacturer manufacturer_B = manufacturerDao.get(manufacturerId_B);
        System.out.println("Get Manufacturer_B: " + manufacturer_B);
        assertNotNull(manufacturer_B);

        Manufacturer manufacturer_C = manufacturerDao.get(manufacturerId_C);
        System.out.println("Get Manufacturer_C: " + manufacturer_C);
        assertNotNull(manufacturer_C);
    }

    @Test
    public void C_delete() {
        int deleteResult = manufacturerDao.delete(idTemp);
        sqlSession.commit();
        assertEquals(1, deleteResult);
        Manufacturer manufacturer = manufacturerDao.get(idTemp);
        System.out.println("After Delete manufacturer: " + manufacturer);
        assertNull(manufacturer);
    }

}