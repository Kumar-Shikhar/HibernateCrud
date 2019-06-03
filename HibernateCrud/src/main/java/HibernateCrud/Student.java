package HibernateCrud;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//MODEL CLASS
@Entity
@Table(name="student")
public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	  @Id
	    @Column(name="student_id")// this is primary key for the table
	    @GeneratedValue(strategy=GenerationType.AUTO)//id will be auto generated
	    private int id;
	 
	    @Column(name="student_name")//this is the same name in db table
	    private String studentName;//this name act as alias for java app
	 
	    @Column(name="roll_number")
	    private int rollNumber;
	 
	    @Column(name="course")
	    private String course;
	 
	    public int getId() {
	        return id;
	    }
	 
	    public void setId(int id) {
	        this.id = id;
	    }
	 
	    public String getStudentName() {
	        return studentName;
	    }
	 
	    public void setStudentName(String studentName) {
	        this.studentName = studentName;
	    }
	 
	    public int getRollNumber() {
	        return rollNumber;
	    }
	 
	    public void setRollNumber(int rollNumber) {
	        this.rollNumber = rollNumber;
	    }
	 
	    public String getCourse() {
	        return course;
	    }
	 
	    public void setCourse(String course) {
	        this.course = course;
	    }
	 
	    @Override
	    public String toString() {
	        return "Student Details?= Id: " + this.id + ", Name: " + this.studentName + ", Roll No.: " + this.rollNumber + ", Course: " + this.course;
	    }


}
