package ru.shop.chocolate_collection.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
 @Autowired
 protected HttpServletRequest request;

 public static String redirectToMain() {
  return "redirect:/";
 }
}
