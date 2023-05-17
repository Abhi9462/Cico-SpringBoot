package com.cico.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cico.Models.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance, Integer> {

}
