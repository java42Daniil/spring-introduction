package telran.spring.courses.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.spring.courses.dto.Course;
import telran.spring.courses.service.CoursesService;
import telran.spring.courses.service.CoursesServiceImpl;

@RestController
@RequestMapping("/courses")
@Validated
public class CoursesController {
	
	static Logger LOG = LoggerFactory.getLogger(CoursesController.class);
	
	CoursesService service = new CoursesServiceImpl();
	
	@PostMapping("/add/course")
	Course addCourse(@RequestBody @Valid Course course) {
		LOG.debug("added course: {}", course.toString());
		return service.addCourse(course);
	}
	
	@GetMapping("/get/courses")
	List<Course> getAllCourses() {
		LOG.debug("sent courses information");
		return service.getCourses();
	}

}