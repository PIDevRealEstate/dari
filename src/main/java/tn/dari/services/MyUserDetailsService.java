package tn.dari.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.dari.entities.User;
import tn.dari.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    UserRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if(user==null)
        {
            System.out.println("user "+user+" not fouuuuuuuund");
            throw new UsernameNotFoundException("user not found");
        }
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

}