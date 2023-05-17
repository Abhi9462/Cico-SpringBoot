package com.cico.Service;

import com.cico.Models.Attendance;

public interface IAttendanceService {

	Attendance checkIn(Attendance attendance);
	
	Attendance checkOut(Attendance attendance);
}
