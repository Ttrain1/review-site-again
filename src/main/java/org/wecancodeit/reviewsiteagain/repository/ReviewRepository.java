package org.wecancodeit.reviewsiteagain.repository;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewsiteagain.modle.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {

}
