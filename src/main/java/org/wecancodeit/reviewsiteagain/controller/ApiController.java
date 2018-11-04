package org.wecancodeit.reviewsiteagain.controller;


	import java.util.Collection;
	import java.util.List;

	import org.json.JSONException;
	import org.json.JSONObject;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.reviewsiteagain.modle.Review;
import org.wecancodeit.reviewsiteagain.modle.Tag;
import org.wecancodeit.reviewsiteagain.repository.ReviewRepository;
import org.wecancodeit.reviewsiteagain.repository.TagRepository;
	

	@RestController
	public class ApiController {

		@Autowired
		TagRepository tagRepo;

		@Autowired
		ReviewRepository reviewRepo;

		// get rid of fancy stuff
		@GetMapping("/api/reviews/{id}")
		public Collection<Tag> getTagsForReview(@PathVariable(value = "id") Long id) {
			return reviewRepo.findById(id).get().getTags();
		}

		@PostMapping("/api/reviews/{id}/tags/add")
		public Collection<Tag> addTag(@PathVariable(value = "id") Long id, @RequestBody String body) throws JSONException {
			System.out.println(body);
			JSONObject json = new JSONObject(body);
			String tagName = json.getString("tagName");
			System.out.println(tagName);
			System.out.println(id);
			Review review = reviewRepo.findById(id).get();
			if (tagRepo.findByTagName(tagName) == null) {
				Tag tag = new Tag(tagName, review);
				review.addTag(tag);
				tagRepo.save(tag);
				System.out.println(review.getTags());
			}

			else {
				Tag tag = tagRepo.findByTagName(tagName);
				tag.addReview(review);
				review.addTag(tag);
				tagRepo.save(tag);
				System.out.println("Hitthing this " + tag.getReviews());
			}

			return review.getTags();
		}
}
