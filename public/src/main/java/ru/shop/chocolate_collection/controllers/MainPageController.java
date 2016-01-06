package ru.shop.chocolate_collection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.api.service.CategoriesService;
import ru.dz.labs.api.service.GoodsService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainPageController extends BaseController  {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private GoodsService goodsService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainPage() {
        request.setAttribute("newGoods",goodsService.getNewGoods());
        request.setAttribute("endedCategories", categoriesService.getEndedCategories());
        return Constants.ATTR_MAIN;
    }
}
