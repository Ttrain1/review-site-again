package org.wecancodeit.reviewsiteagain.modle;

	import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.ManyToMany;



import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	public class Tag {

		@Id
		@GeneratedValue
		private Long id;
		private String tagName;
		
		@JsonIgnore
		@ManyToMany
		private Collection<Review> reviews = new HashSet<>();

		public Tag() {
		}

		public Tag(String tagName) {
			this.tagName = tagName;
		}

		public Tag(String tagName, Review review) {
			this.tagName = tagName;
			addReview(review);
		}

		public Long getId() {
			return id;
		}

		public String getTagName() {
			return tagName;
		}

		public void addReview(Review review) {
			reviews.add(review);
		}

		public Collection<Review> getReviews() {
			return reviews;
		}

	}