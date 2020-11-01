package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.services.interfaces.OrganizationsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminNewOrganizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/admin-organization-edit.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrganizationsService organizationsService =
                (OrganizationsService) getServletContext().getAttribute("organizationsService");

        Organization organization = Organization.builder()
                .name(req.getParameter("name"))
                .address(req.getParameter("address"))
                .type(req.getParameter("type"))
                .description(req.getParameter("description"))
                .build();

        organizationsService.saveOrganization(organization);

        resp.sendRedirect("/adminOrganizations");
    }
}
