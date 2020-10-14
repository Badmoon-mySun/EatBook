package ru.itis.eatbook.services.interfaces;

import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.models.Review;
import ru.itis.eatbook.models.User;

import java.util.List;

public interface ReviewsService {
    List<Review> getAllOrganizationReviews(Long id);
    void saveNewReview(User user, Organization organization, String text);
}
