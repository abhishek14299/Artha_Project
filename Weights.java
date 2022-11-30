package Artha_Project;

import java.util.*;

public class Weights {
String assignment;
int weight;


public Weights(String assignment, int weight) {
	super();
	this.assignment = assignment;
	this.weight = weight;
}

@Override
public String toString() {
	return "Weights [assignment=" + assignment + ", weight=" + weight + "]";
}

public String getAssignment() {
	return assignment;
}
public void setAssignment(String assignment) {
	this.assignment = assignment;
}
public int getWeight() {
	return weight;
}
public void setWeight(int weight) {
	this.weight = weight;
}

public static List<Weights> weightData(){
	String assignment;
	int weight = 0 ;
	int n=0;
	int count=0;
	int fun=1;
	int flag=0;
	List<Weights> category= new ArrayList<Weights>();
	Scanner sc =new Scanner(System.in);

do{
	System.out.println("choose operation:"+"\n"+"0: Exit"+"\n"+"1: add data"+"\n"+"2: update data"+"\n"+"3: delete data"+"\n"+"4: display data");
	n=sc.nextInt();
	switch(n) {
	case 0:
		if(count!=100) {
			if(count<100) {
			System.out.println("weight total is less than 100, need to update assignment category weights");
			}
			else if(count>100) {
				System.out.println("weight total is more than 100, need to update assignment category weights");
			}
			n=3;
		}
		else fun=0;
		break;
	case 1:
	assignment=sc.next();
	weight=sc.nextInt();
	if(category.isEmpty()) {
	category.add(new Weights(assignment,weight));
	count+=weight;
	
	}
	else {
		Iterator <Weights> its=  category.iterator();
		while(its.hasNext()) {
			 flag=0;
			Weights w=its.next();
			if(w.getAssignment().equals(assignment)) {
				flag=1;
		System.out.println(assignment+" is in the Assignment Category"+"\n"+"want to update the weight press Y/y");
		char ans=sc.next().charAt(0);
		if(ans=='Y' || ans=='y') {	
			count-=w.getWeight();
			w.setWeight(weight);
			count+=weight;
			break;
		}
		break;
		}
			}
		if(flag==0) {
			category.add(new Weights(assignment,weight));
			count=count+weight;
			break; 
		}
		}
	
		
		
	break;
	case 2:
		boolean found=false;
		System.out.println("select the assignment category to update");
		assignment=sc.next();
		Iterator <Weights> i=  category.iterator();
		while(i.hasNext()) {
			Weights w=i.next();
			if(w.getAssignment().equals(assignment)) {
				System.out.println("enter new weight");
				count-=w.getWeight();
				weight=sc.nextInt();
				w.setWeight(weight);
				count+=weight;			
				found =true;
			}
		}
		if(found) {
			System.out.println("successfully updated");
		}
		else System.out.println("Assignment not Found");
		break;
		
	case 3:
		found=false;
		System.out.println("select the assignment category to delete");
		assignment=sc.next();
		Iterator <Weights> it=  category.iterator();
		while(it.hasNext()) {
			Weights w=it.next();
			if(w.getAssignment().equals(assignment)) {
				count-=w.getWeight();
				it.remove();
				found =true;
			}
		}
		if(found) {
			System.out.println("successfully updated");
		}
		else System.out.println("Assignment not Found");
		break;
		
	case 4:
			System.out.println(category.toString());
			System.out.println(count);
		break;
	
	}
	}while(n!=0 && fun!=0);

return (List<Weights>) category;

}

public static String[] assignmentName(List<Weights> category) {
String[] assignmentName= new String[category.size()];
int elecount=0;
Iterator <Weights> i=  category.iterator();
while(i.hasNext()) {
	Weights w=i.next();
	assignmentName[elecount]=w.getAssignment();
	elecount+=1;
}
return assignmentName;

}


}
