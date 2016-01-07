import java.util.*;
import java.io.*;

class RAM extends Analyzer{

private static float fetchRAMdetails(int mode) throws IOException{
// 0 for MemTotal
// 1 for MemFree
// 2 for Buffers
// 3 for Cached

	String line = fetchLineFromFile("/proc/meminfo",mode);
	line = line.replaceAll("[^\\d.]", "");
	return Integer.parseInt(line);
}

public float fetchRAMUSage() throws IOException{

	//FileReader fr = new FileReader("/proc/meminfo");
	//BufferedReader br = new BufferedReader(fr);

	float nums[] = new float[5];
	String text[] = new String[5];

	for(int i=0; i<4; i++){
	//text[i] = fetchLineFromFile("/proc/meminfo",i);
	//text[i] = br.readLine();
	//text[i] = text[i].replaceAll("[^\\d.]", "");
	//System.out.println(i);
	//System.out.println(text[i]);
	nums[i] = fetchRAMdetails(i);
	//System.out.println(nums[i]);
	}
	//System.out.println("RAM");
	return ((nums[0]-nums[1]-nums[2]-nums[3])/nums[0])*100;
	//System.out.println(toReturn);
	//fr.close();
}

public float showMaxRAM() throws IOException{

return fetchRAMdetails(0)/1024/1024;

}

public void showRAMUsage(){}

}

