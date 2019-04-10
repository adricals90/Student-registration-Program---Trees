
public class Course {
	private String courseNum;
	private double numOfCredits;
	private String gradeRe;
	
	Course (){
		courseNum="";
		numOfCredits=0;
		gradeRe="";
	}
	
	public void setCourseNum(String cnum){	courseNum= cnum;}
	public void setNumOfCredits(double credits){ numOfCredits= credits;}
	public void setGradesRe(String grade){ gradeRe = grade;}
	
	public String getCourseNum(){return courseNum;}
	public double getNumOfCredits(){ return numOfCredits;}
	public String getGradeRe(){ return gradeRe;}
	
	public String toString(){
		
		return  courseNum+ ", "+String.valueOf(numOfCredits)+", "+gradeRe+"\n";

	}
	

}