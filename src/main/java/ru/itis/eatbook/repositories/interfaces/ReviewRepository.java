package ru.itis.eatbook.repositories.interfaces;

import ru.itis.eatbook.models.Review;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review> {
    List<Review> findReviewsByOrganizationId(Long id);
}
