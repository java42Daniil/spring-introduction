package telran.spring.courses.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import telran.spring.courses.dto.Course;
import telran.spring.courses.exceptions.NotFoundException;

@Service
public class CoursesServiceImpl implements CoursesService {

	public Map<Integer, Course> courses = new HashMap<>();

	@Override
	public Course addCourse(Course course) {
		course.id = generateId(course.id);
		courses.put((int) course.id, course);
		return course;
	}
	

	@Override
	public List<Course> getCourses() {
		if(courses.size() == 0) {
			throw new NotFoundException(
					"The list of courses is empty");
		}
		return new ArrayList<>(courses.values());
	}

	@Override
	public Course getCourse(long id) {
		if(!courses.containsKey(id)) {
			throw new NotFoundException(String.format(
					"course id=%d isn't found", id));
		}
		return courses.get(id);
	}
	private long generateId(long existingId) {
		if (!courses.containsKey(existingId)) {
			return existingId;
		}
		while (true) {
			long id = new Random().nextLong(1, 999999);
			if (!courses.containsKey(id)) {
				return id;
			}
		}
	}

}