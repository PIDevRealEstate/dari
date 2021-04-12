package tn.dari.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.entities.Contract;
import tp3.service.ContractService;

@RestController
@RequestMapping("/Contract")
public class RestControlContract {
	@Autowired
	ContractService sS;
	// http://localhost:8081/SpringMVC/servlet/Contract/add-contract
		@PostMapping("/add-contract")
		@ResponseBody
		public Contract saveContract(@RequestBody Contract cont) {
		Contract contract = sS.save(cont);
		return contract;
		}
		
		// http://localhost:8081/SpringMVC/servlet//Contract/retrieve-all-Contracts
		@GetMapping("/retrieve-all-Contracts")
		@ResponseBody
		public List<Contract> getContracts() {
		List<Contract> list = sS.retrieveAllContract();
		return list;
		}
		
		// http://localhost:8081/SpringMVC/servlet//Contract/remove-Contract/{contract-id}
		@DeleteMapping("/remove-Contract/{contract-id}")
		@ResponseBody
		public void removeContract(@PathVariable("contract-id") long contractId) {
		sS.deleteContract(contractId);
		}
		
		// http://localhost:8081/SpringMVC/servlet//Contract/modify-Contract
		@PutMapping("/modify-Contract")
		@ResponseBody
		public Contract modifyContract(@RequestBody Contract cont) {
		return sS.updateContract(cont);
		}
		
		// http://localhost:8081/SpringMVC/servlet//Contract/contract/{typecontract}
		@GetMapping("/contract/{typecontract}")
		@ResponseBody
		public List<Contract> findByType(@PathVariable("typecontract") String typecontract) {
		return sS.findByType(typecontract);
		}
				
			
		// http://localhost:8081/SpringMVC/servlet//Contract/retrieve-Contract/{contract-id}
		@GetMapping("/retrieve-Contract/{Contract-id}")
		@ResponseBody
		public Contract retrieveContract(@PathVariable("Contract-id") long id) {
		return sS.retrieveContract(id);
		}
				
				
								
		// URL : http://localhost:8081/SpringMVC/servlet/Contract//showPDF/{id}
		@GetMapping("/showPDF/{id-contract}")
		public void contractpdf (@PathVariable("id-contract") long id) {			   
		sS.ContractPdf(id);
		}
		
}