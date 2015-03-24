package es.hibernatewebapp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="exam", schema="my_highschool")
public class Exam {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_exam", nullable=false, unique=true)
	private Long idExam;
	@ManyToOne
	@JoinColumn(name = "id_course")
	@Cascade({CascadeType.SAVE_UPDATE})
	private Course course;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="date")
	private Date date;
	
	public Exam() {
	}
	
	public Exam(Course course, String name, String description, Date date) {
		super();
		this.course = course;
		this.name = name;
		this.description = description;
		this.date = date;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Long getIdExam() {
		return idExam;
	}
	public void setIdExam(Long idExam) {
		this.idExam = idExam;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((idExam == null) ? 0 : idExam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exam other = (Exam) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (idExam == null) {
			if (other.idExam != null)
				return false;
		} else if (!idExam.equals(other.idExam))
			return false;
		return true;
	}

}
