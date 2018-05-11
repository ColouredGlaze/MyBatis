package com.lmt.entity;

import com.lmt.mybatis.MyBatisEntity;
import org.apache.ibatis.type.Alias;

import java.util.Objects;
import java.util.Set;

/**
 * 多对多，一个产品有多个制造商，一个制造商生产多种产品
 *
 * @author MT-Lin
 * @date 2018/05/10
 */
@Alias("Product")
public class Product extends MyBatisEntity {

    private String brandName;
    private Set<Manufacturer> manufacturers;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Set<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Set<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "brandName='" + brandName + '\'' +
                ", manufacturers=" + manufacturers +
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
        if (!(o instanceof Product)) {
            return false;
        }
        Product that = (Product) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
