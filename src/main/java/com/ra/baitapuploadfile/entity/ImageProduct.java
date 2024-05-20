package com.ra.baitapuploadfile.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "image_product")
public class ImageProduct
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "url")
    private String url;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public ImageProduct()
    {
    }

    public ImageProduct(Integer id, Product product, String url)
    {
        this.id = id;
        this.product = product;
        this.url = url;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
