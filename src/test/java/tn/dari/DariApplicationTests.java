package tn.dari;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.dari.entities.Claim;
import tn.dari.entities.ClaimType;
import tn.dari.services.ClaimServices;
import tn.dari.services.ClaimServicesImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DariApplicationTests {
	
	 private static final Logger L = LogManager.getLogger(DariApplicationTests.class);

	
	@Autowired
	ClaimServices claimserv; 


	@Test
	public void contextLoads() {
		Claim c = new Claim(1, "object", "description", ClaimType.HARASSMENT ); 
		claimserv.addClaim(c);
	}

}
