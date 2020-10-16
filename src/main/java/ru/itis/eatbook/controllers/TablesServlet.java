package ru.itis.eatbook.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import ru.itis.eatbook.models.OrderTable;
import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.models.Table;
import ru.itis.eatbook.services.interfaces.OrderTablesService;
import ru.itis.eatbook.services.interfaces.OrganizationsService;
import ru.itis.eatbook.services.interfaces.TablesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TablesServlet extends HttpServlet {
    DateFormat dateFormat = new SimpleDateFormat("EEEE, d MMM y");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TablesService tablesService = (TablesService) getServletContext().getAttribute("tablesService");

        Long orgId = Long.parseLong(req.getParameter("id"));

        List<Table> tables = tablesService.getAllTablesByOrganizationId(orgId);

        req.setAttribute("tables", tables);

        List<String> days = new ArrayList<>();
        Calendar calendar = GregorianCalendar.getInstance();


        for (int i = 0; i < 7; i++) {
            days.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        req.setAttribute("days", days);

        req.getRequestDispatcher("/WEB-INF/pages/tables.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderTablesService orderTablesService = (OrderTablesService) getServletContext().getAttribute("orderTablesService");

        JSONObject jsonObject = (JSONObject) req.getAttribute("jsonObj");

        Long id = jsonObject.getLong("id");
        String day = jsonObject.getString("day");
        int hours = jsonObject.getInt("hours");

        List<OrderTable> orderTables = orderTablesService.getAllOrdersByTableId(id);

        Date date = null;

        try {
            date = dateFormat.parse(day);
        } catch (ParseException e) {
            throw new IllegalStateException(e);
        }

        JSONObject result = new JSONObject();

        for (int i = 9; i < 24 - hours; i++) {
            boolean flag = true;
            for (OrderTable order : orderTables) {
                date.setHours(i);
                if (date.after(order.getDateOf()) && date.before(order.getDateTo())) {
                    flag = false;
                    break;
                }
                date.setHours(i + hours);
                if (date.after(order.getDateOf()) && date.before(order.getDateTo())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.append("time", i);
            }
        }

        resp.setContentType("application/json");
        System.out.println(result);
        resp.getWriter().println(result.toString());
    }
}
