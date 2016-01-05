package ru.shop.chocolate_collection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainPageController extends BaseController  {

    @Autowired
    private HttpServletRequest request;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainPage() {
        return Constants.ATTR_MAIN;
    }
}
