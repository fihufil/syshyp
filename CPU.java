import java.util.*;
import java.io.*;

class CPU extends Analyzer{

private static int CPUUsage(int howMany) throws IOException {
	int i;
	int Sum = 0;

//	FileReader fr = new FileReader("/proc/stat");
//	BufferedReader br = new BufferedReader(fr);
		
//	String text = br.readLine();
//	System.out.println("WYPISZ CALY CIONK");
//	System.out.println(text);
	String text = fetchLineFromFile("/proc/stat",0);

	String[] array = text.split("\\s+");
	int nums[] = new int[10];
 
	for (i=1; i<howMany+1; i++) {
	nums[i] = Integer.parseInt(array[i]);
//	System.out.println("WYPISZ CALY SLUPEK");
//	System.out.println(nums[i]);
	Sum += nums[i];
	}
//	fr.close();
	return Sum;
}


public float fetchCPUUSage() throws IOException {

	float First3Before = CPUUsage(3);
	float AllBefore = CPUUsage(7);

	try {
		Thread.sleep(1000);
	} catch(InterruptedException ex) {
	Thread.currentThread().interrupt();
	}

	float First3After = CPUUsage(3);
	float AllAfter = CPUUsage(7);

/*
	System.out.println("First3After");
	System.out.println(First3After);
	System.out.println("First3Before");
	System.out.println(First3Before);
	System.out.println("AllAfter");
	System.out.println(AllAfter);
	System.out.println("AllBefore");
	System.out.println(AllBefore);
*/

	//float tmp1 = First3After - First3Before;
	//float tmp2 = AllAfter - AllBefore;
	
	//System.out.println(tmp1/tmp2);
	
	return ((First3After - First3Before) / (AllAfter - AllBefore)) * 100;

	//System.out.println(toReturn);
/*	
	int i;
	int First3before = 0;
	int First3after = 0;
	int AllBefore = 0;
	int AllAfter = 0;
	//int array[] = new int[8];

	FileReader fr = new FileReader("/proc/stat");
	BufferedReader br = new BufferedReader(fr);
		
	String text = br.readLine();
	System.out.println(text);

	//for (i=0; i < 8; i++){
	//int[] array = Integer.parseInt((String)text.nextElement());
	//System.out.print(array[i]+" ");
	//}
 
	String[] array = text.split("\\s+");
	int nums[] = new int[10];
 
	for (i=1; i<7; i++) {
	nums[i] = Integer.parseInt(array[i]);
	System.out.println(nums[i]);
	AllBefore += nums[i];
	}
	for (i=1; i<4; i++) {
	First3before += nums[i];
	}
	fr.close();
	try {
		Thread.sleep(5000);
	} catch(InterruptedException ex) {
	Thread.currentThread().interrupt();
	}
	FileReader fr2 = new FileReader("/proc/stat");
	BufferedReader br2 = new BufferedReader(fr);
		
	String text = br.readLine();
	//System.out.println(text);

	String[] array2 = text.split("\\s+");
	int nums2[] = new int[10];
 
	for (i=1; i<7; i++) {
	nums[i] = Integer.parseInt(array[i]);
	AllAfter += nums[i];
	}
	for (i=1; i<4; i++) {
	First3after += nums[i];
	}
	System.out.println("% of CPU:");
	int cpuProcent = 0;

	System.out.println(First3after);
	System.out.println(First3after);
	System.out.println(AllAfter);
	System.out.println(AllBefore);
	cpuProcent = (First3after-First3before)/(AllAfter-AllBefore) * 100;
	System.out.println(cpuProcent);
	//Scanner scan = new Scanner(text);
	//while (scan.hasNext()) {
	//	array.add(scan.nextInt());
	//}
*/

}

public void showCPUUsage(){}

public String printCPUName() throws IOException {
	String line = fetchLineFromFile("/proc/cpuinfo",4);
	line = line.substring(13);
	return line;
}

}
