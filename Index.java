import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Index {
	static List<Prof> p = new ArrayList<Prof>();
	static List<Course> c = new ArrayList<Course>();
	static List<Student> s = new ArrayList<Student>();	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner ip = new Scanner(new File("input.txt"));
		int x,y,yr;
		String a,b,n,d,input; 
		while(ip.hasNext()){
			input = ip.next();
			if(input.equalsIgnoreCase("ADDS")){
				a = ip.next();
				x = ip.nextInt();
				b = ip.next();
				y = ip.nextInt();				
				s.add(new Student(a,x,b,y));
			}
			else if(input.equalsIgnoreCase("ADDP")){				
				a = ip.next();
				b = ip.next();			
				p.add(new Prof(a,b));			
			}
			else if(input.equalsIgnoreCase("ADDC")){				
				a = ip.next();
				x = ip.nextInt();
				b = ip.next();
				d = ip.next();
				yr = ip.nextInt();
				n = ip.next();
				if(ccheck(a)){
					System.out.println("Course_Already_Exists");
				}
				else{
					if(pcheck(b,a)){
						if(n.compareTo("NULL")==0)
							c.add(new Course(a,x,b,d,yr));
						else
							c.add(new Course(a,x,b,d,yr,n));
					}
					else
						System.out.println("No_such_Professor");
				}
			}
			else if(input.equalsIgnoreCase("ENROLL")){				
				a = ip.next();				
				b = ip.next();				
				int temp = scheck(b); 
				if(s.size()==0||temp==s.size())
					System.out.println("No_such_Student");
				else {
					Student t = s.get(temp);
					if(s.get(temp).coursetaken.contains(a))
						System.out.println("Course_Already_Enrolled");
					else
						t.enroll(a,temp);
				}					
			}
			else if(input.equalsIgnoreCase("UNENROLL")){				
				a = ip.next();				
				b = ip.next();				
				int temp = scheck(b); 
				if(s.size()==0||temp==s.size())
					System.out.println("No_such_Student");
				else {
					Student t = s.get(temp);
					if(s.get(temp).coursetaken.contains(a))
						t.unenroll(a,temp);
					else
						System.out.println("Course_not_found_to_unroll");						
				}					
			}
			else if(input.equalsIgnoreCase("SHOWS")){				
				a = ip.next();								
				int temp = scheck(a); 
				if(s.size()==0||temp==s.size())
					System.out.println("No_such_Student");
				else {
					Student.show(temp);
				}					
			}
			else if(input.equalsIgnoreCase("SHOWC")){				
				a = ip.next();								
				if(ccheck(a))
					Course.show(a);			
				else
					System.out.println("No_Such_Course");
			}
			else if(input.equalsIgnoreCase("MODIFY")){				
				a = ip.next();						
				x = ip.nextInt();
				b = ip.next();				
				if(ccheck(a)){
					if(pcheck(b,a)){
						Course.modify(a,x,b);
						System.out.println("Modify_Success");
					}
					else
						System.out.println("No_Such_Professor_to_Modify_in_course");
				}
				else
					System.out.println("No_Such_Course_to_Modify");
			}
			else if(input.equalsIgnoreCase("SHOWP")){				
				a = ip.next();
				int pidx = pcheck2(a);
				if(p.size()==0||pidx==p.size())
					System.out.println("No_Such_Professor");
				else
					Prof.show(pidx);						}
		}
		ip.close();
	}
	
	public static int scheck(String name){
		for(int i=0;i<s.size();i++){
			if(s.get(i).name.equals(name))
				return i;
		}
		return 0;
	}
	
	public static boolean pcheck(String name,String course){
		for(int i=0;i<p.size();i++){
			if(p.get(i).name.equals(name)){
				p.get(i).coursetaking.add(course);
				return true;
			}
		}
		return false;		
	}
	
	public static int pcheck2(String name){
		for(int i=0;i<p.size();i++){
			if(p.get(i).name.equals(name)){				
				return i;
			}
		}
		return 0;		
	}
	
	public static boolean ccheck(String name){
			for(int i=0;i<c.size();i++){
				if(c.get(i).name.equals(name))
					return true;
			}				
		return false;		
	}
}
