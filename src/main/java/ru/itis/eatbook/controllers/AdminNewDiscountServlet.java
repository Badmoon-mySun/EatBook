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

public class AdminNewDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/admin-discount-edit.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiscountsService discountsService =
                (DiscountsService) getServletContext().getAttribute("discountsService");

        OrganizationsService organizationsService =
                (OrganizationsService) getServletContext().getAttribute("organizationsService");

        DateService dateService = (DateService) getServletContext().getAttribute("dateService");

        Long organizationId = Long.parseLong(req.getParameter("organization_id"));

        Optional<Organization> optionalOrganization = organizationsService.getOrganizationById(organizationId);

        if (optionalOrganization.isPresent()) {
            Discount discount = Discount.builder()
                    .organization(optionalOrganization.get())
                    .title(req.getParameter("title"))
                    .info(req.getParameter("info"))
                    .date(dateService.getDateByString(req.getParameter("date")))
                    .build();

            discountsService.saveDiscount(discount);

            resp.sendRedirect("/adminDiscounts");
        }

    }
}
