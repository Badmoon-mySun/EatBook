package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.Discount;
import ru.itis.eatbook.services.interfaces.DiscountsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DiscountsFeedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiscountsService discountsService =
                (DiscountsService) getServletContext().getAttribute("discountsService");
        List<Discount> discounts =  discountsService.getAllDiscounts();

        req.setAttribute("discounts", discounts);

        req.getRequestDispatcher("/WEB-INF/pages/discounts-feed.ftl").forward(req, resp);
    }
}
