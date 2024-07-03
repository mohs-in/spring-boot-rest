package com.telusko.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.telusko.springbootrest.model.JobPost;
import com.telusko.springbootrest.service.JobService;

@RestController
@CrossOrigin(origins = "http://localhost:3000" )
public class JobRestController {
	
	@Autowired
	private JobService service;

	@GetMapping("jobPosts")
	public List<JobPost> getAllJobs() {
		return service.getAllJobs();
	}

	@GetMapping("jobPost/{postId}")
	public JobPost getJob(@PathVariable int postId) {
		return service.getJob(postId);
	}

	@PostMapping("jobPost")
	public JobPost addJobPost(@RequestBody JobPost jobPost) {
		service.addJobPost(jobPost);
		return service.getJob(jobPost.getPostId());
	}

	@PutMapping("jobPost")
	public JobPost updateJob(@RequestBody JobPost jobPost) {
		return service.updateJob(jobPost);
	}

	@DeleteMapping("jobPost/{postId}")
	public String deleteJob(@PathVariable int postId) {

		service.deleteJob(postId);
		return "Deleted";

	}

	@GetMapping("load")
	public String loadData() {
		service.load();
		return "success";
	}

	@GetMapping("jobPosts/keyword/{keyword}")
	public List<JobPost> searchByKeyword(@PathVariable String keyword) {
		return service.search(keyword);
	}

}
