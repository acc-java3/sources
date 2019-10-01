package edu.acc.java3.hr;

import java.util.*;
import javax.servlet.*;
import edu.acc.java1.payroll.*;

public class StartupListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent e) {
		double[] hoursHourly = {0.0, 8.25, 8.25, 8.25, 8.0, 8.0, 0.0};
		double hourlySum = Arrays.stream(hoursHourly).sum();
		double[] hoursPiecer = {0.0, 8.0, 8.0, 8.0, 7.5, 0.0, 0.0};
		double piecerSum = Arrays.stream(hoursPiecer).sum();
		int[] pieces = {0, 204, 202, 214, 188, 0, 0};
		int pieceSum = Arrays.stream(pieces).sum();

		Salaried alice    = new Salaried("Alice", "Alpha", "CEO", 101, 80_000.00);
		Hourly   bob      = new Hourly("Bob", "Beta", "Widget Manager", 201, 28.00, hourlySum);
		Pieceworker gene  = new Pieceworker("Gene", "Gamma", "Widget Assembler", 301, 15.00, piecerSum, .18, pieceSum);
		List<Employee> staff = Arrays.asList(alice, bob, gene);
	
		ServletContext sc = e.getServletContext();
		sc.setAttribute("staff", staff);
		sc.setAttribute("bobsHours", hoursHourly);
		sc.setAttribute("genesHours", hoursPiecer);
		sc.setAttribute("genesPieces", pieces);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent e) {
	}
}