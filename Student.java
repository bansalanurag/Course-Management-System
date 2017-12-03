import java.util.ArrayList;
import java.util.List;

public class Student {
	String name;
	String deg;
	int rollno;
	int year;
	List<String> coursetaken = new ArrayList<String>();
	
	public Student(String name,int roll,String deg,int yr){
		this.name = name;
		this.rollno = roll;
		this.deg = deg;
		this.year = yr;
	}
	public void enroll(String a,int myidx){		
		int cidx=0;
		for(int i=0;i<Index.c.size();i++){
			if(Index.c.get(i).name.equals(a)){
				cidx=i;
				break;
			}
		}
		if((Index.c.get(cidx).d.equals(Index.s.get(myidx).deg))&&(Index.c.get(cidx).yr<=Index.s.get(myidx).year)&&(Index.s.get(myidx).coursetaken.contains(Index.c.get(cidx).other)||Index.c.get(cidx).other==null)&&Index.c.get(cidx).max>0){			
			Index.s.get(myidx).coursetaken.add(a);
			Index.c.get(cidx).studenrolled.add(Index.s.get(myidx).name);
			Index.c.get(cidx).max--;			
			System.out.println("Enrollment_Success");
		}
		else{
			System.out.println("Not_eligble_to_enroll_course");
		}
	}
	
	public void unenroll(String a,int myidx){
		int cidx=0;
		for(int i=0;i<Index.c.size();i++){
			if(Index.c.get(i).name.equals(a)){
				cidx=i;
				break;
			}
		}
		
		if(Index.s.get(myidx).coursetaken.isEmpty()){
			System.out.println("Nothing_to_unenroll");
		}
		else{
			Index.s.get(myidx).coursetaken.remove(a);
			Index.c.get(cidx).studenrolled.remove(Index.s.get(myidx).name);
			Index.c.get(cidx).max++;
			System.out.println("Unenroll_Success");
		}
	}
	
	public static void show(int myidx){
		System.out.println("Student_Name:" + Index.s.get(myidx).name + " ");
		System.out.println("Student_Deg:" + Index.s.get(myidx).deg + " ");
		System.out.println("Student_Rollno:" + Index.s.get(myidx).rollno + " ");
		System.out.println("Student_Year:" + Index.s.get(myidx).year + " ");
		if(Index.s.get(myidx).coursetaken.size()==0){
			System.out.println("Student_courses: No_courses_enrolled");
		}
		else{
			System.out.print("Student_courses:");
			for(int i=0;i<Index.s.get(myidx).coursetaken.size();i++){
				System.out.print(Index.s.get(myidx).coursetaken.get(i) + " ");
			}
			System.out.println();
		}
	}
}