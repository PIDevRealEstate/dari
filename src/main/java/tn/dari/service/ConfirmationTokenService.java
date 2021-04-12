package tn.dari.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.dari.repository.ConfirmationTokenRepository;
import tn.dari.token.ConfirmationToken;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

	
	private final ConfirmationTokenRepository confirmationTokenrepository ;
	
	
	
	public ConfirmationTokenService(ConfirmationTokenRepository confirmationTokenrepository) {
		super();
		this.confirmationTokenrepository = confirmationTokenrepository;
	}


	public void saveConfirmationToken(ConfirmationToken token ){
		confirmationTokenrepository.save(token) ;
		
	}
	 public Optional<ConfirmationToken> getToken(String token) {
	        return confirmationTokenrepository.findByToken(token);
	    }

	    public int setConfirmedAt(String token) {
	        return confirmationTokenrepository.updateConfirmedAt(
	                token, LocalDateTime.now());
	    }
	
	
	
	
}
