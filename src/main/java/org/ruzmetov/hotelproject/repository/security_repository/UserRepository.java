package org.ruzmetov.hotelproject.repository.security_repository;

import org.ruzmetov.hotelproject.entity.security_entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

User findByUsername (String userName);

}
