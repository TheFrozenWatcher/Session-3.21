package com.ra.baitapuploadfile.service.impl;

import com.ra.baitapuploadfile.dao.IProductImageDao;
import com.ra.baitapuploadfile.entity.ImageProduct;
import com.ra.baitapuploadfile.service.IProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageService implements IProductImageService
{
    private final IProductImageDao productImageDao;

    @Autowired
    public ProductImageService(IProductImageDao productImageDao)
    {
        this.productImageDao = productImageDao;
    }

    @Override
    public List<ImageProduct> findAll()
    {
        return productImageDao.findAll();
    }

    @Override
    public ImageProduct findById(Integer id)
    {
        return productImageDao.findById(id);
    }

    @Override
    public boolean save(ImageProduct imageProduct)
    {
        return productImageDao.save(imageProduct);
    }

    @Override
    public boolean delete(Integer id)
    {
        return productImageDao.delete(id);
    }
}
