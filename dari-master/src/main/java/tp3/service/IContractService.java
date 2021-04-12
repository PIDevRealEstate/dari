package tp3.service;

import java.util.List;

import tn.dari.entities.Contract;

public interface IContractService {
	//public List<Contract> listAll();
	public Contract save(Contract contract);
	List<Contract> retrieveAllContract();
	void deleteContract(long id);
	Contract updateContract(Contract cont);
	List<Contract> findByType(String typecontract);
	Contract retrieveContract(long id);
	void ContractPdf(long id);
}