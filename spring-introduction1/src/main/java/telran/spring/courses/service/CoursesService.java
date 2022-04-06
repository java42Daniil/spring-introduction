package telran.spring.courses.service;

import java.util.List;

import telran.spring.courses.dto.Course;

public interface CoursesService {
	Course addCourse(Course course);
	List<Course> getCourses();
	Course getCourse(long id);
}