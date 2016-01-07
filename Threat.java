import java.util.*;
import java.io.*;

class Threat {

//TODO:
//search for >>[preauth]<< in /var/log/auth.log
//search for >>pam_unix(sudo:auth): authentication failure;<< in /var/log/auth.log

protected String tailFromFile = null;

public Threat(){
tailFromFile = null;
}

protected static String tail() {// "borrowed" from http://stackoverflow.com/questions/686231/quickly-read-the-last-line-of-a-text-file
	File file = new File("/var/log/auth.log");
	RandomAccessFile fileHandler = null;
	try {
        fileHandler = new RandomAccessFile( file, "r" );
        long fileLength = fileHandler.length() - 1;
        StringBuilder sb = new StringBuilder();

        for(long filePointer = fileLength; filePointer != -1; filePointer--){
            fileHandler.seek( filePointer );
            int readByte = fileHandler.readByte();

            if( readByte == 0xA ) {
                if( filePointer == fileLength ) {
                    continue;
                }
                break;

            } else if( readByte == 0xD ) {
                if( filePointer == fileLength - 1 ) {
                    continue;
                }
                break;
            }

            sb.append( ( char ) readByte );
        }

        String lastLine = sb.reverse().toString();
        return lastLine;
    } catch( java.io.FileNotFoundException e ) {
        e.printStackTrace();
        return null;
    } catch( java.io.IOException e ) {
        e.printStackTrace();
        return null;
    } finally {
        if (fileHandler != null )
            try {
                fileHandler.close();
            } catch (IOException e) {
                /* ignore */
            }
    }
}

protected static String searchForString(String text) throws IOException {
//
	String tailFromFile = tail();

	if( tailFromFile.contains(text) == true ) {
	return tailFromFile;
	}
	else {
		return "";
	}
}

}
