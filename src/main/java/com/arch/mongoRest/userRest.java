package com.arch.mongoRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




import com.arch.mongoEntities.user;

@RestController
@RequestMapping("/mongo")
public class userRest {
	 @Autowired
	    com.arch.mongoEntities.userRepository userRepository;
	

	    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void insert(@RequestBody user user) {
	    	userRepository.insert(user);

	    }

	    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    public List<user> GetAll() {
	        return userRepository.findAll();

	    }

	    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    public user Getspecific(@PathVariable("id") String id) {


	        return userRepository.findById(id);
	    }

	    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void UpdateTopic(@RequestBody user user, @PathVariable("id") String id) {

	    userRepository.save(user);

	    }

	    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	    public void DeleteTopic(@PathVariable("id") String id) {

	    	userRepository.delete(id);

	    }


}
