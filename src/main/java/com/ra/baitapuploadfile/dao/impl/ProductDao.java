package com.ra.baitapuploadfile.dao.impl;

import com.ra.baitapuploadfile.dao.IProductDao;
import com.ra.baitapuploadfile.dao.IProductImageDao;
import com.ra.baitapuploadfile.entity.ImageProduct;
import com.ra.baitapuploadfile.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao implements IProductDao
{
    private final SessionFactory sessionFactory;
    private final IProductImageDao productImageDao;

    @Autowired
    public ProductDao(SessionFactory sessionFactory, IProductImageDao productImageDao)
    {
        this.sessionFactory = sessionFactory;
        this.productImageDao = productImageDao;
    }

    @Override
    public List<Product> findAll()
    {
        Session session = sessionFactory.openSession();
        List<Product> productList = null;
        try
        {
            productList = session.createQuery("from Product").list();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            session.close();
        }
        return productList;
    }

    @Override
    public Product findById(Integer id)
    {
        Session session = sessionFactory.openSession();
        Product product = null;
        try
        {
            product = session.get(Product.class, id);
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            session.close();
        }
        return product;
    }

    @Override
    public boolean save(Product product)
    {
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            if (product.getId() == null)
            {
                session.save(product);
            } else
            {
                session.update(product);
            }
//            for (ImageProduct image : product.getImageProductList())
//            {
//                productImageDao.save(image);
//            }
            session.getTransaction().commit();
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id)
    {
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }
        return false;
    }
}
