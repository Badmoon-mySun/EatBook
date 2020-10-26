package ru.itis.eatbook.services;

import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.models.Review;
import ru.itis.eatbook.models.User;
import ru.itis.eatbook.repositories.interfaces.ReviewRepository;
import ru.itis.eatbook.services.interfaces.ReviewsService;

import java.util.Date;
import java.util.GregorianCalendar;
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

    @Override
    public void createAndSaveNewReview(User user, Organization organization, String text) {
        Review review = Review.builder()
                .date(GregorianCalendar.getInstance().getTime())
                .user(user)
                .organization(organization)
                .text(text)
                .build();

        repository.save(review);
    }
}
