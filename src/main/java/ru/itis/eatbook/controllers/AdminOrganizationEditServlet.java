package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.services.interfaces.OrganizationsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AdminOrganizationEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrganizationsService organizationsService =
                (OrganizationsService) getServletContext().getAttribute("organizationsService");

        Optional<Organization> optionalOrganization;

        if (req.getParameter("edit") != null) {
            Long id = Long.parseLong(req.getParameter("edit"));


            optionalOrganization = organizationsService.getOrganizationById(id);

            if (optionalOrganization.isPresent()) {
                req.setAttribute("org", optionalOrganization.get());

                req.getRequestDispatcher("/WEB-INF/pages/admin-organization-edit.ftl").forward(req, resp);
            }
        } else if (req.getParameter("delete") != null) {
            Long delete = Long.parseLong(req.getParameter("delete"));

            optionalOrganization = organizationsService.getOrganizationById(delete);

            optionalOrganization.ifPresent(organizationsService::deleteOrganization);

            resp.sendRedirect("/adminOrganizations");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrganizationsService organizationsService =
                (OrganizationsService) getServletContext().getAttribute("organizationsService");

        Optional<Organization> optionalOrganization;

        Long edit = Long.parseLong(req.getParameter("edit"));

        optionalOrganization = organizationsService.getOrganizationById(edit);

        if (optionalOrganization.isPresent()) {
            Organization organization = optionalOrganization.get();
            organization.setName(req.getParameter("name"));
            organization.setAddress(req.getParameter("address"));
            organization.setType(req.getParameter("type"));
            organization.setDescription(req.getParameter("description"));

            organizationsService.updateOrganization(organization);
        }

        resp.sendRedirect("/adminOrganizations");
    }
}
