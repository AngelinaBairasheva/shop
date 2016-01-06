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

        request.setAttribute("endedCategories", categoriesService.getEndedCategories());
        request.setAttribute("item", goodsService.getGoodsById(id));
        return Constants.ATTR_ITEM;
    }

    @RequestMapping(value = "/{name}/{page}", method = RequestMethod.GET)
    public String renderCatalogItemsPage(@PathVariable String name,@PathVariable int page) {
        request.setAttribute("currentPage",page);
        request.setAttribute("max",goodsService.getMaxPrice());
        request.setAttribute("min",goodsService.getMinPrice());
        if(request.getParameter("from")!=null&&request.getParameter("from").matches("\\d+")&&request.getParameter("to")!=null&&request.getParameter("to").matches("\\d+")){
                    request.setAttribute("items", goodsService.getGoodsByInterval(Integer.parseInt(request.getParameter("from")),
                            Integer.parseInt(request.getParameter("to")), name));
        }else{
            if(!goodsService.getGoodsByPage(name,page).isEmpty())
                request.setAttribute("items", goodsService.getGoodsByPage(name,page));
        }
        request.setAttribute("pagesCount",goodsService.getPagesCount(name));

        request.setAttribute("endedCategories", categoriesService.getEndedCategories());
        request.setAttribute("catalog", categoriesService.getCategoryByName(name));
        return Constants.ATTR_ITEMS;
    }
}
