/**
 * Graphe.java
 * 
 * @author Rayan Almohaize
 *
 */
package up.mi.da.agglomeration;

/**
 * Represente une matrice d'adjacence nous permettant de construire notre graphe
 */

public class Graphe {
	
	/**
	 * Matrice de boolean
	 */
	private boolean [][] matrice;
	/**
	 * Nombre de ville
	 */
	private int nbVille;
	
	/**
	 * Construit une matrice d'adjacence de boolean à partir d'une nombre de ville représeantant un graphe,
	 * et la matrice est entierement initialisée a false
	 * 
	 * @param nbVille nombre de villes permettant de construire la matrice nbVille x nbVille
	 */
	public Graphe(int nbVille) {
		this.nbVille = nbVille;
		matrice = new boolean [nbVille][nbVille];
	}
	
	/**
	 * Constructeur par défaut. 
	 * Construit une matrice avec un nombre de ville initialisé à 0.
	 */
	public Graphe(){
		this(0);
	}

	public boolean[][] getMatrice() {
		return matrice;
	}
	
	public void setMatrice(boolean[][] matrice) {
		this.matrice = matrice;
	}
	
	public int getNbVille() {
		return nbVille;
	}

	

	public void setNbVille(int nbVille) throws IllegalArgumentException {
		if(nbVille<0) {
			throw new IllegalArgumentException("Le nombre de ville doit être supérieur ou égale à 0");
		}
		else {
			this.nbVille = nbVille; 
			boolean [][] matrice = new boolean[nbVille][nbVille];
			this.setMatrice(matrice);
		}
	}
	
	
	
	
	/**
	 * Ajoute une liaison dans le graphe
	 * 
	 * @param i l'indice de la ligne dans laquelle l'élément se trouve dans la matrice
	 * @param j l'indice de la colonn dans laquelle l'élément se trouve dans le graphe
	 * @throws IndexOutOfBoundsException
	 */
	public void ajoutLiaison(int i, int j) throws IndexOutOfBoundsException{
		if(i>this.nbVille || j>this.nbVille || i<0 || j<0) {
			throw new IndexOutOfBoundsException("Les indices des villes entré en paramètre n'existes pas");
		}
		else {
			this.matrice[i][j] = true;
			this.matrice[j][i] = true;
		}
	}
	
	
	
	
	/**
	 * Indique si il y a une liaison dans le graphe entre l' éléments
	 * à la ligne i et l' éléments à la colonne j
	 * 
	 * @param i l'indice de la ligne dans laquelle l'élément se trouve dans la matrice
	 * @param j l'indice de la colonn dans laquelle l'élément se trouve dans le graphe
	 * @return true si les deux éléments sont relié, false sinon
	 * @throws IndexOutOfBoundsException
	 */
	public boolean estRelie(int i, int j) throws IndexOutOfBoundsException{
		if(i>this.nbVille || j>this.nbVille) {
			throw new IndexOutOfBoundsException("Les indices des villes entré en paramètre n'existes pas");
		}
		else {
			return this.matrice[i][j];
		}	
	}
	
}

