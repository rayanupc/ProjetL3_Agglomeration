/**
 * SauvegardeAgglomeration.java
 * 
 * @author Rayan Almohaize, Djibril Dahoub
 *
 */
package up.mi.da.agglomeration;

import java.io.*;

/**
 *Permet l'automatisation du traitemant d'une agglomeration
 */

public class SauvegardeAgglomeration {
	/**
	 * Permet de sauvegarder toutes les informations d'une agglomeration
	 * dans un fichier nommer sauvegardeAgglomeration.txt
	 * 
	 * @param agglo l'agglomeration pour laquelle nous voulons enregistrer les informations
	 */
	public static void sauvegardeAgglomeration(Agglomeration agglo, String fichier) {
		File f = new File(fichier);
		try(BufferedWriter bf = new BufferedWriter(new FileWriter(f));
			PrintWriter pw = new PrintWriter(bf)){
			
			//On écrit les informations de la méthode toString dans le fichier  
			f.createNewFile();
			pw.println(agglo.toString());
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("L'agglomeration à bien été sauvegarder dans le fichier "+fichier);
	}

}
