package com.ra.baitapuploadfile.service;

import com.ra.baitapuploadfile.entity.ImageProduct;

import java.util.List;

public interface IProductImageService
{
    List<ImageProduct> findAll();

    ImageProduct findById(Integer id);

    boolean save(ImageProduct imageProduct);

    boolean delete(Integer id);
}
