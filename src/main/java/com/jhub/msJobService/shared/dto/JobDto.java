package com.jhub.msJobService.shared.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JGlobalMap
public class JobDto {
	
	private String id;
	
	private String userId;
	private String title;
	private String description;
	private String location;
	private LocalDate joiningDate;
	private LocalDate lastAppliedDate;
	
	private Boolean isDeleted;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;

}
