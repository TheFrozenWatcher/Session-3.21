package com.ra.baitapuploadfile.dao;

import com.ra.baitapuploadfile.entity.Product;

import java.util.List;

public interface IProductDao
{
    List<Product> findAll();

    Product findById(Integer id);

    boolean save(Product product);

    boolean delete(Integer id);
}
