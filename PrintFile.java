/*
 * File: PrintFile.java
 * ================================================================
 * A program that displays the contents of a file.
 */
import acm.program.*;
import java.io.*;
public class PrintFile extends ConsoleProgram {
	/* The name of the file to display. */
	private static final String FILE_NAME = "PrintFile.java";
	
	public void run() {
		/* Just as the man on the stair wasn't there, if we don't
		 * make the font any bigger then the text won't be either.
		 */
		setFont("CourierNew-BOLD-24");
		
		try {
			/* Open the file for reading. */
			BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
			
			/* Print out all lines of the file. */
			while (true) {
				String line = br.readLine();
				if (line == null) break;
				
				println(line);
			}
			br.close();
		} catch (IOException e) {
			/* Sad times! */
			println("Ohnoez teh filez day r broken!!1");
		}
		
	}
}
