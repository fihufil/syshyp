import java.util.*;
import java.io.*;

class Analyzer {

protected static String fetchLineFromFile(String file, int lineNum) throws IOException{//but this should be private
// We will always start loops from 0 in this method

	FileReader fr = new FileReader(file);
	BufferedReader br = new BufferedReader(fr);
	
	String line;
	int howMuchShouldISkip = lineNum - 1;
	
	for(int i=0; i<=howMuchShouldISkip; i++) {
	line = br.readLine();
	line = null;
	}
	//finally read the line we need;
	line = br.readLine();

	fr.close();

return line;
}

public void saveToText(){}

}

/*
final class CPUUsage {
    private final int first3;
    private final int all;

    public CPUUsage(int first3, int all) {
        this.first3 = first3;
        this.all = all;
    }

    public int getFirst3() {
        return first;
    }

    public int getAll() {
        return all;
    }
}

// ...

public static CPUUsage giveCPUUsage() {
    int number1 = 1;
    int number2 = 2;

    return new MyResult(number1, number2);
}
*/

/*

*/
