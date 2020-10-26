package ru.itis.eatbook.controllers;

import org.json.JSONObject;
import ru.itis.eatbook.models.OrderTable;
import ru.itis.eatbook.models.Table;
import ru.itis.eatbook.services.interfaces.DateService;
import ru.itis.eatbook.services.interfaces.OrderTablesService;
import ru.itis.eatbook.services.interfaces.TablesService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class AjaxTableAvailableTimeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OrderTablesService orderTablesService =
                (OrderTablesService) getServletContext().getAttribute("orderTablesService");

        TablesService tablesService = (TablesService) getServletContext().getAttribute("tablesService");

        DateService dateService = (DateService) getServletContext().getAttribute("dateService");

        JSONObject jsonObject = (JSONObject) req.getAttribute("jsonObj");

        Date day = dateService.getDateByString(jsonObject.getString("day"));
        Long id = jsonObject.getLong("id");
        int hours = jsonObject.getInt("hours");

        List<OrderTable> orderTables = orderTablesService.getAllOrdersByTableId(id);

        JSONObject result = new JSONObject();
        result.put("time", dateService.getAvailableTime(orderTables, day, hours));
        Optional<Table> optionalTable = tablesService.getTableById(id);
        if (optionalTable.isPresent()) {
            result.put("prise", optionalTable.get().getPrise() * hours);
        } else {
            result.put("prise", "");
        }

        resp.setContentType("application/json");
        resp.getWriter().println(result.toString());
    }
}
