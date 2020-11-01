package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.Discount;
import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.services.interfaces.DateService;
import ru.itis.eatbook.services.interfaces.DiscountsService;
import ru.itis.eatbook.services.interfaces.OrganizationsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AdminDiscountEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiscountsService discountsService =
                (DiscountsService) getServletContext().getAttribute("discountsService");

        Optional<Discount> optionalDiscount;

        if (req.getParameter("edit") != null) {
            Long id = Long.parseLong(req.getParameter("edit"));

            optionalDiscount = discountsService.getDiscountById(id);

            if (optionalDiscount.isPresent()) {
                req.setAttribute("discount", optionalDiscount.get());

                req.getRequestDispatcher("/WEB-INF/pages/admin-discount-edit.ftl").forward(req, resp);
            }
        } else if (req.getParameter("delete") != null) {
            Long delete = Long.parseLong(req.getParameter("delete"));

            optionalDiscount = discountsService.getDiscountById(delete);

            optionalDiscount.ifPresent(discountsService::deleteDiscount);

            resp.sendRedirect("/adminDiscounts");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiscountsService discountsService =
                (DiscountsService) getServletContext().getAttribute("discountsService");

        Long edit = Long.parseLong(req.getParameter("edit"));

        Optional<Discount> optionalDiscount = discountsService.getDiscountById(edit);

        OrganizationsService organizationsService =
                (OrganizationsService) getServletContext().getAttribute("organizationsService");

        Long organizationId = Long.parseLong(req.getParameter("organization_id"));

        Optional<Organization> optionalOrganization = organizationsService.getOrganizationById(organizationId);

        DateService dateService = (DateService) getServletContext().getAttribute("dateService");

        if (optionalDiscount.isPresent() && optionalOrganization.isPresent()) {
            Discount discount = optionalDiscount.get();
            discount.setTitle(req.getParameter("title"));
            discount.setInfo(req.getParameter("info"));
            discount.setOrganization(optionalOrganization.get());
            discount.setDate(dateService.getDateByString(req.getParameter("date")));

            discountsService.changeDiscount(discount);
        }

        resp.sendRedirect("/adminDiscounts");
    }
}
