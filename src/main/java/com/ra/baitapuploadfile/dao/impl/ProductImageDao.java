package com.ra.baitapuploadfile.dao.impl;

import com.ra.baitapuploadfile.dao.IProductImageDao;
import com.ra.baitapuploadfile.entity.ImageProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductImageDao implements IProductImageDao
{
    private final SessionFactory sessionFactory;

    @Autowired
    public ProductImageDao(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ImageProduct> findAll()
    {
        Session session = sessionFactory.getCurrentSession();
        List<ImageProduct> imageProductList = null;
        try
        {
            imageProductList = session.createQuery("from ImageProduct").list();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            session.close();
        }
        return imageProductList;
    }

    @Override
    public ImageProduct findById(Integer id)
    {
        Session session = sessionFactory.getCurrentSession();
        ImageProduct imageProduct = null;
        try
        {
            imageProduct = session.get(ImageProduct.class, id);
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            session.close();
        }
        return imageProduct;
    }

    @Override
    public boolean save(ImageProduct imageProduct)
    {
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            if (imageProduct.getId() == null)
            {
                session.save(imageProduct);
            } else
            {
                session.update(imageProduct);
            }
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
        Session session = sessionFactory.getCurrentSession();
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
