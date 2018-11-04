package org.wecancodeit.reviewsiteagain;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviewsiteagain.modle.Category;
import org.wecancodeit.reviewsiteagain.modle.Review;
import org.wecancodeit.reviewsiteagain.repository.CategoryRepository;
import org.wecancodeit.reviewsiteagain.repository.ReviewRepository;

@Service
public class Populator implements CommandLineRunner {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

	@Override
	public void run(String... args) throws Exception {
		Category category1 = new Category("Sprite");
		Category category2 = new Category("Game");
		

		category1 = categoryRepo.save(category1);
		category2 = categoryRepo.save(category2);
		

		// Sprite
		Review review1 = new Review("Mario",
				"Mario’s sprite is one of the most iconic sprites of all time. The use of only four key frames for Mariols run cycle and two for his jump provide the striking visuales that have been the gold standard for sprite animation in the modern day.",
				 "10/10", "/super-mario-world.png", category1);
		Review review2 = new Review("Samus",
				"Samus nonsymmetrical sprite requires key frames for her left and right side this requirement prevents simply reflecting her key frames. The attention to detail handling this shows the fanese used when managing her 8 farme move cycle. ",
				 "9/10", "/super-metroid.png", category1);
		Review review3 = new Review("Link",
				"Links sprite page contains all of Links extensive animation set along with a few unique animation loops to deal with one time key events. In addition Link’s sheet contains all ancillary items that link generates in his attack animation. The one problem with this sheet is that there are a few repeated keyframes in the the walk animation cycle. ",
				"8/10", "/link-to-the-past.png", category1);

		review1 = reviewRepo.save(review1);
		review2 = reviewRepo.save(review2);
		review3 = reviewRepo.save(review3);

		// Game
		Review review4 = new Review("Link To The Past", "description",
				"8/10", "/link-to-the-past-cover.png", category2);
		Review review5 = new Review("Super Mario World", "Link to the past  is one of my all time favorite games up in my to five the aesthetic and the feeling of adventure fostered my love of video game but is not a perfect game it can be easy to get lost in the  overworld world while trying to figure out what to do next and the indication markers on the map detract from the felling of the world in addition they are not that helpful in when traveling to  the dungeons. I personally would have liked to see these markers removed and replaced with an alternate hint.",
				"8/10", "/super-mario-cover.png", category2);
		Review review6 = new Review("Super Metroid", "Super metroid is one of the best 2D platformers of all time frome its atmosphere to its gameplay metroid is a joy to from play from your first trip through Zebes or your tenth. Super Metroid accomplishes this feat through its smart game design providing first time players with a clear path through all its dangers providing subtle hints about the complex strategies that can  allow players to blaze through the game on new  a playthrough skipping many of the introductory parts of the game. This ability to hold new players hands and allow old players the freedom to play their way is the mark of a truly great game.",
				"9/10", "/super-metroid-cover.png", category2);

		review4 = reviewRepo.save(review4);
		review5 = reviewRepo.save(review5);
		review6 = reviewRepo.save(review6);

		
	}
}
