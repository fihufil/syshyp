import java.util.*;
import java.io.*;

class Disk extends Analyzer{

//    String line;
//    OutputStream stdin = null;
//    InputStream stderr = null;
//    InputStream stdout = null;

public int fetchDiskUSage() throws IOException{
	Process process = new ProcessBuilder("/bin/df").start();
	InputStream is = process.getInputStream();
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(isr);
	String line;
	
	//System.out.printf("Output of running %s is:", Arrays.toString(args));
	
	//while ((line = br.readLine()) != null) {
	//	System.out.println(line);
	//}
	line = br.readLine();
	line = null;
	line = br.readLine();
	int nums[] = new int[10];

	String[] array = line.split("\\s+");
	//for (int i=0; i<6; i++) {
	array[4] = array[4].replace("%", "");
	return Integer.parseInt(array[4]);
	//System.out.println(toReturn);
	//}
}

public String showSystemVersion() throws IOException{
	String line = fetchLineFromFile("/proc/version_signature",0);
	return line;
}

public void showDiskUsage(){}

}
