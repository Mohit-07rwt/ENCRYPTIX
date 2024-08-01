package tasks;
import java.util.Scanner;
public class task2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("\nEnter number of subjects:\t");
		int n=s.nextInt();
			
		int[] m=new int[n]; //m= marks ,n=number of subjects
		int t=0;  //total marks
		
		for (int i=0,value;i<n;i++) {
			System.out.print("\nenter marks obtained out of 100 in subjects:"+(i+1));
			value= s.nextInt();
			if(value<=100){
				m[i]=value;
				t+=m[i];
				}
			else{
				System.out.println("!!please enter the valid marks!!!");
				i--;
				}
		}
		s.close();
		//calculate average percentage
		float avg=(float)t/n;
		String g;
		switch((int)(avg/10)) {
		case 9,10:
			g="A";
			break;
		case 8:
			g="B";
			break;
		case 7:
			g="C";
			break;
		case 6:
			g="D";
			break;
		case 5,4:
			g="E";
			break;
		default:
			g="Fail";
			break;
			}
		System.out.println("\nTotal marks:"+t+"/"+n*100);
		System.out.println("\nAverage percentage:"+avg);
		System.out.println("\nGrade:"+g);
	}
}
