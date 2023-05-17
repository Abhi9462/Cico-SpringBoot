package com.cico.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cico.Models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	Optional<Student> findByUserIdAndIsActive(String username, boolean b);

}
