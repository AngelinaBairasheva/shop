package ru.shop.chocolate_collection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.api.service.CategoriesService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController extends BaseController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CategoriesService categoriesService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderCatalogPage() {
        request.setAttribute("categories", categoriesService.getRootCategories());
        System.out.println(categoriesService.getRootCategories());
        System.out.println(request.getAttribute("categories"));
        return Constants.ATTR_CATALOG;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderItemsPage(@PathVariable Long id) {
        return Constants.ATTR_ITEM;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String renderCatalogItemsPage(@PathVariable Long name) {
        return Constants.ATTR_ITEMS;
    }
}
