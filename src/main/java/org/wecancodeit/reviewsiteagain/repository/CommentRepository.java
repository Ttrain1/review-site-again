package org.wecancodeit.reviewsiteagain.repository;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewsiteagain.modle.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
