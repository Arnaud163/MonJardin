// Classe Utils - version 2.0

/**
 * Classe qui définit les fonctions de lecture et d'écriture,
 * dans l'interface utilisateur et dans un fichier.
**/

import java.io.*;
import java.io.File;

public class Utils {
	// Les fonctions lireChaine et lireEntier
	// Exemple d'utilisation dans une autre classe :
	// String nbarbres = Utils.lireEntier("Combien d'arbres souhaitez-vous enlever ? ");
	public static String lireChaine(String question) {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		
		System.out.print(question);
		System.out.flush();
		return loadString(br);
	}
	
	// La lecture d'un entier n'est qu'un parseInt de plus !!
	public static int lireEntier(String question) {
		return Integer.parseInt(lireChaine(question));	
	}
	
	// écriture d'une chaîne dans un BufferedWriter
	public static void saveString(BufferedWriter bw, String s) {
		try {
			bw.write(s);
			bw.newLine();
		}
		catch (IOException ioe) {}
	}
	
	// écriture d'un entier : on convertit en chaîne et on se ramène
	// à la procédure précédente
	public static void saveInt(BufferedWriter bw, int i) {
		Integer q = new Integer(i);
		saveString(bw, q.toString());
	}
	
	// ouverture en écriture d'un fichier
	// rend un BufferedWriter -- null si pas possible de l'ouvrir
	
	public static BufferedWriter openWriteFile(File f) {
		BufferedWriter bw = null;
		try {
			if (f.canWrite()) {
				FileWriter fw = new FileWriter(f);
				bw = new BufferedWriter (fw);
			}
		}
		catch (IOException ioe) {}
		return bw;
	}
	
	// ouverture en lecture d'un fichier
	// rend un BufferedReader -- null si pas possible de l'ouvrir
	public static BufferedReader openReadFile(File f) {
		BufferedReader br = null;
		try {
			if (f.canRead()) {
				FileReader fr = new FileReader(f);
				br = new BufferedReader(fr);
			}
		}
		catch (IOException ioe) {}
		return br;
	}
	
	// lecture dans un BufferedReader d'une chaîne de caractères
	public static String loadString(BufferedReader br) {
		String s="";
		try {
			s = br.readLine();
		}
		catch (IOException ioe) {}
		return s;
	}
	
	// lecture d'un entier dans un BufferedReader
	public static int loadInt(BufferedReader br) {
		return Integer.parseInt(loadString(br));
	}
}
