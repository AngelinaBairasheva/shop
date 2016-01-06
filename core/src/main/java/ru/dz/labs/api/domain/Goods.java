package ru.dz.labs.api.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Goods {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer count;   //в наличии
    @Column(nullable = true)
    private String size;
    @Column(nullable = false)
    private String image;
    @Column(nullable = true)
    private String description;
    @Column(nullable = false, unique = true)
    private String vendor_code; //артикул
    @Column(nullable = true)
    private String brand; //брэнд
    @Column(nullable = false)
    private Integer calories; //энергетическа€ ценность/к ал
    @Column(nullable = false)
    private String composition;//состав
    @Column(nullable = false)
    private Integer weight;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean byorder;  //под заказ
    @Column(nullable = true)
    private String packaging;  //упаковка
    @Column(nullable = true)
    private String kind;     //вид шоколада
    private String pfc; //белки жиры углеводы
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "good")
    private List<Cart> carts;
    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Categories category;

    public Goods() {
    }

    public String getPfc() {
        return pfc;
    }

    public void setPfc(String pfc) {
        this.pfc = pfc;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Goods(String name,   BigDecimal price, Integer count, String size, String image, String description,
                 String vendor_code, String brand, Integer calories, String composition, Integer weight, String packaging,
                 String kind, Categories category, Boolean byorder, String pfc) {
        this.pfc=pfc;

        this.byorder=byorder;
        this.name = name;
        this.price = price;
        this.count = count;
        this.size = size;
        this.image = image;
        this.description = description;
        this.vendor_code = vendor_code;
        this.brand = brand;
        this.calories = calories;
        this.composition = composition;
        this.weight = weight;
        this.packaging = packaging;
        this.kind = kind;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getByorder() {
        return byorder;
    }

    public void setByorder(Boolean byorder) {
        this.byorder = byorder;
    }

    public Goods(String name, BigDecimal price, Integer count, String image,  String vendor_code,
                 Integer calories, String composition, Integer weight, String packaging, String kind,
                  Categories category, Boolean byorder) {
        this.byorder=byorder;

        this.name = name;
        this.price = price;
        this.count = count;
        this.image = image;
        this.vendor_code = vendor_code;
        this.calories = calories;
        this.composition = composition;
        this.weight = weight;
        this.packaging = packaging;
        this.kind = kind;
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor_code() {
        return vendor_code;
    }

    public void setVendor_code(String vendor_code) {
        this.vendor_code = vendor_code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}