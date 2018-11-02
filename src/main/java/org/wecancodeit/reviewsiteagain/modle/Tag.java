package org.wecancodeit.reviewsiteagain.modle;

	import java.util.ArrayList;
	import java.util.List;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.ManyToMany;

	@Entity
	public class Tag {

		@Id
		@GeneratedValue
		private Long id;
		private String tagName;

		@ManyToMany(mappedBy = "tags")
		private List<Review> reviews = new ArrayList<Review>();

		public Tag() {
		}

		public Tag(String tagName) {
			this.tagName = tagName;
		}

		public Long getId() {
			return id;
		}

		public String getTagName() {
			return tagName;
		}

		public List<Review> getReviews() {
			return reviews;
		}

	}
