import java.util.*;
import java.io.*;

class SSHFailed extends Threat{

public String fetchSSHFailed() throws IOException {

String returned = searchForString("[preauth]");


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
