package com.test.shopmanager.service;

import com.test.shopmanager.dao.ShopDao;
import com.test.shopmanager.model.Shop;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    private ShopDao shopDao;

    public void setShopDao(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    @Override
    @Transactional
    public void addShop(Shop shop) {
        shopDao.addShop(shop);
    }

    @Override
    @Transactional
    public void updateShop(Shop shop) {
        shopDao.updateShop(shop);
    }

    @Override
    @Transactional
    public void removeShop(int id) {
        shopDao.removeShop(id);
    }

    @Override
    @Transactional
    public Shop getShopById(int id) {
        return shopDao.getShopById(id);
    }

    @Override
    @Transactional
    public List<Shop> listShops() {
        return shopDao.listShops();
    }
}
