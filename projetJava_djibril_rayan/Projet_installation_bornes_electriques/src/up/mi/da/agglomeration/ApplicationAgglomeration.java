/**
 * ApplicationAglomeration.java
 * 
 * @author Rayan Almohaize, Djibril Dahoub
 *
 */
package up.mi.da.agglomeration;

import java.util.Scanner;
import java.io.File;

public class ApplicationAgglomeration {
    public static void main(String[] args) {
    	// Vérifier s'il y a bien un argument en paramétre au lancement du code
        if (args.length == 0) {
            System.err.println("Veuillez fournir le chemin du fichier en argument. (chemin/vers/votre/fichier.txt)");
            return;
        }
        String fichier = args[0];
        // Vérifier si le fichier existe
        File file = new File(fichier);
        if (!file.exists()) {
            System.err.println("Le fichier spécifié n'a pas été trouvé : " + fichier);
        }
    	Scanner sc = new Scanner(System.in);
        MenuApplication.menu(fichier, sc);
        sc.close();
	}
}
