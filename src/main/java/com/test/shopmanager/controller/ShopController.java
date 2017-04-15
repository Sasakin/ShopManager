package com.test.shopmanager.controller;

import com.test.shopmanager.model.Shop;
import com.test.shopmanager.service.GoodsService;
import com.test.shopmanager.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ShopController {
    private ShopService shopService;
    private GoodsService goodsService;
    @Autowired(required = true)
    @Qualifier(value = "shopService")
    public void setShopService(ShopService shopService) {
        this.shopService = shopService;
    }

    @Autowired(required = true)
    @Qualifier(value = "goodsService")
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping(value = "shops", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("shop", new Shop());
        model.addAttribute("listShops", this.shopService.listShops());

        return "shops";
    }


    @RequestMapping("shopdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.shopService.getShopById(id));

        return "shopdata";
    }
}
