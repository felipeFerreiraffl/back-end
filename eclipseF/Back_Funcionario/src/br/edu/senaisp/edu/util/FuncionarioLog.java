package br.edu.senaisp.edu.util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.time.LocalDate;

public class FuncionarioLog {
	private static String pathLog = "C:\\temp\\log\\";
	
	public static boolean escrever(String msg) {
		String pathLogDestino = pathLog + LocalDate.now().getYear() 
				+ "_" + LocalDate.now().getMonth() 
				+ "_" + LocalDate.now().getDayOfMonth();
		
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(pathLogDestino, Charset.forName("UTF-8"), true));
			pw.append(msg);
			
			pw.close();
			return true;
		} catch (Exception e) {
			System.out.println("Não conseguir liber recurso" + e.getMessage());
			return false;
		}
	}
}
