package telran.spring.courses.dto;

import java.time.LocalDate;

import javax.validation.constraints.*;

public class Course {

	@Min(value=1)
	@Max(value=99999)
	public long id;
	@NotNull
	@NotEmpty
	public String course;
	@NotNull
	@NotEmpty
    public String lecturer;
	@Min(value = 1000)
	@Max(value = 30000)
    public int cost;
	@Min(value = 50)
	@Max(value = 600)
    public int hours;
	@NotNull
    public LocalDate openingDate;
    
    public Course() {
    	
    }
    
	public Course(String course, String lecturer, int cost, int hours, LocalDate openingDate) {
		this.id = id;
		this.course = course;
		this.lecturer = lecturer;
		this.cost = cost;
		this.hours = hours;
		this.openingDate = openingDate;
	}
	public Course(Course course) {
		this.id = course.id;
		this.course = course.course;
		this.lecturer = course.lecturer;
		this.cost = course.cost;
		this.hours = course.hours;
		this.openingDate = course.openingDate;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}if (obj == null) {
			return false;
		}if (getClass() != obj.getClass()) {
			return false;
		}
		Course other = (Course) obj;
		if (id != other.id) {
			return false;
		}if(!course.equals(other.course) || !lecturer.equals(other.lecturer)) {
			return false;
		}
		    return true;
	}
}