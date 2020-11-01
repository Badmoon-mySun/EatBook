package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.Organization;

import ru.itis.eatbook.services.interfaces.FileService;
import ru.itis.eatbook.services.interfaces.OrganizationsService;

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
public class OrganizationImageUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("image");
        Long id = Long.parseLong(req.getParameter("id"));

        String filename = "organization" + UUID.randomUUID().toString() + part.getSubmittedFileName();

        FileService fileService =
                (FileService) getServletContext().getAttribute("fileService");

        String path = (String) getServletContext().getAttribute("IMAGE_DIR");

        fileService.upload(part, path, filename);

        OrganizationsService organizationsService =
                (OrganizationsService) getServletContext().getAttribute("organizationsService");

        Optional<Organization> optionalOrganization = organizationsService.getOrganizationById(id);
        if (optionalOrganization.isPresent()) {
            Organization organization = optionalOrganization.get();

            organization.setImage(filename);

            organizationsService.updateOrganization(organization);
        }

        resp.sendRedirect("/adminOrganizations");
    }
}
