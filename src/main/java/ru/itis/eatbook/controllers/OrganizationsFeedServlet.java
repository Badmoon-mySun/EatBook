package ru.itis.eatbook.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.services.interfaces.OrganizationsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrganizationsFeedServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/organizationsFeed.ftl").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrganizationsService organizationsService =
                (OrganizationsService) getServletContext().getAttribute("organizationsService");

        JSONObject jsonObject = (JSONObject) req.getAttribute("jsonObj");


        String text = jsonObject.getString("search");
        String category = jsonObject.getString("category");

        Long id = 1L;
        try {
            id = Long.parseLong(text);
        } catch (NumberFormatException ignore) {}

        List<Organization> organizations = new ArrayList<>();
        organizations.add(organizationsService.getOrganizationById(id).get());


        String jsonResponse = objectMapper.writeValueAsString(organizations);

        resp.setContentType("application/json");
        System.out.println(jsonResponse);
        resp.getWriter().println(jsonResponse);
    }
}
