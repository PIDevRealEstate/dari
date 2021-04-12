package tn.dari.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.dari.entities.User;
import tn.dari.repository.UserRepository;
import tn.dari.security.PasswordEncoder;
import tn.dari.token.ConfirmationToken;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService{
	private static String User_NOT_FOUND = "user with email %s not found" ; 
	private final UserRepository userRepository ;
	private final PasswordEncoder passwordEncoder ; 
	private final ConfirmationTokenService confirmationTokenService ; 
     
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email)
				.orElseThrow(()-> new UsernameNotFoundException(String.format(User_NOT_FOUND, email)));
	}

	 public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
			ConfirmationTokenService confirmationTokenService) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.confirmationTokenService = confirmationTokenService;
	}



	public String SignUpUser(User user) {
	        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();

	        if (userExists) {

	          throw new IllegalStateException("email already taken !");
	            
	            }
	            

	        String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(user.getPassword());
	        user.setPassword(encodedPassword);
            
	        //Saving the user after encoding the password
	        userRepository.save(user);

	        //Creating a token from UUID
	        String token = UUID.randomUUID().toString();
	        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
	                LocalDateTime.now().plusMinutes(15), user);
	        //Getting the confirmation token and then saving it
	       confirmationTokenService.saveConfirmationToken(confirmationToken);


	        //Returning token
	        return token;
	    }
	 public int enableUser(String email) {
	        return userRepository.enableUser(email);
	    }
   
    public void UpdateResetPassword(String token , String email) throws UserNotFoundException {
    	User user = userRepository.findByEmail2(email);
    	if (user != null){
    		user.setResetPasswordToken(token);
    		userRepository.save(user);
    		
    	} else {
    		throw new UserNotFoundException("could not found any email with email : "+ email );
    	}	
    }
    public User get(String resetPasswordToken){
		return userRepository.findByResetPasswordToken(resetPasswordToken);
	}
    public void updatePassword(User user , String newPassword){
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String encodedPassword = passwordEncoder.encode(newPassword);
    	user.setPassword(encodedPassword);
    	user.setResetPasswordToken(null);
    	userRepository.save(user);
    	
    }
	
    

	  
	
    
}
