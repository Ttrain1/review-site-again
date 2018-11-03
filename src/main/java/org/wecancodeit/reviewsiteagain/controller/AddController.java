package org.wecancodeit.reviewsiteagain.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviewsiteagain.modle.Comment;
import org.wecancodeit.reviewsiteagain.modle.Category;
import org.wecancodeit.reviewsiteagain.modle.Tag;
import org.wecancodeit.reviewsiteagain.repository.CategoryRepository;
import org.wecancodeit.reviewsiteagain.repository.CommentRepository;
import org.wecancodeit.reviewsiteagain.repository.ReviewRepository;
import org.wecancodeit.reviewsiteagain.repository.TagRepository;

@Controller
public class AddController {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

	@Autowired
	CommentRepository commentRepo;

	@Autowired
	TagRepository tagRepo;

	@RequestMapping("categories")
	public String listCourses(Model model) {
				model.addAttribute("categories", categoryRepo.findAll());
		return "categories";
	}

	@RequestMapping("categories/{id}")
	public String listPerson(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("category", categoryRepo.findById(id).get());
		model.addAttribute("categories", categoryRepo.findAll());
		return "category";
	}

	@RequestMapping("/reviews")
	public String getContacts(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		model.addAttribute("categories", categoryRepo.findAll());
		return "reviews";
	}

	@RequestMapping("/reviews/{id}")
	public String getContact(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("review", reviewRepo.findById(id).get());
		model.addAttribute("categories", categoryRepo.findAll());
		return "review";
	}

	@PostMapping("/reviews/{id}")
	public String addComment(@PathVariable(value = "id") Long id, String username, String content, Model model) {
		commentRepo.save(new Comment(username, content, reviewRepo.findById(id).get()));
		return "redirect:/reviews/{id}";
	}

	@PostMapping("/reviews/{id}/tag")
	public String addTag(@PathVariable(value = "id") Long id, String tagName, Model model) {
		Tag tag = new Tag(tagName);
		reviewRepo.findById(id).get().addTag(tag);
		tagRepo.save(tag);
		return "redirect:/reviews/{id}";
	}

}

