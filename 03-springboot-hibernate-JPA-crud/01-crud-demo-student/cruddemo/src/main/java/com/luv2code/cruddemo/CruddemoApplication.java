package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);
			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {


		// retrieve student based on id: primary key

		int studentID = 1;
		System.out.println("Getting student with id:  " + studentID);
		Student myStudent = studentDAO.findbyID(studentID);

		// change first name to "John"

		System.out.println("Updating student....");
		myStudent.setFirstName("John");


		// update the student

		studentDAO.update(myStudent);

		// Display the updated student

		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students

		List<Student>  theStudents = studentDAO.findByLastName("Doe");

		// display list of students

		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students

		List<Student> theStudents = studentDAO.findAll();

		//display the lists of students

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
           System.out.println("Creating a new student object....");
		   Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");


		// save the student

		   System.out.println("Saving the student....");
		   studentDAO.save(tempStudent);

		// display id of saved student

		int theID = tempStudent.getId();
		System.out.println("Saved Student. Generate id: " + theID);

		// retrieve student based on the id: primary key

		System.out.println("Retrieving student with id " + theID);
		Student mystudent = studentDAO.findbyID(theID);

		// display student

		System.out.println("Found the student: " + mystudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		 //create multiple students

		System.out.println("Creating 3 student object ...");
		Student tempStudent1 = new Student( "John",  "Doe",  "john@luv2code.com");
		Student tempStudent2 = new Student( "Mary",  "Public",  "mary@luv2code.com");
		Student tempStudent3 = new Student( "Bonita",  "Applebum",  "bonita@luv2code.com");


		// save student objects

		System.out.println("Saving the students ....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);



	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object

		System.out.println("Creating new student object ...");
		Student tempStudent = new Student( "Paul",  "Doe",  "paul@luv2code.com");

		//save the student object

		System.out.println("Saving the student.....");
        studentDAO.save(tempStudent);

		//display id of the saved student

		System.out.println("Saved student.Generate id: " + tempStudent.getId());

	}
}





