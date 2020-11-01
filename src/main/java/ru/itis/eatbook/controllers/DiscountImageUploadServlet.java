package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.Discount;
import ru.itis.eatbook.services.interfaces.DiscountsService;
import ru.itis.eatbook.services.interfaces.FileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@MultipartConfig
public class DiscountImageUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("image");
        Long id = Long.parseLong(req.getParameter("id"));

        String filename = "discount-" + UUID.randomUUID().toString() + part.getSubmittedFileName();

        FileService fileService =
                (FileService) getServletContext().getAttribute("fileService");

        String path = (String) getServletContext().getAttribute("IMAGE_DIR");

        fileService.upload(part, path, filename);

        DiscountsService discountsService =
                (DiscountsService) getServletContext().getAttribute("discountsService");

        Optional<Discount> optionalDiscount = discountsService.getDiscountById(id);

        if (optionalDiscount.isPresent()) {
            Discount discount = optionalDiscount.get();

            discount.setImage(filename);

            discountsService.changeDiscount(discount);
        }

        resp.sendRedirect("/adminDiscounts");
    }
}
