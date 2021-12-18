package com.jhub.msJobService.ws.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhub.msJobService.shared.dto.JobDto;
import com.jhub.msJobService.ws.service.JobService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/job")
public class JobController {
	@Autowired
	JobService jobService;

	@GetMapping
	List<JobDto> getAllJob() {
		log.info("Retriving all jod details...");
		return this.jobService.getAllJob();
	}

	@GetMapping(path = "/{id}")
	JobDto getJobDetailsById(@PathVariable("id") String id) {
		log.info("Retriving jod details for ID:" +id);
		return this.jobService.getJobById(id);
	}

	@PostMapping
	JobDto createJob(@RequestBody JobDto jobDto) {
		log.info("Creating new job info with :", jobDto);
		return this.jobService.createJob(jobDto);

	}

	@PutMapping(path = "/{id}")
	JobDto updateJobDetails(@PathVariable("id") String id, @RequestBody JobDto jobDto) {
		log.info("Updating  existing job info with :", jobDto);
		return this.jobService.updateJob(id, jobDto);
	}
	
	@DeleteMapping(path = "/{id}")
	Boolean deleteJobById(@PathVariable("id") String id) {
		log.info("Deleting job details for ID: "+ id);
		return this.jobService.deleteJobById(id);
	}
	
	@DeleteMapping(path = "/hardDelete/{id}")
	Boolean hardDeleteJobById(@PathVariable("id") String id) {
		log.info("Permanently deleting job details for ID: "+ id);
		return this.jobService.hardDeleteJobById(id);
	}
}
