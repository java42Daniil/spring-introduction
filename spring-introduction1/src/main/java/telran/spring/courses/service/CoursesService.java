package telran.spring.courses.service;

import java.util.List;

import telran.spring.courses.dto.Course;

/* V.R.
 * This interface has extend Serializable.
 * save() and restore() will not work without it.
 */
public interface CoursesService {
	Course addCourse(Course course);
	
	List<Course> getAllCourses();

	Course getCourse(int id);

	Course removeCourse(int id);

	Course updateCourse(int id, Course course);
	void restore();
	void save();
	
}