package ru.itis.eatbook.services.interfaces;

import ru.itis.eatbook.models.OrderTable;

import java.util.Date;
import java.util.List;

public interface DateService {
    List<String> getDaysForAWeek();

    Date getDateByString(String date);

    List<Integer> getAvailableTime(List<OrderTable> orderTables, Date date, int hours);
}
