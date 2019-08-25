package com.hackwinrepeat.project.email;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackwinrepeat.project.email.EmailService;

@RestController
@RequestMapping("sendEmail") //http://localhost:8081/sendEmail
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@PostMapping
	public String sendEmail(@RequestBody PatientDetails PatientDetails) {
		try{
			System.out.println("micro service is running....");
			emailService.sendEmail(PatientDetails.getName(), PatientDetails.getEmail());
			return "Email Send Successfully";
		}catch(Exception e){
			e.printStackTrace();
			return "Email Send fails";
		}
	}
	
	
}
