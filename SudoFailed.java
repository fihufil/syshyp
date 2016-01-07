import java.util.*;
import java.io.*;

class SudoFailed extends Threat{

public String fetchSudoFailed() throws IOException {

String returned = searchForString("pam_unix(sudo:auth): authentication failure;");

if(!returned.equals("") && !returned.equals(tailFromFile)){
	tailFromFile = tail();
	StringJoiner joiner = new StringJoiner("");
	joiner.add(" | Warr: ");
	joiner.add(returned);
	String joined = joiner.toString();
	
	return joined;
}
else return "";
}

}

