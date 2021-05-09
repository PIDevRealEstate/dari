package tn.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>,JpaRepository<User, Integer> {
    public User findByUsername(String username);
}
