package ru.itis.eatbook.services.interfaces;

import ru.itis.eatbook.models.Discount;

import java.util.List;
import java.util.Optional;

public interface DiscountsService {
    List<Discount> getAllDiscounts();
    Optional<Discount> getDiscountById(Long id);
}
