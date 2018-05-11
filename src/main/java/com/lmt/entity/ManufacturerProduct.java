package com.lmt.entity;

import com.lmt.mybatis.MyBatisEntity;
import org.apache.ibatis.type.Alias;

/**
 * 多对多，制造商-产品表
 *
 * @author MT-Lin
 * @date 2018/05/10
 */
@Alias("ManufacturerProduct")
public class ManufacturerProduct extends MyBatisEntity {

    private Manufacturer manufacturer;
    private Product product;

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ManufacturerProduct{" +
                "manufacturer=" + manufacturer +
                ", product=" + product +
                ", id='" + id + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
