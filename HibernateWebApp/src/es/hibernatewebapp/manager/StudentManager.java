package es.hibernatewebapp.manager;

import java.util.Date;
import java.util.List;
import java.util.Set;

import es.hibernatewebapp.entities.Mark;
import es.hibernatewebapp.entities.Student;
import es.hibernatewebapp.util.ParameterFilter;

public interface StudentManager {
	
	void addStudent(Student s);
	void addStudent(String name, String surname, Date birthdate);
	Student findStudentById(Long id);
	List<Student> findStudentsBy(List<ParameterFilter> params);
	void updateStudent(Student s);
	Set<Mark> getStudentMarks(Long id);
}
