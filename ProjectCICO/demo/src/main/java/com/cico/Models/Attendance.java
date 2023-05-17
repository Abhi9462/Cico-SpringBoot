package com.cico.Models;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer attendanceId;
	
	Integer studentId;
	
	LocalDate checkInDate; 
    Time checkInTime ;
    LocalDate checkOutDate ;
    Time checkOutTime; 
	String checkOutStatus="Approved";
	Long workingHour;
	LocalDate createdDate ;
	LocalDate updatedDate;

}
