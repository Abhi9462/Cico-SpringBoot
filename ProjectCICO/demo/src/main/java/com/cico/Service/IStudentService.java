package com.cico.Service;

import org.springframework.security.core.userdetails.UserDetails;

import com.cico.Models.Attendance;
import com.cico.Models.Student;

public interface IStudentService {

	public UserDetails loadUserByUsername(String username);

	public Student getCurrentStudent(String username);

}
