package com.test.shopmanager.service;

import com.test.shopmanager.dao.GoodsDao;
import com.test.shopmanager.model.Goods;

import java.util.List;

/**
 * Created by Student on 15.04.2017.
 */
public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao;

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public void addGoods(Goods goods) {
        goodsDao.addGoods(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }

    @Override
    public void removeGoods(int id) {
        goodsDao.removeGoods(id);
    }

    @Override
    public Goods getGoodsById(int id) {
        return goodsDao.getGoodsById(id);
    }

    @Override
    public List<Goods> listGoods() {
        return goodsDao.listGoods();
    }
}
