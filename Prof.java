import java.util.ArrayList;
import java.util.List;

public class Prof {
	String name;
	String area;
	
	List<String> coursetaking = new ArrayList<String>();
	
	public Prof(String name,String area){
		this.name = name;
		this.area = area;
	}
	
	public static void show(int pidx){
		System.out.println("Prof_Name:" + Index.p.get(pidx).name + " ");
		System.out.println("Prof_Area:" + Index.p.get(pidx).area + " ");
		if(Index.p.get(pidx).coursetaking.isEmpty()){
			System.out.println("Prof_Courses: No_courses_taken");
		}
		else{
			System.out.print("Prof_Courses:");
		for(int i=0;i<Index.p.get(pidx).coursetaking.size();i++)
			System.out.print(Index.p.get(pidx).coursetaking.get(i) + " ");	
		}
		System.out.println();
	}
}
