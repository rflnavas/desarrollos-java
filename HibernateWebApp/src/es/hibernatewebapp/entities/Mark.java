package es.hibernatewebapp.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "mark", schema="my_highschool")

@NamedQueries({
	//Funciona
//	@NamedQuery(name="findStudentMarks", query="from Student s "
//				+ "where s.id = :id_student")
	//FUNCIONA!!
	//@NamedQuery(name="findStudentMarks", query="from Mark m where m.student.id=:id_student")
})
public class Mark {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_mark", nullable=false, unique=true)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_student")
	private Student student;
	
	@OneToOne
	@JoinColumn(name = "id_exam")
	@Cascade({CascadeType.SAVE_UPDATE})
	private Exam exam;
	
	@Column(name = "score")
	private Double score;

	public Mark() {
	}

	public Mark(Student student, Exam exam, Double score) {
		super();
		this.student = student;
		this.exam = exam;
		this.score = score;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exam == null) ? 0 : exam.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		Mark other = (Mark) obj;
		if (exam == null) {
			if (other.exam != null)
				return false;
		} else if (!exam.equals(other.exam))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "score:" + score;
	}

}
