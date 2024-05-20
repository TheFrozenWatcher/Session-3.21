package com.ra.baitapuploadfile.service.impl;

import com.ra.baitapuploadfile.dao.IProductDao;
import com.ra.baitapuploadfile.dto.ProductDto;
import com.ra.baitapuploadfile.entity.ImageProduct;
import com.ra.baitapuploadfile.entity.Product;
import com.ra.baitapuploadfile.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService
{
    private final IProductDao productDao;

    @Autowired
    public ProductService(IProductDao productDao)
    {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findAll()
    {
        return productDao.findAll();
    }

    @Override
    public Product findById(Integer id)
    {
        return productDao.findById(id);
    }

    @Override
    public boolean save(ProductDto productDto, HttpServletRequest request)
    {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setStatus(productDto.getStatus());
        List<ImageProduct> imageProductList = new ArrayList<>();
        for (MultipartFile file : productDto.getFiles())
        {
            String path = request.getServletContext().getRealPath("images");
            File imageFile = new File(path);
            String fileName = file.getOriginalFilename();
            try
            {
                if (!imageFile.exists())
                {
                    imageFile.mkdir();
                }
                File destination = new File(imageFile.getAbsolutePath() + File.separator + fileName);
                if (!destination.exists())
                {
                    FileCopyUtils.copy(file.getBytes(), destination);
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            ImageProduct imageProduct = new ImageProduct();
            imageProduct.setUrl(fileName);
            imageProduct.setProduct(product);
            imageProductList.add(imageProduct);
        }
        product.setImageProductList(imageProductList);
        return productDao.save(product);
    }

    @Override
    public boolean delete(Integer id)
    {
        return productDao.delete(id);
    }
}
