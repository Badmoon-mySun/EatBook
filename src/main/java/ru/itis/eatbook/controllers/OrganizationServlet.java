package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.models.Review;
import ru.itis.eatbook.services.interfaces.OrganizationsService;
import ru.itis.eatbook.services.interfaces.ReviewsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class OrganizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));

        OrganizationsService organizationsService =
                (OrganizationsService) getServletContext().getAttribute("organizationsService");

        ReviewsService reviewsService = (ReviewsService) getServletContext().getAttribute("reviewsService");

        Optional<Organization> optionalOrganization = organizationsService.getOrganizationById(id);

        if (optionalOrganization.isPresent()) {
            List<Review> reviews = reviewsService.getAllOrganizationReviews(id);

            req.setAttribute("organization", optionalOrganization.get());
            req.setAttribute("reviews", reviews);

            req.getRequestDispatcher("/WEB-INF/pages/organization.ftl").forward(req, resp);
        }
    }
}
