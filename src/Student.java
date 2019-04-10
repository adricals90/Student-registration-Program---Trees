
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class Student implements Comparable<Student> {

	private String name;
	private String lastName;
	private String id;
	
	private int maxSize=5;
	private Course [] listCourses= new Course[maxSize];
	private int countCourse=0;
	
	private double credits;
	private double gpa;
	int count=0;
	
	Student (){
		name="";
		lastName="";
	    id="";
		credits=0;
		gpa=0;	
	}
	
	public void setName(String nam){	name= nam;}
	public void setLastName(String lastN){ lastName= lastN;}
	public void setId(String ids){id=ids;}
	public void setCredits(double c){credits=c;}	
	
	public void setArrayCourses(Course cour){ // best case O(1) if duplicated  worst case O(n)
											  // 
			if(countCourse==maxSize){
				Course newCourseData[]= new Course [2*maxSize];
				for(int i=0;i<=listCourses.length;i++ ){
					newCourseData[i]= listCourses[i];
				}
				maxSize*=2; 
				listCourses=newCourseData;
			}
			listCourses[countCourse++]=cour;
	}
	
	public String getName(){	return name;}
	public String getLastName(){ return lastName;}
	public String getId(){return id;}
	public Course[] getArrayCourses(){return listCourses;}
	public double getCredits(){return credits;}
	public double getGpa(){return gpa;}
		

	
	public int compareTo(Student o) {
		return this.getLastName().compareTo(o.getLastName());

	}
	
	public void deleteCourse(Course []m){   //O(1)
		
		m[--countCourse]=null;
	}
	

    public String toString(){
    	
   String m=Arrays.asList(listCourses).toString().replace("[","").replace("]", "").replace(",", "").replace("null","");
   
		return String.format(name+","+lastName+","+ id+"\n"+m+"-999"+"\n"+ credits+","+ gpa);
	 

	}
    
    
    
    public void readData(File file, Tree studList  ){ 
    	
		int counter=0;	
			try {
				Scanner inputStream= new Scanner(file);
				while(inputStream.hasNextLine())
				{ 
					boolean check=false;
					Student stud=  new Student();
					
					String data= inputStream.next();
					String[] line= data.split(",");
					
					do{ // Student Information
					stud.setName(line[0]);
					stud.setLastName(line[1]);   
					stud.setId(line[2]);
					counter++;
					}while (counter<1);

					while (check==false){// courses taken stored in an array
						Course cour= new Course();
						String ae= inputStream.next();
						if(!ae.equals("-999")){
							String[] line1= ae.split(",");
							cour.setCourseNum(line1[0]);
							cour.setNumOfCredits(Double.parseDouble(line1[1]));
							cour.setGradesRe(line1[2]);
							stud.setArrayCourses(cour);
						}else{
							check=true;	
						}
						
					}
					
					       String cre= inputStream.next();  // number of credits
					       String[] line2= cre.split(",");
						   stud.setCredits(Double.parseDouble(line2[0]));
						   					   
				        studList.insertTree(stud);
			 }
				inputStream.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    }//end of reading class
    
    public void gpa(){  // calculates the GPA and the number of credits.
    	double gradePoints=0;     // Runtime O(n) + outside loop on the main = O(n^2)
    	double nCredits=0;
    	
    	
    	    	for(int j=0;j<countCourse;j++ ){
    		if (listCourses[j].getGradeRe().equals("A"))
    		{
    			gradePoints+=listCourses[j].getNumOfCredits()*4.0;	
    		}else if(listCourses[j].getGradeRe().equals("A-")){
    			gradePoints+=listCourses[j].getNumOfCredits()*3.7;
    		}else if(listCourses[j].getGradeRe().equals("B+")){
    			gradePoints+=listCourses[j].getNumOfCredits()*3.33;
    		}else if(listCourses[j].getGradeRe().equals("B")){
    			gradePoints+=listCourses[j].getNumOfCredits()*3;
    		}else if(listCourses[j].getGradeRe().equals("B-")){
    			gradePoints+=listCourses[j].getNumOfCredits()*2.7;
    		}else if(listCourses[j].getGradeRe().equals("C+")){
    			gradePoints+=listCourses[j].getNumOfCredits()*2.30;
    		}else if(listCourses[j].getGradeRe().equals("C")){
    			gradePoints+=listCourses[j].getNumOfCredits()*2;
    		}else if(listCourses[j].getGradeRe().equals("C-")){
    			gradePoints+=listCourses[j].getNumOfCredits()*1.7;
    		}else if(listCourses[j].getGradeRe().equals("D+")){
    			gradePoints+=listCourses[j].getNumOfCredits()*1.3;
    		}else if(listCourses[j].getGradeRe().equals("D")){
    			gradePoints+=listCourses[j].getNumOfCredits()*1;
    		}else if(listCourses[j].getGradeRe().equals("D-")){
    			gradePoints+=listCourses[j].getNumOfCredits()*0.7;
    		}
    		nCredits += listCourses[j].getNumOfCredits();
    		
    		setCredits(nCredits); // sets the number of credits of all the classes taken
    		
    	}
    	    	
    	gpa=gradePoints/nCredits; //GPA calculated
    	
    }
    
	
	
	public void addStudent(Tree listStudents){ //O(n) if array courses is full it resizes 
		
		Student objStudent=new Student();
		Course objCourse= new Course();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter name");
		String name = keyboard.next();
		System.out.println("Enter last name");
		String lastname = keyboard.next();
		System.out.println("Enter course number,( 4 digit num).");
		String courNum = keyboard.next();
		System.out.println("Enter grade,Capital (A/A-/B+/B/B-/C+/C/C-/D+/D-)");
		String grade = keyboard.next();
		System.out.println("Enter number of credits of the class");
		double creditsNum = keyboard.nextDouble();
		
		Random num= new Random();
		String nums= String.valueOf(num.nextInt(100000)+100000);
		
		
	  addCourse(objStudent,objCourse,courNum,grade,creditsNum);
		
		objStudent.setName(name);
		objStudent.setLastName(lastname);
		objStudent.setId(nums);
		listStudents.insertTree(objStudent);
		
	}
	
	public void addCourse(Student studObject,Course cour,String courseNu, String grad, double cred){ //worst case O(n)
		cour.setCourseNum(courseNu);
		cour.setGradesRe(grad);
		cour.setNumOfCredits(cred);
		studObject.setArrayCourses(cour);
		
	}
	public void printer(File f1, Tree listStud){ // O(n) as it iterates inorder travesal through all nodes
		PrintWriter prints = null;			     // of the tree
		
		
		try{
			prints = new PrintWriter(f1);
			Iterator<Student> itr = listStud.getTreeStud().iterator();
			while(itr.hasNext()){
				prints.println(itr.next());
			}
			
				
		 prints.close();
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
    
		
}