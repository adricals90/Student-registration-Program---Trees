import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {

		//String fileNme= "WarmUpData.txt"; // name of the FILE
		String fileNme= "WarmUpData.txt";
		File file= new File(fileNme);
		Student objStudent= new Student();
		Tree arr= new Tree();
		objStudent.readData(file, arr);// reads data from the file (Student class)
		
		gpaStud(arr);
        System.out.println(" Current Registration ");

        consolDisplay(arr);
        
        
		
        System.out.println("Enter 1 to add a new student ");
        System.out.println("Enter 2 to search and display student's information");
        System.out.println("Enter 3 to search a student and add a course ");
        System.out.println("Enter 4 to search a student and delete a course ");
        System.out.println("Enter 5 to search a student and delete a student ");
        System.out.println("Enter 6 to display curreny registration ");
        System.out.println("Enter 7 to save and print current registration");
        System.out.println("Enter o to exit");
        
        
        
			 Scanner keyb = new Scanner(System.in);
			 
			 boolean terminate = false;
	            int menu;
	            do {
	                  System.out.print("Choose menu item: ");
	                  menu = keyb.nextInt();
	                  switch (menu) {
	                  case 1:
	                        System.out.println("Adding Sudent #1");
	                        
	           			    objStudent.addStudent(arr);
	                        
	                        break;
	                  case 2:
	                	    System.out.println("Enter student's last name to to show student's information #2");
	                        Scanner keys = new Scanner(System.in);
	           			    String name1 = keys.next();
	           		        System.out.println(arr.searchStud(name1));

	                        
	           			    
	                        break;
	                  case 3:
	                	    System.out.println("Enter student's last name to add course #3");
	                        Scanner key1 = new Scanner(System.in);
	           			    String name2 = key1.next();
	           			    arr.addCour(name2);
	           			    gpaStud(arr);
	           			    
	                        
	                        break;
	                  case 4:
	                	   System.out.println("Enter student's last name to remove a course #4");
                           Scanner key2 = new Scanner(System.in);
         			       String name3 = key2.next();
         			        arr.deleteCourse(name3);
         			        gpaStud(arr);

	                        break;
	                  case 5:
	                	  System.out.println("Enter student's last name to remove student #5");
                          Scanner key3 = new Scanner(System.in);
        			      String name4 = key3.next();
        			      arr.removeStudent(name4);
	                        
	                        
	                        break;
	                  case 6:
	                	    System.out.println("Current registration #6");
	                        consolDisplay(arr);
	                	  
	                	    break;
	                  case 7:
	                	   System.out.println("Printing and saving current registrations #6");
	                	   File file1= new File("NewRegistrationFile.txt"); // will create a new file 
	           			   objStudent.printer(file1, arr); //writes the file
	                       consolDisplay(arr);
	                	  	
	                	  	break;
	                  case 0:
	                        terminate = true;
	                        break;
	                  default:
	                        System.out.println("Invalid choice.");
	                  }
	            } while (!terminate);

				
	

       }
	
	public static void consolDisplay(Tree m){// display in the console 
		                       				// runtime O(n)
	
		Iterator<Student> itr = m.getTreeStud().iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
	}
	
	public static void gpaStud(Tree arr){ //runtime O(n^2) with the inner loop that runs in gpa()
	
		Iterator<Student> itr = arr.getTreeStud().iterator();
		while(itr.hasNext()){
			 itr.next().gpa();
		}
		
		
	} 
}
