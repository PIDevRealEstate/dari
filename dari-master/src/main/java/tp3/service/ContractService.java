package tp3.service;

 
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.entities.Contract;
import tp3.repository.ContractRepository;


@Service
public class ContractService  implements IContractService{

	private static final Logger L =  LogManager.getLogger(ContractService.class);
	@Autowired
	ContractRepository CR;

	@Override
	public Contract save(Contract contract) {
		return CR.save(contract);
	}

	@Override
	public List<Contract> retrieveAllContract() {
		List<Contract> contracts = (List<Contract>) CR.findAll();
		for (Contract contract : contracts){
		L.info("contract +++: " + contract );}
		return contracts;
 	}

	@Override
	public void deleteContract(long id) {
		Optional<Contract> contract = CR.findById(id);
	    
	    if(contract.isPresent()) 
	    {
	        CR.deleteById(id);
	    }		
	}

	@Override
	public Contract updateContract(Contract cont) {
		Optional<Contract> contract = CR.findById(cont.getId());
		if(contract.isPresent()) 
	    {
			Contract newContract = contract.get();
	        newContract.setDateDebut(cont.getDateDebut());
	        newContract.setDuree(cont.getDuree());
	       	newContract.setAssurance(cont.getAssurance());

	        newContract = CR.save(newContract);
	         
	        return newContract;
	        
	    } else {
	        cont = CR.save(cont);
	        return cont;
	    }		
	}

	@Override
	public List<Contract> findByType(String typecontract) {
		return (List<Contract>)CR.findByType(typecontract);	
	}

	@Override
	public Contract retrieveContract(long id) {
		Optional<Contract> contract = CR.findById(id);
		if(contract.isPresent()) {
	        return contract.get();}
		return null;		 
	}

	@Override
	public void ContractPdf(long id) {
		/*try {
			Contract c = CR.getOne(id);
			
		String file_name="C:\\Users\\issam ben hassine\\Desktop\\Contract\\Contract"+c.getId()+".pdf";
		Document document=new Document(PageSize.A4,15,15,45,30);
		
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
	
	 document.open();
	 document.add(new Paragraph("  "));
	    document.add(new Paragraph("  "));
		 //Image img=Image.getInstance("C:\\Users\\Saoussen\\Desktop\\Contract\\logo.jpg");
		 //img.setAlignment(Element.ALIGN_LEFT);
		 //img.setIndentationLeft(5);
		 //img.setIndentationRight(5);
		 //img.setSpacingAfter(1);
		 //document.add(img); 
		 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
	 document.add(new Paragraph("                                                                                                                              rev: "+c.getReference()));
	 document.add(new Paragraph("                                                         SALES AGREEMENT                                                    "));
	 document.add(new Paragraph("  "));
	 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
	 document.add(new Paragraph(" "));
	 document.add(new Paragraph(" "));
	 ////////////////
	// document.add(new Paragraph(" "));
	 //document.add(new Paragraph(" "));
	 document.add(new Paragraph(" This Sales Agreement (this “Agreement”) is entered into as of the _____ day of _______________, 20_____, by and among/between:"));
	// document.add(new Paragraph("Seller(s):  "+c.getUser().getFirst_name()));
	 document.add(new Paragraph("Seller(s): ________________________________________________ [Name], located at _______________________________________________________ [Address] (collectively “Seller”) and  "));
	 document.add(new Paragraph(" Buyer(s): ________________________________________________ [Name], located at _______________________________________________________ [Address] (collectively “Buyer”). "));
	 document.add(new Paragraph("Each Seller and Buyer may be referred to in this Agreement individually as a “Party” and collectively as the “Parties.”  "));
	 document.add(new Paragraph("1. Sale of Goods. Seller agrees to sell, and Buyer agrees to purchase the following items  prices (the “Goods”): "));
	 /////////////////////
	document.add(new Paragraph(" "));
	document.add(new Paragraph(" "));
	 PdfPTable table = new PdfPTable(2);
	 PdfPTable table2 = new PdfPTable(6);
	  Font tableHeader = FontFactory.getFont("Arial", 10, BaseColor.BLACK);
	    Font tableBody = FontFactory.getFont("Arial", 9, BaseColor.BLACK);
	    PdfPCell Description = new PdfPCell(new Paragraph("Description of Goods", tableHeader));
	    Description.setBorderColor(BaseColor.BLACK);
	    Description.setPaddingLeft(10);
	    Description.setHorizontalAlignment(Element.ALIGN_CENTER);
	    Description.setVerticalAlignment(Element.ALIGN_CENTER);
	    Description.setBackgroundColor(BaseColor.LIGHT_GRAY);
	    Description.setExtraParagraphSpace(5f);
	    table.addCell(Description);
	    
	    
	    PdfPCell Prix = new PdfPCell(new Paragraph("Price", tableHeader));
	    Prix.setBorderColor(BaseColor.BLACK);
	    Prix.setPaddingLeft(10);
	    Prix.setHorizontalAlignment(Element.ALIGN_CENTER);
	    Prix.setVerticalAlignment(Element.ALIGN_CENTER);
	    Prix.setBackgroundColor(BaseColor.LIGHT_GRAY);
	    Prix.setExtraParagraphSpace(5f);
	    table.addCell(Prix);
	    
	    
	    
	    PdfPCell case1 = new PdfPCell(new Paragraph("                ", tableHeader));
	    //Totale.setBorderColor(BaseColor.BLACK);
	    case1.setPaddingLeft(10);
	    case1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    case1.setVerticalAlignment(Element.ALIGN_CENTER);
	    case1.setBackgroundColor(BaseColor.LIGHT_GRAY);
	    case1.setExtraParagraphSpace(5f);
	    table.addCell(case1);
	    
	    PdfPCell case2 = new PdfPCell(new Paragraph("                ", tableHeader));
	    //Totale.setBorderColor(BaseColor.BLACK);
	    case2.setPaddingLeft(10);
	    case2.setHorizontalAlignment(Element.ALIGN_CENTER);
	    case2.setVerticalAlignment(Element.ALIGN_CENTER);
	    case2.setBackgroundColor(BaseColor.LIGHT_GRAY);
	    case2.setExtraParagraphSpace(5f);
	    table.addCell(case2);
	    
	    PdfPCell case3 = new PdfPCell(new Paragraph("                ", tableHeader));
	    //Totale.setBorderColor(BaseColor.BLACK);
	    case3.setPaddingLeft(10);
	    case3.setHorizontalAlignment(Element.ALIGN_CENTER);
	    case3.setVerticalAlignment(Element.ALIGN_CENTER);
	    case3.setBackgroundColor(BaseColor.LIGHT_GRAY);
	    case3.setExtraParagraphSpace(5f);
	    table.addCell(case3);
	    
	    PdfPCell case4 = new PdfPCell(new Paragraph("                ", tableHeader));
	    //Totale.setBorderColor(BaseColor.BLACK);
	    case4.setPaddingLeft(10);
	    case4.setHorizontalAlignment(Element.ALIGN_CENTER);
	    case4.setVerticalAlignment(Element.ALIGN_CENTER);
	    case4.setBackgroundColor(BaseColor.LIGHT_GRAY);
	    case4.setExtraParagraphSpace(5f);
	    table.addCell(case4);
	    
	    PdfPCell case5 = new PdfPCell(new Paragraph("                ", tableHeader));
	    //Totale.setBorderColor(BaseColor.BLACK);
	    case5.setPaddingLeft(10);
	    case5.setHorizontalAlignment(Element.ALIGN_CENTER);
	    case5.setVerticalAlignment(Element.ALIGN_CENTER);
	    case5.setBackgroundColor(BaseColor.LIGHT_GRAY);
	    case5.setExtraParagraphSpace(5f);
	    table.addCell(case5);
	    
	    PdfPCell case6 = new PdfPCell(new Paragraph("                ", tableHeader));
	    //Totale.setBorderColor(BaseColor.BLACK);
	    case6.setPaddingLeft(10);
	    case6.setHorizontalAlignment(Element.ALIGN_CENTER);
	    case6.setVerticalAlignment(Element.ALIGN_CENTER);
	    case6.setBackgroundColor(BaseColor.LIGHT_GRAY);
	    case6.setExtraParagraphSpace(5f);
	    table.addCell(case6);
	    
	    
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
	    
	    


		 
	    document.add(table);
	    document.add(new Paragraph("  "));
	    
	    document.add(table2);
	    
	    //document.add(new Paragraph("IN WITNESS WHEREOF, the Parties have executed this agreement as of the date first written above. "));
		 document.add(new Paragraph("Other Details: ________________________________________________________________________"));
                                        
		 document.add(new Paragraph("2. Purchase Price. Buyer will pay to Seller for the Goods and for all obligations specified in this Agreement, if any, as the full and complete purchase price, the sum of $______________. Unless otherwise stated, (Check one) ☐ Seller ☐ Buyer shall be responsible for all taxes in connection with the purchase of Goods in this Agreement "));
	    
		 document.add(new Paragraph("IN WITNESS WHEREOF, the Parties have executed this agreement as of the date first written above. "));
		 document.add(new Paragraph(" "));
		 document.add(new Paragraph(" "));
		 document.add(new Paragraph("  _______________________________"+
		 "                                    Buyer Signature                    "));
		 document.add(new Paragraph(" "));
		 document.add(new Paragraph(" "));
		 
		 document.add(new Paragraph("  _______________________________"+
				 "                                     Seller Signature                    "));
			    
	    
	    
		 document.add(new Paragraph(" "));
		 document.add(new Paragraph("Date: "+c.getDateDebut()));
	    /////////////////////////////
	    /////////////////////////////
	    /////////////////////////////
	    ////////////////////////////

	 
	 document.close();
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
	//	} 
	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
		
	
}
