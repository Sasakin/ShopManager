package com.test.shopmanager.dao;



import com.test.shopmanager.model.Shop;

import java.util.List;

public interface ShopDao {
    public void addShop(Shop shop);

    public void updateShop(Shop shop);

    public void removeShop(int id);

    public Shop getShopById(int id);

    public List<Shop> listShops();
}
