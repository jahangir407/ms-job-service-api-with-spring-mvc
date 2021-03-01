package com.jhub.msJobService.ws.service;

import java.util.List;

import com.jhub.msJobService.shared.dto.JobDto;

public interface JobService {
	
	List<JobDto> getAllJob();
	
	JobDto getJobById(String Id);
	
	JobDto createJob(JobDto jobDto);
	
	JobDto updateJob(String id, JobDto jobDto);
	
	Boolean deleteJobById(String id);
	
	Boolean hardDeleteJobById(String id);
	

}
