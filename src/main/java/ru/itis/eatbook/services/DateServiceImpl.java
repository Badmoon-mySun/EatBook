package ru.itis.eatbook.services;

import ru.itis.eatbook.models.OrderTable;
import ru.itis.eatbook.services.interfaces.DateService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateServiceImpl implements DateService {
    DateFormat dateFormat = new SimpleDateFormat("EEEE, d MMM y");
    DateFormat anotherDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public List<String> getDaysForAWeek() {
        List<String> week = new ArrayList<>();
        Calendar calendar = GregorianCalendar.getInstance();

        for (int i = 0; i < 7; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            week.add(dateFormat.format(calendar.getTime()));
        }

        return week;
    }

    @Override
    public Date getDateByString(String date) {
        Date result = null;

        try {
            result = dateFormat.parse(date);
        } catch (ParseException ignore) { }

        if (result == null) {
            try {
                result = anotherDateFormat.parse(date);
            } catch (ParseException e) {
                throw new IllegalStateException(e);
            }
        }

        return result;
    }

    @Override
    public List<Integer> getAvailableTime(List<OrderTable> orderTables, Date date, int hours) {
        List<Integer> result = new ArrayList<>();

        boolean flag = true;
        for (int i = 9; i < 24 - hours; i++) {
            for (OrderTable order : orderTables) {
                date.setHours(i);
                if ((date.after(order.getDateOf()) && date.before(order.getDateTo()))
                        || date.equals(order.getDateOf())) {
                    flag = false;
                    break;
                }

                date.setHours(i + hours);
                if (date.equals(order.getDateTo())) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result.add(i);
            } else {
                flag = true;
            }
        }

        return result;
    }
}
