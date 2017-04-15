package com.test.shopmanager.dao;


import com.test.shopmanager.model.Shop;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Repository
public class ShopDaoImpl implements ShopDao {
    private static final Logger logger = LoggerFactory.getLogger(ShopDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addShop(Shop shop) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(shop);
        logger.info("Shop successfully saved. Shop details: " + shop);
    }

    @Override
    public void updateShop(Shop shop) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(shop);
        logger.info("Shop successfully update. Shop details: " + shop);
    }

    @Override
    public void removeShop(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Shop shop = (Shop) session.load(Shop.class, new Integer(id));

        if(shop!=null){
            session.delete(shop);
        }
        logger.info("Shop successfully removed. Shop details: " + shop);
    }

    @Override
    public Shop getShopById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Shop shop = (Shop) session.load(Shop.class, new Integer(id));
        logger.info("Sgop successfully loaded. Shop details: " + shop);

        return shop;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Shop> listShops() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Shop> shopList = session.createQuery("from Shop").list();

        for(Shop shop : shopList){
            logger.info("Shop list: " + shop);
        }

        return shopList;
    }
}
