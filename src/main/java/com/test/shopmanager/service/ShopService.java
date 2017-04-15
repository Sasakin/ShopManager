package com.test.shopmanager.service;


import com.test.shopmanager.model.Shop;

import java.util.List;

public interface ShopService {
    public void addShop(Shop shop);

    public void updateShop(Shop shop);

    public void removeShop(int id);

    public Shop getShopById(int id);

    public List<Shop> listShops();
}
