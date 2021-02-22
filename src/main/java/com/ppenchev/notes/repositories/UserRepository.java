package com.ppenchev.notes.repositories;

import com.ppenchev.notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
