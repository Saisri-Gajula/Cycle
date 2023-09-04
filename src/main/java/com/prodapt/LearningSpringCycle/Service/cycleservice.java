package com.prodapt.LearningSpringCycle.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prodapt.LearningSpringCycle.Entity.CycleTable;
import com.prodapt.LearningSpringCycle.Repository.CycleRepository;

@Service
public class cycleservice {


        @Autowired
        private CycleRepository cyclerepository;

        public void borrowmethod(int id) {
            var presentcycleoptional = cyclerepository.findById(id);
            if (presentcycleoptional.isEmpty()) {
                
                System.out.println("No cycle present.");
            }
            var presentcycle = presentcycleoptional.get();
            int presentstock = cyclerepository.findById(id).get().getStock();
            presentcycle.setStock(presentstock - 1);
//            if(presentstock == 0) {
//            	cyclerepository.deleteById(id);;
//            }
            cyclerepository.save(presentcycle);
        }
        
        public void savecycle(CycleTable cycle) {
        	cyclerepository.save(cycle);
        }

        public CycleTable getid(int id) {
            return cyclerepository.findById(id).get();
        }

        public void restockmethod(int id) {
        	var presentcycleoptional = cyclerepository.findById(id);
        	if (presentcycleoptional.isEmpty()) {
                
                System.out.println("SUch cycle is not present.");
            }
        }
       

        public void returnmethod(int id) {
            var presentcycleoptional = cyclerepository.findById(id);
            if (presentcycleoptional.isEmpty()) {
               
                System.out.println("SUch cycle is not present.");
            }
            var presentcycle = presentcycleoptional.get();
            int currentstock = cyclerepository.findById(id).get().getStock();
            presentcycle.setStock(currentstock + 1);
            cyclerepository.save(presentcycle);
        }
}