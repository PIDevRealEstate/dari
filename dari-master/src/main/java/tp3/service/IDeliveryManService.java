package tp3.service;

import java.util.List;

import tn.dari.entities.DeliveryMan;
import tn.dari.entities.LesGouvernorat;
 

public interface IDeliveryManService {

	
	public void AffecterOrdertoDeliveryMan (int IdOrder, LesGouvernorat g) ;
	public void BestDeliveryMan () ;
	public List<DeliveryMan> findAllDeliveryMan();	////
	
	public List<DeliveryMan> findAllDeliveryManByGouvernorat(LesGouvernorat gouvernorat);	////

	
}
