package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.Discount;
import ru.itis.eatbook.services.interfaces.DiscountsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long discountId = Long.parseLong(req.getParameter("id"));

        DiscountsService discountsService =
                (DiscountsService) getServletContext().getAttribute("discountsService");

        Optional<Discount> optionalDiscount = discountsService.getDiscountById(discountId);

        if (optionalDiscount.isPresent()) {
            req.setAttribute("discount", optionalDiscount.get());
            req.getRequestDispatcher("/WEB-INF/pages/discount-page.ftl").forward(req, resp);
        }

    }
}
