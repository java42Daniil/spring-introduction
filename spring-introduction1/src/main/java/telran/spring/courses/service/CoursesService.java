package telran.spring.courses.service;

import java.util.List;

import telran.spring.courses.dto.Course;

public interface CoursesService {
	Course addCourse(Course course);
	
	List<Course> getAllCourses();

	Course getCourse(int id);

	Course removeCourse(int id);

	Course updateCourse(int id, Course course);
	void restore();
	void save();
	
}