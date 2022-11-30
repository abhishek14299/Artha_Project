package Artha_Project;

import java.util.*;
import java.util.stream.*;

public class Student{
	int seNo=0;
	String name,subject,assignmentCategory,dateOfSubmission;
	int point=0;
	
	

	/**
	 * 
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param seNo
	 * @param name
	 * @param subject
	 * @param assignmentCategory
	 * @param dateOfSubmission
	 * @param point
	 */
	public Student(int seNo, String name, String subject, String assignmentCategory, String dateOfSubmission,
			int point) {
		super();
		this.seNo = seNo;
		this.name = name;
		this.subject = subject;
		this.assignmentCategory = assignmentCategory;
		this.dateOfSubmission = dateOfSubmission;
		this.point = point;
	}




	/**
	 * @return the seNo
	 */
	public int getSeNo() {
		return seNo;
	}



	/**
	 * @param seNo the seNo to set
	 */
	public void setSeNo(int seNo) {
		this.seNo = seNo;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}



	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}



	/**
	 * @return the assignmentCategory
	 */
	public String getAssignmentCategory() {
		return assignmentCategory;
	}



	/**
	 * @param assignmentCategory the assignmentCategory to set
	 */
	public void setAssignmentCategory(String assignmentCategory) {
		this.assignmentCategory = assignmentCategory;
	}



	/**
	 * @return the dateOfSubmission
	 */
	public String getDateOfSubmission() {
		return dateOfSubmission;
	}



	/**
	 * @param dateOfSubmission the dateOfSubmission to set
	 */
	public void setDateOfSubmission(String dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}



	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}



	/**
	 * @param point the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
	}



	@Override
	public String toString() {
		return "Student [seNo=" + seNo + ", name=" + name + ", subject=" + subject + ", assignmentCategory="
				+ assignmentCategory + ", dateOfSubmission=" + dateOfSubmission + ", point=" + point + "]";
	}



	public static List<Student> addStudent(String[] assignName) {
		String name,subject,assignmentCategory,dateOfSubmission;
		int point=0,n=0,flag=0,seNo=0;
		Scanner sc=new Scanner(System.in);
		List<Student> database= new ArrayList<Student>();
		do{
			System.out.println("choose operation for Student:"+"\n"+"0: Exit"+"\n"+"1: add data"+"\n"+"2: update data"+"\n"+"3: delete data"+"\n"+"4: display data");
			n=sc.nextInt();
			switch(n) {
			case 1:   //add data to database
				seNo= sc.nextInt();
				name=sc.next();
				subject=sc.next();
				assignmentCategory=sc.next();
				dateOfSubmission=sc.next();
				point=sc.nextInt();
				database.add(new Student(seNo,name,subject,assignmentCategory,dateOfSubmission,point));
			break;
			
			case 2:    //update data in database
				if(database.isEmpty()) {
					System.out.println("database is empty please add data");
				}
				else {
				System.out.println("Enter Serial No. to update data ");
				seNo =sc.nextInt();
				
				Iterator <Student> its=  database.iterator();
				while(its.hasNext()) {
					Student w=its.next();
					if(w.getSeNo()==seNo) {
						System.out.println("Enter new data");
						name=sc.next();
						w.setName(name);
						subject=sc.next();
						w.setSubject(subject);
						assignmentCategory=sc.next();
						w.setAssignmentCategory(assignmentCategory);
						dateOfSubmission=sc.next();
						w.setDateOfSubmission(dateOfSubmission);
						point=sc.nextInt();
						w.setPoint(point);
						}
					}
				}
				break;
				
			case 3:       // delete data in database 
				int indexfind=-1;
				if(database.isEmpty()) {
					System.out.println("database is empty can't delete data");
				}
				else {
					synchronized (database) {
				System.out.println("Enter Serial No. to delete data ");
				seNo =sc.nextInt();
				
				Iterator <Student> its=  database.iterator();
				while(its.hasNext()) {
					Student w=its.next();
					indexfind+=1;
					if(w.getSeNo()==seNo) {
						System.out.println("Selected data to be deleted at index"+" .."+indexfind);
						database.remove(indexfind);
						flag=1;
							break;
							}
					}
				if(flag!=0) {
					System.out.println("data deleted successfully at"+" .. "+seNo);
					flag=0;
				}
				else {
					System.out.println("Serial No. not found, Can't delete data at"+" .. "+seNo);
				}

			
				}
				}
				break;
				
			case 4:   // print all data in database 
				System.out.println(database.toString());
			break;
			}}while(n!=0);

		Iterator<Student> i=database.iterator();
		while(i.hasNext()) {
			Student s=i.next();
			for(String sub:assignName) {
				if(s.getAssignmentCategory().startsWith(sub)) {
					s.setAssignmentCategory(sub);
				}
					
			}
		}
		System.out.println(database);
	return database;
	}
	
	public static String[] names(List<Student> database) {      //return list of name 
		Set<String> hold= new HashSet<String>();
		int indexfind=0;
		Iterator <Student> its=  database.iterator();
		while(its.hasNext()) {
			Student w=its.next();
			hold.add(w.getName());
			}
		String[] namesOfStudent= new String[hold.size()];
		for(String s:hold) {
			namesOfStudent[indexfind]=s;
			indexfind+=1;	
		}
		return namesOfStudent;
		}
 	
	public static String[] subjects(List<Student> database) {
		Set<String> hold= new HashSet<String>();
		int indexfind=0;
		Iterator <Student> its=  database.iterator();
		while(its.hasNext()) {
			Student w=its.next();
			hold.add(w.getSubject());
			}	
		String[] subjectForStudent= new String[database.size()];
		for(String s:hold) {
			subjectForStudent[indexfind]=s;
			indexfind+=1;	
		}
		return subjectForStudent;
		}
	
	public static Set<String> subjectsAsPerStudent(List<Student> result) {
		Set<String> subjectForStudent= new HashSet<String>();
		Iterator <Student> its=  result.iterator();
		while(its.hasNext()) {
			Student w=its.next();
			subjectForStudent.add(w.getSubject());
		}
		return subjectForStudent;
		}
	
	public static Set<String> studentName(List<Student> result) {
		Set<String> names= new HashSet<String>();
		Iterator <Student> its=  result.iterator();
		while(its.hasNext()) {
			Student w=its.next();
			names.add(w.getName());
		}
		return names;
		}
	
	
	public static List<Subject> calc(List<Student> database, String[] nameset, String[] subset,String[] assignName,List<Weights>category) {
		Scanner sc=new Scanner(System.in);
		int flag =0;
		System.out.println("calculation part in process");
		String n=sc.next();
		for(int i=0;i<nameset.length;i++) {
		if(nameset[i].equals(n)) {
		List<Student> result=  database.stream().filter(s->s.getName().equals(n)).collect(Collectors.toList());
		Set<String> subjectForStudent= new HashSet<String>();
		flag=1;
		subjectForStudent=subjectsAsPerStudent(result);
		List<Subject> finalResult=endResult(result,subjectForStudent,assignName,category,flag);
		return finalResult;
		}
		}
		for(int i=0;i<subset.length;i++) {
		if(subset[i].equals(n)) {
			List<Student> result=  database.stream().filter(s->s.getSubject().equals(n)).collect(Collectors.toList());
			Set<String> nameOfStudent= new HashSet<String>();
			nameOfStudent=studentName(result);
			List<Subject> finalResult=endResult(result,nameOfStudent,assignName,category,flag);
			return finalResult;
			}
		}
		
		return null;
		}
	
	public static List<Subject> endResult(List<Student> result,Set<String> categoryToSelect,String[] assignName,List<Weights>category,int flag)
	{	List<Subject> re=new ArrayList<Subject>();
		Map<String,Double>assignmentScore=new HashMap<String,Double>();
		List<Student> sub=null;
		Iterator <String> its=  categoryToSelect.iterator();
		while(its.hasNext()) {
			String iterCategory=its.next();
			assignmentScore=newCalc(result, sub, assignName,iterCategory,category,flag);
			if(flag==1) {
				re.add(new Subject(iterCategory,assignmentScore,1));
			}
			else {
				re.add(new Subject(iterCategory,assignmentScore,0));

			}
//			
			}
		
		return re;
		
	}
	
	public static Map<String, Double> newCalc(List<Student> result, List<Student> sub,String[] assignName, String iterCategory,List<Weights>category,int flag) {
		int count =0;
		Double finalscore=0.0;
		Double score=0.0;
		Map<String,Double>assignmentScore=new LinkedHashMap<String,Double>();
		Map<String,Integer>assignmentCount=new HashMap<String,Integer>();
		for(String i:assignName) {
			assignmentScore.put(i,0.0);
			assignmentCount.put(i,0);
		}
		if(flag==1) {
		sub=  result.stream().filter(s->s.getSubject().equals(iterCategory)).collect(Collectors.toList());
		}
		else {
			sub=  result.stream().filter(s->s.getName().equals(iterCategory)).collect(Collectors.toList());
		}
		Iterator<Student> niter= sub.iterator(); 
		while(niter.hasNext()) {
			Student s= niter.next();
			score=assignmentScore.get(s.getAssignmentCategory());
			score+=s.getPoint();
			count=assignmentCount.get(s.getAssignmentCategory());
			count++;
			assignmentScore.remove(s.getAssignmentCategory());
			assignmentScore.put(s.getAssignmentCategory(), score);
			assignmentCount.remove(s.getAssignmentCategory());
			assignmentCount.put(s.getAssignmentCategory(), count);
			
		}
for(String i:assignName) {
	double newpoint=assignmentScore.get(i);
	double newcount=assignmentCount.get(i);
	double weightpoint=0;
	
	Iterator <Weights> iw=  category.iterator();
	while(iw.hasNext()) {
		Weights w=iw.next();
		if(w.getAssignment().equals(i)) {
		weightpoint=w.getWeight();
	}
		}
	if(newcount==0) {
	  finalscore=0.0;
	}
	else {
	 finalscore=((weightpoint/newcount)*newpoint)/100;
	}
	
	assignmentScore.put(i, finalscore);
}
Double sum = assignmentScore.values().stream().mapToDouble(d -> d).sum();
assignmentScore.put("OverallRating", sum);
		return assignmentScore;
		
	}
		
}
