package com.cico.RequestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class JwtRequestDto {
	
	    @NotNull(message = "Please enter a valid user Id")
	private String userId;
	
	 @NotBlank(message = "Please enter proper password")
	    @Size(min=5, message = "password should be atleast 5 characters")
	    @Size(max=20, message = "password should not be greater than 20 characters")
	private String password;
	
	private String oldPassword;

}
