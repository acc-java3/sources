import java.io.*;
import java.util.*;

public class HelloTextAndPage {

	public static void main(String[] args) {
		
		Date now = new Date();
		
		System.out.println(now);
		
		try (PrintWriter pw = new PrintWriter(
				new BufferedWriter(
				new FileWriter("hello.html")))) {
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("\t<body>");
			pw.println("\t\t<h1>" + now + "</h1>");
			pw.println("\t</body>");
			pw.println("</html>");
		}
		catch (IOException ioe) {
			System.out.println("Oops! " + ioe.getMessage());
		}
		
	}
	
}