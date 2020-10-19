package ru.itis.eatbook.controllers;

import org.json.JSONObject;
import ru.itis.eatbook.models.OrderTable;
import ru.itis.eatbook.services.interfaces.DateService;
import ru.itis.eatbook.services.interfaces.OrderTablesService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class AjaxTableAvailableTimeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OrderTablesService orderTablesService =
                (OrderTablesService) getServletContext().getAttribute("orderTablesService");

        DateService dateService = (DateService) getServletContext().getAttribute("dateService");

        JSONObject jsonObject = (JSONObject) req.getAttribute("jsonObj");

        Date day = dateService.getDateByString(jsonObject.getString("day"));
        Long id = jsonObject.getLong("id");
        int hours = jsonObject.getInt("hours");

        List<OrderTable> orderTables = orderTablesService.getAllOrdersByTableId(id);

        JSONObject result = new JSONObject();
        result.put("time", dateService.getAvailableTime(orderTables, day, hours));

        resp.setContentType("application/json");
        resp.getWriter().println(result.toString());
    }
}
