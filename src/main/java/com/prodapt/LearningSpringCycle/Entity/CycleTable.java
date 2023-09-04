package com.prodapt.LearningSpringCycle.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class CycleTable {

	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Integer Stock;
	
	
	
	
	
}
