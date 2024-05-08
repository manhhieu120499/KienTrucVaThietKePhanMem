package org.example.product_jms_exerciselearn.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.product_jms_exerciselearn.entity.Product;
import org.example.product_jms_exerciselearn.repository.ProductRepository;
import org.example.product_jms_exerciselearn.services.ProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class OrderProductController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @GetMapping("/detailOrder")
    public ModelAndView orderProductPost() {
        ModelAndView detailOrderProduct = new ModelAndView("detailOrderProduct");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        Product product = new Product(name,Double.parseDouble(price.replace(".", "").trim()), Integer.parseInt(quantity.trim()));
        detailOrderProduct.addObject("orderProduct", product);
        return detailOrderProduct;
    }

    @GetMapping("/create")
    public String orderProduct() {
        return "order";
    }




}
