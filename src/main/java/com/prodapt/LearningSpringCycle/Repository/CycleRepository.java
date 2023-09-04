package com.prodapt.LearningSpringCycle.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.LearningSpringCycle.Entity.CycleTable;

@Repository
public interface CycleRepository extends CrudRepository<CycleTable, Integer>{

//	@Query("select * from CycleTable ")
//	List<CycleTable> findById();
	
}
