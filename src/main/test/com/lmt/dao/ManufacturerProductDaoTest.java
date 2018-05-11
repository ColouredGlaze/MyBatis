package com.lmt.dao;

import com.lmt.MyBatisTest;
import com.lmt.entity.Manufacturer;
import com.lmt.entity.ManufacturerProduct;
import com.lmt.entity.Product;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManufacturerProductDaoTest extends MyBatisTest {

    private static ManufacturerProductDao manufacturerProductDao;

    /**
     * A：高月制造商
     * B：少司命制造商
     * C：荆天明制造商
     */
    private static String manufacturerId_A = "050d31ac54ba11e8b2e954e1ad6e4031";
    private static String manufacturerId_B = "0f77dbc054ba11e8b2e954e1ad6e4031";
    private static String manufacturerId_C = "fb8333a954b911e8b2e954e1ad6e4031";

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
        manufacturerProductDao = sqlSession.getMapper(ManufacturerProductDao.class);
    }

    /**
     * 插入制造商-产品数据，数据库中已经包含了以上所有可能的组合，若要测试可将数据库中数据删除再运行测试用例
     */
    @Test
    @Ignore
    public void A_insert() {
        ManufacturerProduct manufacturerProduct = new ManufacturerProduct();
        Manufacturer manufacturer = new Manufacturer();
        Product product = new Product();
        manufacturer.setId(manufacturerId_A);
        product.setId(productId_A);
        manufacturerProduct.setManufacturer(manufacturer);
        manufacturerProduct.setProduct(product);
        int insertResult = manufacturerProductDao.insert(manufacturerProduct);
        System.out.println("Insert Result ManufacturerProduct ID: " + manufacturerProduct.getId());
        assertEquals(1, insertResult);
    }

    @Test
    public void B_get() {
        ManufacturerProduct manufacturerProduct = manufacturerProductDao.get(manufacturerId_A, productId_A);
        System.out.println("Get ManufacturerProduct: " + manufacturerProduct);
        assertNotNull(manufacturerProduct);
    }
}