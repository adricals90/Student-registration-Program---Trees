import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Tree {
	 
	private TreeSet<Student> Studtree= new TreeSet<>();
	private int count=0;
	
	Tree(){
	
	}

	public TreeSet <Student>getTreeStud() {
		return Studtree;
	}

	public void setArrStud(TreeSet<Student> arrStud) {
		this.Studtree = arrStud;
	}
	public int numberOfStudents(){return count;} //O(1)
	
	public void insertTree(Student a){   //  O(log n) runtime
		Studtree.add(a);
		count++;
   }
	
	
	public Student searchTree(String name){  // Linear search implemented O(n)
	
	    Student stud=null;
	        Iterator<Student> iterator = Studtree.iterator();

	        while(iterator.hasNext()) {
	             stud = iterator.next();
	            if(stud.getLastName().equals(name)) {   
	            	System.out.println("Student Found");
	                return stud;}

	        }
	  
	        return null;                
		
	}
	
	

	
	public void removeStudent(String name){ // search O(n)+ remove O(log n)
		Student m1= searchTree(name);
		if (m1!=null){
				Studtree.remove(m1);
				count--;
			      System.out.println("Student removed ");
		}
		
	}
	
	public String searchStud(String name){ // O(n) search 
		Student found= searchTree(name);
		if(found==null){
			return "Student not found";
		}else{	
		return found.toString();
		
		}
	}
	
	public void deleteCourse(String name){ // O(n) search + update node O(n)
		
		Student stud1= searchTree(name);
		if(stud1==null){
			System.out.println(" Student not found ");
			return;// Student not found";
		}else{
			removeStudent(name);
			stud1.deleteCourse(stud1.getArrayCourses());
			insertTree(stud1); 
		    System.out.println("last class was romoved");

		}
	
	}
	
	public void addCour(String name){ // search O(n) + Update a node (remove node O(n) and add a node (log n)),  
		Course newCourse= new Course();
		Student stud1= searchTree(name);
		if(stud1==null){
			System.out.println(" Student not found ");
			return;// Student not found";
		}
		
		Scanner keyboard = new Scanner(System.in);
	
		System.out.println("Enter course number,( 4 digit num).");
		String courNum = keyboard.next();
		System.out.println("Enter grade,Capital (A/A-/B+/B/B-/C+/C/C-/D+/D-)");
		String grade = keyboard.next();
		System.out.println("Enter number of credits of the class");
		double creditsNum = keyboard.nextDouble();
		
		removeStudent(name);
		stud1.addCourse(stud1, newCourse, courNum, grade, creditsNum);
		insertTree(stud1); 

		
		
	}
	
	
}
