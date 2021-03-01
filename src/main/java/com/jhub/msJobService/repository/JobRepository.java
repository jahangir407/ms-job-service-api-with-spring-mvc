package com.jhub.msJobService.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jhub.msJobService.io.entity.JobEntity;

@Repository
public interface JobRepository extends PagingAndSortingRepository<JobEntity, String> {
	
	List<JobEntity> findAll();

}
