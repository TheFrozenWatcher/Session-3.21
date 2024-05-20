package com.ra.baitapuploadfile.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "product")
public class Product
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    @NotEmpty(message = "Name can't be empty")
    private String name;
    @Column(name = "price")
    @Min(value = 0, message = "Price must be greater than 0")
    private Double price;
    @Column(name = "stock")
    @Min(value = 0, message = "Stock can't be negative")
    private Integer stock;
    @Column(name = "status")
    @NotNull(message = "Please choose status")
    private Boolean status;

    @OneToMany(mappedBy = "product", targetEntity = ImageProduct.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ImageProduct> imageProductList;

    public Product()
    {
    }

    public Product(Integer id, List<ImageProduct> imageProductList, String name, Double price, Boolean status, Integer stock)
    {
        this.id = id;
        this.imageProductList = imageProductList;
        this.name = name;
        this.price = price;
        this.status = status;
        this.stock = stock;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Boolean getStatus()
    {
        return status;
    }

    public void setStatus(Boolean status)
    {
        this.status = status;
    }

    public Integer getStock()
    {
        return stock;
    }

    public void setStock(Integer stock)
    {
        this.stock = stock;
    }

    public List<ImageProduct> getImageProductList()
    {
        return imageProductList;
    }

    public void setImageProductList(List<ImageProduct> imageProductList)
    {
        this.imageProductList = imageProductList;
    }
}
