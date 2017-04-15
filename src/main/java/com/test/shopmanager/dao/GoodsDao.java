package com.test.shopmanager.dao;


import com.test.shopmanager.model.Goods;

import java.util.List;

public interface GoodsDao {
    public void addGoods(Goods goods);

    public void updateGoods(Goods goods);

    public void removeGoods(int id);

    public Goods getGoodsById(int id);

    public List<Goods> listGoods();
}
