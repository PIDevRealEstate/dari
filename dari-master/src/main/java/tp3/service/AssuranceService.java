package tp3.service;

 
 
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.entities.Assurance;
import tp3.repository.AssuranceRepository;

 

@Service
public class AssuranceService implements IAssuranceService {

	private static final Logger L =  LogManager.getLogger(ContractService.class);

	@Autowired
	AssuranceRepository AssuranceRep;
	
	@Override
	public void DeleteAssurance(int IdAssurance) {
		Optional<Assurance> assurance = AssuranceRep.findById(IdAssurance);
	    
	    if(assurance.isPresent()) 
	    {
	    	AssuranceRep.deleteById(IdAssurance);
	    }			}
	
	@Override
	public Assurance AjouterAssurance(Assurance assurance) {
		return AssuranceRep.save(assurance);
	}
	
	@Override
	public Assurance RetrieveAssurance(int IdAssurance) {
		Optional<Assurance> assurance = AssuranceRep.findById(IdAssurance);
		if(assurance.isPresent()) {
	        return assurance.get();}
		return null;		 
	}
 
	@Override
	public List<Assurance> RetrieveAllAssurance() {
		List<Assurance> assurances = (List<Assurance>) AssuranceRep.findAll();
		for (Assurance assurance : assurances){
		L.info("assurance +++: " + assurance );}
		return assurances;
	}

	@Override
	public Assurance UpdateAssurance(Assurance ass) {
		Optional<Assurance> assurance = AssuranceRep.findById(ass.getIdAssurance());
		if(assurance.isPresent()) 
	    {
			Assurance NewAssurance = assurance.get();

			NewAssurance.setTitleAssurance(ass.getTitleAssurance());
			NewAssurance.setDescription(ass.getDescription());
			NewAssurance.setContract(ass.getContract());

			NewAssurance = AssuranceRep.save(NewAssurance);
	         
	        return NewAssurance;
	    } else {
	    	ass = AssuranceRep.save(ass);
	        return ass;
	    }		
	}
  	 
}
