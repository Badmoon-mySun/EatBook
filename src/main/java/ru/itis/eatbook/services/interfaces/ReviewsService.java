package ru.itis.eatbook.services.interfaces;

import ru.itis.eatbook.models.Review;

import java.util.List;

public interface ReviewsService {
    List<Review> getAllOrganizationReviews(Long id);
}
