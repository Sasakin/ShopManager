package com.test.shopmanager.service;

import com.test.shopmanager.model.Goods;

import java.util.List;

/**
 * Created by Student on 15.04.2017.
 */
public interface GoodsService {
    public void addGoods(Goods goods);

    public void updateGoods(Goods goods);

    public void removeGoods(int id);

    public Goods getGoodsById(int id);

    public List<Goods> listGoods();
}
