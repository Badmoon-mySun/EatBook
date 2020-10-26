package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.OrderTable;
import ru.itis.eatbook.models.Table;
import ru.itis.eatbook.models.User;
import ru.itis.eatbook.services.interfaces.DateService;
import ru.itis.eatbook.services.interfaces.OrderTablesService;
import ru.itis.eatbook.services.interfaces.TablesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class TablesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TablesService tablesService = (TablesService) getServletContext().getAttribute("tablesService");
        DateService dateService = (DateService) getServletContext().getAttribute("dateService");

        Long orgId = Long.parseLong(req.getParameter("id"));

        List<Table> tables = tablesService.getAllTablesByOrganizationId(orgId);

        req.setAttribute("tables", tables);

        req.setAttribute("days", dateService.getDaysForAWeek());

        req.getRequestDispatcher("/WEB-INF/pages/tables.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TablesService tablesService = (TablesService) getServletContext().getAttribute("tablesService");
        DateService dateService = (DateService) getServletContext().getAttribute("dateService");
        OrderTablesService orderTablesService =
                (OrderTablesService) getServletContext().getAttribute("orderTablesService");

        Long tableId = Long.parseLong(req.getParameter("tableId"));
        int hour = Integer.parseInt(req.getParameter("hour"));
        int time = Integer.parseInt(req.getParameter("time"));
        User user = (User) req.getSession().getAttribute("user");

        Date dateOf = dateService.getDateByString(req.getParameter("day"));
        dateOf.setHours(time);
        Date dateTo = new Date(dateOf.getTime());
        dateTo.setHours(time + hour);

        Optional<Table> optionalTable = tablesService.getTableById(tableId);

        if (optionalTable.isPresent()) {
            OrderTable orderTable = OrderTable.builder()
                    .table(optionalTable.get())
                    .user(user)
                    .dateOf(dateOf)
                    .dateTo(dateTo)
                    .prise(optionalTable.get().getPrise() * hour)
                    .build();

            orderTablesService.newOrderTable(orderTable);

            resp.sendRedirect("/successOrder");
        }
    }
}
