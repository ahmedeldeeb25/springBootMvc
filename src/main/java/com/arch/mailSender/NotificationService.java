package com.arch.mailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arch.Entities.Users;

@Service
public class NotificationService {
	

	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		
		this.javaMailSender=javaMailSender;
		
		
	}
public void SendNotification(Users users) {
	
	// send Mail
	   SimpleMailMessage message = new SimpleMailMessage(); 
       message.setTo(users.getEmail()); 
       message.setFrom("ahmedmar3y108@gmail.com");
       message.setSubject("This is my Messsag"); 
       message.setText("Done send Message");
      
       javaMailSender.send(message);
       
	
}



/*
 * 
 * to use it ................
 * 
 *     @Autowired
    NotificationService NotificationService;
    @RequestMapping(value = "/mail")
    public void sendMail() {
    	
    	System.out.println("Done   .....................");
    	// create User
    	Users users=new Users();
    	users.setUsername("ahmed");
    	users.setPassword("3091996");
    	users.setEmail("ahmedmar3y108108@gmail.com");

  try
  {
	  
	    NotificationService.SendNotification(users); 
  }catch(Exception exception) {
	  
	  logger.info("Error ..... "+exception.getMessage());
	  
  }
    }
 * 
 * 
 * 
 * 
 * */
}
