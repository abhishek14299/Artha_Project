package Artha_Project;

import java.util.*;

public class Rating {

	public static void main(String[] args) {

	List<Weights>category =new ArrayList<Weights>();
	category=Weights.weightData();
	
	String[] assignName=Weights.assignmentName(category);


	List<Student> stu =new ArrayList<Student>();
	stu=Student.addStudent(assignName);

	
	String[] nameOfStudents=Student.names(stu);
	String[] subjectForStudents=Student.subjects(stu);
	
	List<Subject> calculationPart=Student.calc(stu, nameOfStudents, subjectForStudents,assignName,category);

	Iterator<Subject> iter =calculationPart.iterator();
	while(iter.hasNext()) {
		Subject ret=iter.next();
		System.out.println(ret.toString(ret.getFlag()));
	}
	}
}
	
	

