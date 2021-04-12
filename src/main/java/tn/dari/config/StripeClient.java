package tn.dari.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stripe.Stripe;
import com.stripe.model.Charge;

@Component
public class StripeClient {
	 @Autowired
	    StripeClient() {
	        Stripe.apiKey = "sk_test_51IfRNXKVjta6xRUWgoik6CZgrXzdDt8J4Nsw9bT1Yi4HWTBwcFrDV0nx1qhWT2pKoV4slsTg1ULD4fnz5iqjoZ8W00dM063EKw";
	    }

	    public Charge chargeCreditCard(String token, double amount) throws Exception {
	        Map<String, Object> chargeParams = new HashMap<String, Object>();
	        chargeParams.put("amount", (int)(amount * 100));
	        chargeParams.put("currency", "USD");
	        chargeParams.put("source", token);
	        Charge charge = Charge.create(chargeParams);
	        return charge;
	    }
	

}
