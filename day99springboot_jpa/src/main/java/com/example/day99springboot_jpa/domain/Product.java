package com.example.day99springboot_jpa.domain;


import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String title;
    @Column
    private String pic_url;
    @Column
    private String price;
    @Column
    private String selling_price;
    @Column
    private String sales_volume;
    @Column
    private String coupon_title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", price='" + price + '\'' +
                ", selling_price='" + selling_price + '\'' +
                ", sales_volume='" + sales_volume + '\'' +
                ", coupon_title='" + coupon_title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(String selling_price) {
        this.selling_price = selling_price;
    }

    public String getSales_volume() {
        return sales_volume;
    }

    public void setSales_volume(String sales_volume) {
        this.sales_volume = sales_volume;
    }

    public String getCoupon_title() {
        return coupon_title;
    }

    public void setCoupon_title(String coupon_title) {
        this.coupon_title = coupon_title;
    }
}