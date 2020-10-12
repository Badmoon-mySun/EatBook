package ru.itis.eatbook.services;

import ru.itis.eatbook.models.Review;
import ru.itis.eatbook.repositories.interfaces.ReviewRepository;
import ru.itis.eatbook.services.interfaces.ReviewsService;

import java.util.List;

public class ReviewsServiceImpl implements ReviewsService {
    private ReviewRepository repository;

    public ReviewsServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Review> getAllOrganizationReviews(Long id) {
        return repository.findReviewsByOrganizationId(id);
    }
}
