/**
 * Ville.java
 * 
 * @author Rayan Almohaize
 *
 */
package up.mi.da.agglomeration;


/**
 *Rperésente une ville de notre agglomeration
 */
public class Ville {
	/**
	 * Le nom de la ville
	 */
	private String nom;
	/**
	 * Un boolean nous indiquant si la ville possede une borne
	 */
	private boolean possedeUneBorne;
	/**
	 * l'identifiant de la ville
	 */
	private int id;

	/**
	 * Construit une ville à partire de son nom et possedant une borne, 
	 * dont l'identifiant est initialisé à -1
	 * 
	 * @param nom le nom de la ville
	 */
	public Ville(String nom) {
		this.id = -1;
		this.nom = nom;
		this.possedeUneBorne = false;
	}
	
	/**
	 * Constructeur par defaut initialisé avec un nom vide
	 */
	public Ville() {
		this("");
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) throws IllegalArgumentException{
		if(this.id<-1) {
			throw new IllegalArgumentException("L'ID d'une ville doit être superieur ou égale à -1");
		}
		else {
			this.id = id;
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean getPossedeUneBorne() {
		return possedeUneBorne;
	}

	public void setPossedeUneBorne(boolean possedeUneBorne) {
		this.possedeUneBorne = possedeUneBorne;
	}
	
	@Override
	public String toString(){
		return this.nom;
	}
	
}

