package ru.itis.eatbook.services;

import ru.itis.eatbook.models.Discount;
import ru.itis.eatbook.repositories.interfaces.DiscountRepository;
import ru.itis.eatbook.services.interfaces.DiscountsService;

import java.util.List;
import java.util.Optional;

public class DiscountsServiceImpl implements DiscountsService {
    private DiscountRepository discountRepository;

    public DiscountsServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    @Override
    public Optional<Discount> getDiscountById(Long id) {
        return discountRepository.findById(id);
    }
}
