package tn.dari.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.dari.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email ) ; 
	 @Transactional
	    @Modifying
	    @Query("UPDATE User a " +
	            "SET a.enabled = TRUE WHERE a.email = ?1")
	    int enableUser(String email);
	 @Query("SELECT u FROM User  u WHERE u.email = ?1")
	 public User findByEmail2(String email);
	 
	 public User findByResetPasswordToken(String token );
	 
	

}
