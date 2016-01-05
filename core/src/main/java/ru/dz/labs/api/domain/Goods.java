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
    @Column(nullable = true)
    private String country;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer count;   //в наличии
    @Column(nullable = false)
    private String size;
    @Column(nullable = true)
    private String image;
    @Column(nullable = true)
    private String description;
    @Column(nullable = false)
    private String vendor_code; //артикул
    @Column(nullable = true)
    private String brand; //брэнд
    @Column(nullable = false)
    private String calories; //энергетическая ценность
    @Column(nullable = false)
    private String composition;//состав
    @Column(nullable = false)
    private Integer weight;
    @Column(nullable = true)
    private String packaging;  //упаковка
    @Column(nullable = false)
    private String kind;     //вид
    @Column(nullable = true)
    private String type;     //тип
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

    public Goods(String name, String country, BigDecimal price, Integer count, String size, String image, String description,
                 String vendor_code, String brand, String calories, String composition, Integer weight, String packaging,
                 String kind, String type, Categories category) {
        this.name = name;
        this.country = country;
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
        this.type = type;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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