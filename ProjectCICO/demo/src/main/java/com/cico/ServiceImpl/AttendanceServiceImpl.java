package com.cico.ServiceImpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cico.Models.Attendance;
import com.cico.Repo.AttendanceRepo;
import com.cico.Service.IAttendanceService;



@Service
public class AttendanceServiceImpl implements IAttendanceService {
	
	@Autowired
	AttendanceRepo repo;

	@Override
	public Attendance checkIn(Attendance attendance) {	
		attendance.setCreatedDate(LocalDate.now());
		attendance.setUpdatedDate(LocalDate.now());
		return repo.save(attendance);		
	}
	
	@Override
	public Attendance checkOut(Attendance attendance) {	
		attendance.setUpdatedDate(LocalDate.now());
		return repo.save(attendance);		
	}

}
