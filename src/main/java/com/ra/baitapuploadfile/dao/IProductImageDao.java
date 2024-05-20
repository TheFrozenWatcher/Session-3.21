package com.ra.baitapuploadfile.dao;

import com.ra.baitapuploadfile.entity.ImageProduct;
import com.ra.baitapuploadfile.entity.Product;

import java.util.List;

public interface IProductImageDao
{
    List<ImageProduct> findAll();

    ImageProduct findById(Integer id);

    boolean save(ImageProduct imageProduct);

    boolean delete(Integer id);
}
