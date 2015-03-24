package es.hibernatewebapp.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@Table(name="student", schema="my_highschool")
@NamedNativeQueries({
	//DOES NOT WORK
//	@NamedNativeQuery(
//			name="findStudentMarks", 
//			query="select m.score from my_highschool.Mark m inner join my_highschool.Student s on s.id_student=m.id_student and s.id_student=:id_student",
//			resultClass=Mark.class
//			)
})
/*select * from my_highschool.mark m inner join my_highschool.student s
on s.id_student=m.id_student*/
public class Student {
	
	@Id
	@Column(name="id_student", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="birthdate")
	private Date birthDate;
	//By default, the fetch type will be lazy due to performance issues.
	//JoinColumn will allow us to perform a query with JOIN between Student and Mark entities
	@OneToMany(mappedBy="student", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	//@JoinColumn(name="id_mark")
	//--> Associations marked as mappedBy must not define database mappings like @JoinTable or @JoinColumn: es.hibernatewebapp.entities.Student.marks
	public Set<Mark> marks = new HashSet<>(0);
	
	public Student() {
	}
	
	public Student(String name, String surname, Date birthdate){
		this.name=name;
		this.surname = surname;
		this.birthDate = birthdate;
	}
	
	public Student(String name, String surname, Date birthdate, Set<Mark> marks){
		this(name, surname, birthdate);
		this.marks = marks;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Set<Mark> getMarks() {
		return marks;
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Student? ((Student)obj).id == this.id : false;
	}
	
	@Override
	public String toString() {
		return "id:" + id + " name: " + name + "," + surname + " birthDate:" + birthDate;
	}
	
}
