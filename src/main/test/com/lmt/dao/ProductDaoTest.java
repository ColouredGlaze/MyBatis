package com.lmt.dao;

import com.lmt.MyBatisTest;
import com.lmt.entity.Product;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends MyBatisTest {

    private static ProductDao productDao;

    /**
     * A：女子香
     * B：月光色
     * C：痴情郎
     */
    private static String productId_A = "9eb4fea754bc11e8b2e954e1ad6e4031";
    private static String productId_B = "a9aed6da54bc11e8b2e954e1ad6e4031";
    private static String productId_C = "c0c39b3354bc11e8b2e954e1ad6e4031";

    @BeforeClass
    public static void setDao(){
        productDao = sqlSession.getMapper(ProductDao.class);
    }

    @Test
    public void A_insert() {
        Product product = new Product();
        product.setBrandName("过情关");
        int insertResult = productDao.insert(product);
        System.out.println("Insert Result Product ID: " + product.getId());
        assertEquals(1, insertResult);
        idTemp = product.getId();
    }

    @Test
    public void B_get() {
        Product product = productDao.get(idTemp);
        System.out.println("Get Result Product: " + product);
        assertNotNull(product);

        Product productA = productDao.get(productId_A);
        System.out.println("Get Result ProductA: " + productA);
        assertNotNull(productA);

        Product productB = productDao.get(productId_B);
        System.out.println("Get Result ProductB: " + productB);
        assertNotNull(productB);

        Product productC = productDao.get(productId_C);
        System.out.println("Get Result ProductC: " + productC);
        assertNotNull(productC);
    }

    @Test
    public void C_delete() {
        int deleteResult = productDao.delete(idTemp);
        sqlSession.commit();
        assertEquals(1, deleteResult);
        Product product = productDao.get(idTemp);
        System.out.println("After Delete Product: " + product);
        assertNull(product);
    }

}