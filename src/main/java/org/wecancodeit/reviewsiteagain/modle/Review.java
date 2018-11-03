package org.wecancodeit.reviewsiteagain.modle;
	
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Collection;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.JoinTable;
	import javax.persistence.Lob;
	import javax.persistence.ManyToMany;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToMany;

	@Entity
	public class Review {
		@Id
		@GeneratedValue
		private Long id;
		private String reviewName;
		@Lob
		private String reviewDescription;
		private String reviewRating;
		private String reviewImage;

		@ManyToOne
		private Category category;

		@ManyToMany
		private Collection<Tag> tags;

		@OneToMany(mappedBy = "review")
		private Collection<Comment> comments;

		public Collection<Comment> getComments() {
			return comments;
		}

		public Review() {
		}

		public Review(String reviewName, String reviewDescription, String reviewRating,
				String reviewImage, Category category, List<Tag> tags) {
			this.reviewName = reviewName;
			this.reviewDescription = reviewDescription;
			this.reviewRating = reviewRating;
			this.reviewImage = reviewImage;
			this.category = category;
			this.tags = tags;
		}

		public Review(String reviewName, String reviewDescription, String reviewRating,
				String reviewImage, Category category) {
			this.reviewName = reviewName;
			this.reviewDescription = reviewDescription;
			this.reviewRating = reviewRating;
			this.reviewImage = reviewImage;
			this.category = category;
		}

		public Long getId() {
			return id;
		}

		public String getReviewName() {
			return reviewName;
		}

		public String getReviewDescription() {
			return reviewDescription;
		}


		public String getReviewRating() {
			return reviewRating;
		}

		public String getReviewImage() {
			return reviewImage;
		}

		public Category getCategory() {
			return category;
		}

		public void addTag(Tag tag) {
			tags.add(tag);
		}

		public Collection<Tag> getTags() {
			return tags;
		}

	}
