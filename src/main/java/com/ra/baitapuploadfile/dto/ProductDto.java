package com.ra.baitapuploadfile.dto;

import com.ra.baitapuploadfile.entity.ImageProduct;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ProductDto
{
    private Integer id;
    @NotEmpty(message = "Name can't be empty")
    private String name;
    @Min(value = 0, message = "Price must be greater than 0")
    private Double price;
    @Min(value = 0, message = "Stock can't be negative")
    private Integer stock;
    @NotNull(message = "Please choose status")
    private Boolean status;
    private List<MultipartFile> files;

    public ProductDto()
    {
    }

    public ProductDto(List<MultipartFile> files, Integer id, String name, Double price, Boolean status, Integer stock)
    {
        this.files = files;
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.stock = stock;
    }

    public List<MultipartFile> getFiles()
    {
        return files;
    }

    public void setFiles(List<MultipartFile> files)
    {
        this.files = files;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public @NotEmpty(message = "Name can't be empty") String getName()
    {
        return name;
    }

    public void setName(@NotEmpty(message = "Name can't be empty") String name)
    {
        this.name = name;
    }

    public @Min(value = 0, message = "Price must be greater than 0") Double getPrice()
    {
        return price;
    }

    public void setPrice(@Min(value = 0, message = "Price must be greater than 0") Double price)
    {
        this.price = price;
    }

    public @NotNull(message = "Please choose status") Boolean getStatus()
    {
        return status;
    }

    public void setStatus(@NotNull(message = "Please choose status") Boolean status)
    {
        this.status = status;
    }

    public @Min(value = 0, message = "Stock can't be negative") Integer getStock()
    {
        return stock;
    }

    public void setStock(@Min(value = 0, message = "Stock can't be negative") Integer stock)
    {
        this.stock = stock;
    }
}
