package com.ra.baitapuploadfile.service;

import com.ra.baitapuploadfile.dto.ProductDto;
import com.ra.baitapuploadfile.entity.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface IProductService
{
    List<Product> findAll();

    Product findById(Integer id);

    boolean save(ProductDto productDto, HttpServletRequest request);

    boolean delete(Integer id);
}
