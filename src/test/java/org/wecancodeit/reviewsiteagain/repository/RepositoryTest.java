package org.wecancodeit.reviewsiteagain.repository;

	import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.Collection;


	import javax.annotation.Resource;

	import org.junit.Assert;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
	import org.springframework.test.context.junit4.SpringRunner;
	import org.wecancodeit.reviewsiteagain.repository.ReviewRepository;
	import org.wecancodeit.reviewsiteagain.modle.Review;
	import org.wecancodeit.reviewsiteagain.modle.Tag;

	@RunWith(SpringRunner.class)
	@DataJpaTest
	public class RepositoryTest {


		@Resource
		TagRepository tagRepo;
		
		@Resource
		ReviewRepository repo;

		@Test
		public void shouldReturnAllContacts() {
			Review review = repo.save(new Review());
			Review review2 = repo.save(new Review());
			Iterable<Review> result = repo.findAll();
			assertThat(result, hasItems(review2));
		}

		@Test
		public void shouldAddATag() {
			Tag tag1 = new Tag("tag");
			tagRepo.save(tag1);
			Iterable<Tag> result = tagRepo.findAll();
			Assert.assertThat(result, hasItem(tag1));
		}

		public void shouldAddATagToReview() {
			Tag tag1 = new Tag("tag");
			Review review = new Review();
			review.addTag(tag1);
			Assert.assertThat(review.getTags(), hasItem(tag1));
		}
}
