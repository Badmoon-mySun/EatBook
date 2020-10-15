package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.Table;
import ru.itis.eatbook.services.interfaces.TablesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TablesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TablesService tablesService = (TablesService) getServletContext().getAttribute("tablesService");

        Long orgId = Long.parseLong(req.getParameter("id"));

        List<Table> tables = tablesService.getAllTablesByOrganizationId(orgId);

        req.setAttribute("tables", tables);

        req.getRequestDispatcher("/WEB-INF/pages/tables.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
