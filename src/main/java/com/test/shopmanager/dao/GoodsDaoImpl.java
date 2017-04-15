package com.test.shopmanager.dao;

import com.test.shopmanager.model.Goods;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    private static final Logger logger = LoggerFactory.getLogger(GoodsDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addGoods(Goods goods) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(goods);
        logger.info("goods successfully saved. goods details: " + goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(goods);
        logger.info("Goods successfully update. Goods details: " + goods);
    }

    @Override
    public void removeGoods(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Goods goods = (Goods) session.load(Goods.class, new Integer(id));

        if(goods!=null){
            session.delete(goods);
        }
        logger.info("Goods successfully removed. Goods details: " + goods);
    }

    @Override
    public Goods getGoodsById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Goods goods = (Goods) session.load(Goods.class, new Integer(id));
        logger.info("Sgop successfully loaded. Goods details: " + goods);

        return goods;
    }

    @Override
    public List<Goods> listGoods() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Goods> goodsList = session.createQuery("from Goods").list();

        for(Goods goods : goodsList){
            logger.info("Goods list: " + goods);
        }

        return goodsList;
    }
}
