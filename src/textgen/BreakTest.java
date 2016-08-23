package textgen;

public class BreakTest {
	public static void main(String args[]) {
	int j=11;
		for(int i=0;i<10;i++){
			if(i==5){
			j=i;
			break;
			}
		System.out.println("In For"+i);
		}
	System.out.println("Out of For"+j);
		
	}
}


