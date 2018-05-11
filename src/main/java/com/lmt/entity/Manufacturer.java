package com.lmt.entity;

import com.lmt.mybatis.MyBatisEntity;
import org.apache.ibatis.type.Alias;

import java.util.Objects;
import java.util.Set;

/**
 * 多对多，一个制造商生产多种产品，一个产品多个制造商
 *
 * @author MT-Lin
 * @date 2018/05/10
 */
@Alias("Manufacturer")
public class Manufacturer extends MyBatisEntity {

    private String nameOfManufacturer;
    private Set<Product> products;

    public String getNameOfManufacturer() {
        return nameOfManufacturer;
    }

    public void setNameOfManufacturer(String nameOfManufacturer) {
        this.nameOfManufacturer = nameOfManufacturer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "nameOfManufacturer='" + nameOfManufacturer + '\'' +
                ", products=" + products +
                ", id='" + id + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Manufacturer)) {
            return false;
        }
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
