package com.arch.Restful;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.arch.Entities.Course;
import com.arch.Entities.Topics;
import com.arch.Entities.Users;
import com.arch.Service.CourseServiceImpl;
import com.arch.mailSender.NotificationService;
import com.arch.mongoEntities.user;

import java.util.List;

/**
 * Created by ahmed on 7/22/2017.
 */
@RestController
@RequestMapping("/rest")
public class CourseRest {
	Logger logger=org.slf4j.LoggerFactory.getLogger(CourseRest.class);
	
    @Autowired
    CourseServiceImpl courseService;


    
    
    
    
    @RequestMapping(value = "/topics/{topicId}/Course", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNew(@RequestBody Course Course, @PathVariable("topicId") String topicId) {
        Course.setTopics(new Topics(topicId, "", ""));
        courseService.insert(Course);
    }

    @RequestMapping(value = "/topics/{topicId}/Course/{courseId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void UpdateCourse(@RequestBody Course Course, @PathVariable("topicId") String topicId, @PathVariable("courseId") String courseId) {
        Course.setTopics(new Topics(topicId, "", ""));
        courseService.update(Course);
    }


    @RequestMapping(value = "/topics/{id}/Course", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> GetAllByTopicId(@PathVariable("id") String id) {
        return courseService.getAll(id);
    }

    @RequestMapping(value = "/topics/{topicId}/Course/{CourseId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Course Getspecific(@PathVariable("CourseId") String CourseId) {

        return courseService.getSpecific(CourseId);

    }

    @RequestMapping(value = "/topics/{topicId}/Course/{CourseId}", method = RequestMethod.DELETE)
    public void Delete(@PathVariable("CourseId") String CourseId) {
        courseService.Delete(CourseId);
    }

}
