package tp3.service;

import java.util.List;

import tn.dari.entities.Assurance;

public interface IAssuranceService {

	public void DeleteAssurance  (int IdAssurance);
	public Assurance RetrieveAssurance (int IdAssurance);
	public Assurance UpdateAssurance  (Assurance ass);
	public Assurance AjouterAssurance(Assurance assurance);
	List<Assurance> RetrieveAllAssurance();
}