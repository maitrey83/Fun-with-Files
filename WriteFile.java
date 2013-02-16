/*
 * File: WriteFile.java
 * ===============================================================
 * A program that writes text into a file.
 */

import acm.program.*;
import java.io.*;

public class WriteFile extends ConsoleProgram {
	/* THe name of the file to write to. */
	private static final String FILE_NAME = "result.txt";
	
	public void run() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME));
			pw.println("This didn't hurt anyone!");
			pw.close();
		} catch (IOException e) {
			println(":-(");
		}
	}
}
