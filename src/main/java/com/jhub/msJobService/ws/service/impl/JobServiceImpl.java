package com.jhub.msJobService.ws.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.googlecode.jmapper.JMapper;
import com.jhub.msJobService.io.entity.JobEntity;
import com.jhub.msJobService.repository.JobRepository;
import com.jhub.msJobService.shared.dto.JobDto;
import com.jhub.msJobService.ws.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	private final JobRepository jobRepository;
	private final JMapper<JobEntity, JobDto> jobDtoToJobEntityMapper;
	private final JMapper<JobDto, JobEntity> jobEntityToJobDto;

	public JobServiceImpl(JobRepository jobRepository) {

		this.jobRepository = jobRepository;
		this.jobDtoToJobEntityMapper = new JMapper<>(JobEntity.class, JobDto.class);
		this.jobEntityToJobDto = new JMapper<>(JobDto.class, JobEntity.class);

	}

	@Override
	public List<JobDto> getAllJob() {
		return this.jobRepository.findAll().stream().map(x -> jobEntityToJobDto.getDestination(x))
				.collect(Collectors.toList());
	}

	@Override
	public JobDto getJobById(String Id) {
		return this.jobRepository.findById(Id).map(x -> jobEntityToJobDto.getDestination(x)).get();
	}

	@Override
	public JobDto createJob(JobDto jobDto) {
		return jobEntityToJobDto
				.getDestination(this.jobRepository.save(jobDtoToJobEntityMapper.getDestination(jobDto)));
	}

	@Override
	public JobDto updateJob(String id, JobDto jobDto) {

		return this.jobRepository.findById(id).map(x -> {
			x.setUpdatedAt(LocalDateTime.now());
			x.setJoiningDate(jobDto.getJoiningDate());
			x.setTitle(jobDto.getTitle());
			return x;
		}).map(x -> this.jobEntityToJobDto.getDestination(this.jobRepository.save(x))).get();
	}

	@Override
	public Boolean deleteJobById(String id) {

		return this.jobRepository.findById(id).map(x -> {
			x.setDeletedAt(LocalDateTime.now());
			x.setIsDeleted(true);
			return x;
		}).map(x -> this.jobRepository.save(x)).get().getIsDeleted() == true ? true : false;
	}

	@Override
	public Boolean hardDeleteJobById(String id) {
		
		this.jobRepository.findById(id)
		.ifPresentOrElse(x -> this.jobRepository.delete(x), ()-> {throw new RuntimeException();});
		return true;
	}

}
