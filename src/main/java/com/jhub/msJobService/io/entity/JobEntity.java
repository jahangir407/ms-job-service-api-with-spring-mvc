package com.jhub.msJobService.io.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JGlobalMap
public class JobEntity extends BaseEntity {

	private String userId;
	private String title;
	private String description;
	private String location;
	private LocalDate joiningDate;
	private LocalDate lastAppliedDate;
	
}
