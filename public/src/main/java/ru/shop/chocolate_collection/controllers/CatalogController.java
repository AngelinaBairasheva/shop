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
        if (goodsService.getTypesOfChocolate() != null) {
            request.setAttribute("typesOfChocolate", goodsService.getTypesOfChocolate());
        }
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
        request.setAttribute("currentPage", page);
        String to = request.getParameter("to");
        String from = request.getParameter("from");
        System.out.println("to="+to+" from="+from);
        if (request.getParameter("selectByPrice") != null) {
            if (!from.isEmpty() && to.isEmpty()) {
                to = String.valueOf(goodsService.getMaxPrice());
            }
            if (from.isEmpty() && !to.isEmpty()) {
                from = String.valueOf(goodsService.getMinPrice());
            }
            if (!from.isEmpty() && from.matches("\\d+([\\.,]*\\d+)?") && !to.isEmpty() && to.matches("\\d+([\\.,]*\\d+)?")) {
                from = from.replace(",", ".");
                to = to.replace(",", ".");
                request.setAttribute("max", to);
                request.setAttribute("min", from);
                request.setAttribute("items", goodsService.getGoodsByInterval(Double.parseDouble(from),
                        Double.parseDouble(to), name));
            } else {
                to = String.valueOf(goodsService.getMaxPrice());
                from = String.valueOf(goodsService.getMinPrice());
                request.setAttribute("max", to);
                request.setAttribute("min", from);
                request.setAttribute("items", goodsService.getGoodsByInterval(Double.parseDouble(from),
                        Double.parseDouble(to), name));
            }
        } else {
            if (from == null) {                     //при переходе к каталогу товаров, устанавливается min,max цены
                System.out.println("================null");
                to = String.valueOf(goodsService.getMaxPrice());
                from = String.valueOf(goodsService.getMinPrice());
                request.setAttribute("max", to);
                request.setAttribute("min", from);
            } else {
                request.setAttribute("max", to);
                request.setAttribute("min", from);
            }
        }
        if (!goodsService.getGoodsByPage(goodsService.getGoodsByCategorysName(name), page).isEmpty()) {
            request.setAttribute("items", goodsService.getGoodsByPage(goodsService.getGoodsByInterval(Double.parseDouble(from),
                    Double.parseDouble(to), name), page));
            request.setAttribute("pagesCount", goodsService.getPagesCount(goodsService.getGoodsByInterval(Double.parseDouble(from),
                    Double.parseDouble(to), name)));//кол-во страниц
        }
        request.setAttribute("endedCategories", categoriesService.getEndedCategories());
        request.setAttribute("catalog", categoriesService.getCategoryByName(name));
        return Constants.ATTR_ITEMS;
    }
}
