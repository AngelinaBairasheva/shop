package ru.shop.chocolate_collection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.api.service.CategoriesService;
import ru.dz.labs.api.service.GoodsService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController extends BaseController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private GoodsService goodsService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderCatalogPage() {
        request.setAttribute("categories", categoriesService.getRootCategories());
        request.setAttribute("endedCategories", categoriesService.getEndedCategories());
        return Constants.ATTR_CATALOG;
    }

    @RequestMapping(value = "/good/{id}", method = RequestMethod.GET)
    public String renderItemsPage(@PathVariable Long id) {

        request.setAttribute("item", goodsService.getGoodsById(id));
        return Constants.ATTR_ITEM;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String renderCatalogItemsPage(@PathVariable String name) {
        request.setAttribute("catalog", categoriesService.getCategoryByName(name));
        if(!goodsService.getGoodsByCategorysName(name).isEmpty())
        request.setAttribute("items", goodsService.getGoodsByCategorysName(name));
        return Constants.ATTR_ITEMS;
    }
}
