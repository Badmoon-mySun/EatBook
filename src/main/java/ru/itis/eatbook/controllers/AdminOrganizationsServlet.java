package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.services.interfaces.OrganizationsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminOrganizationsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrganizationsService organizationsService =
                (OrganizationsService) getServletContext().getAttribute("organizationsService");

        List<Organization> organizations = organizationsService.getAllOrganization();

        req.setAttribute("organizations", organizations);

        req.getRequestDispatcher("/WEB-INF/pages/admin-organizations.ftl").forward(req, resp);
    }
}
