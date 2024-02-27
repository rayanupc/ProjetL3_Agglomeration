/**
 * AgglomerationTest.java
 * 
 * @author Rayan Almohaize, Djibril Dahoub
 * 
 */
package up.mi.da.allTest;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import up.mi.da.agglomeration.*;
import up.mi.da.exceptions.VilleInexistanteException;

/**
 * Cette class regroupe l'nessemble des test unitaires de notre programme.
 */
public class AgglomerationTest {
	
	private Agglomeration agglo;
	private Graphe graphe;
    private Ville villeA;
    private Ville villeB;
    private Ville villeC;
    private Ville villeD;
    private Ville villeE;
	
    /**
     * Avant chaque test untaire la méthode beforeEach lance l'initialisation de notre agglomération, 
     * de ses villes, de ses routes et de ses zones de recharges
     */
	@BeforeEach
	public void beforeEach() {
		graphe = new Graphe(5);
		agglo = new Agglomeration(graphe);
		
		agglo.ajoutVille("A");
		agglo.ajoutVille("B");
		agglo.ajoutVille("C");
		agglo.ajoutVille("D");
		agglo.ajoutVille("E");
		
		agglo.ajoutRoute("A", "B");
		agglo.ajoutRoute("B", "C");
		agglo.ajoutRoute("C", "A");
		agglo.ajoutRoute("C", "D");
		agglo.ajoutRoute("C", "E");
		
        agglo.ajoutZoneDeRecharge("A");
        agglo.ajoutZoneDeRecharge("B");
        
        villeA = agglo.getEnssembleDeVille().get(0);
        villeB = agglo.getEnssembleDeVille().get(1);
        villeC = agglo.getEnssembleDeVille().get(2);
        villeD = agglo.getEnssembleDeVille().get(3);
        villeE = agglo.getEnssembleDeVille().get(4);
	}
	
	
	
	/**
	 * Test paramétré de notre méthode estRelie
	 * Vérifie si le fait de lancer la méthode avec des entier <0 ou >nbVille
	 * renvoie bien une exception IndexOutOfBoundsException
	 * 
	 * @param ville1 indice de la premiere ville 
	 * @param ville2 indice de la deuxieme ville
	 */
	@ParameterizedTest
	@CsvSource({"8, 0", "1, -10", "4, 7", "45, 45", "6, 2"})
	public void estRelieTestException(int ville1, int ville2) {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			agglo.getGraphe().estRelie(ville1, ville2);
		});		
	}
	
	
	
	/**
	 * Test paramétré de notre méthode ajoutLiaison
	 * Vérifie si le fait de lancer la méthode avec des entier <0 ou >nbVille
	 * renvoie bien une exception IndexOutOfBoundsException
	 * 
	 * @param ville1 indice de la premiere ville 
	 * @param ville2 indice de la deuxieme ville
	 */
	@ParameterizedTest
	@CsvSource({"8, 0", "1, -10", "4, 7", "45, 45", "6, 2"})
	public void ajoutLisaisonTestException(int ville1, int ville2) {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			agglo.getGraphe().ajoutLiaison(ville1, ville2);
		});		
	}
	
	
	
	/**
	 * Test paramétré de notre méthode setNbVille
	 * Vérifie si le fait de lancer la méthode avec des entier <0
	 * renvoie bien une exception IndexOutOfBoundsException
	 * 
	 * @param nbVille nombre de ville choisi 
	 */
	@ParameterizedTest
	@CsvSource({"-8", "-1", "-4", "-45", "-6"})
	public void setNbVilleTestException(int nbVille) {
		assertThrows(IllegalArgumentException.class, () -> {
			agglo.getGraphe().setNbVille(nbVille);
		});		
	}
	
	
	
	/**
	 * Test paramétré de notre méthode rechercheVille
	 * Vérifie si le fait de lancer la méthode renvois bien le nom de la ville recherché via son id
	 * 
	 * @param nomVille le nom de la ville recherchée
	 * @param indiceVille l'indice de la ville recherchée
	 */
	@ParameterizedTest
	@CsvSource({"A, 0", "B, 1", "C, 2", "D, 3", "E, 4"})
	public void rechercheVilleTest(String nomVille, int indiceVille) {
		assertEquals(nomVille, agglo.rechercheVille(indiceVille).getNom());
	}
	
	
	
	/**
	 * Test paramétré de notre méthode ajoutLiaison
	 * Vérifie si le fait de lancer la méthode renvois bien l'id de la ville recherché via son nom
	 * et renvoie bien une exception de type VilleInexistanteException si on met un nom de ville 
	 * qui n'existe pas dans l'agglomeration en parametre
	 * 
	 * @param ville1
	 * @param ville2
	 */
	@ParameterizedTest
	@CsvSource({"A, 0", "B, 1", "C, 2", "D, 3", "E, 4"})
	public void rechercheIndiceVilleTest(String nomVille, int indiceVille) {
		assertThrows(VilleInexistanteException.class, () -> {
			agglo.rechercheIndiceVille("T");
		});
		try {
			assertEquals(indiceVille, agglo.rechercheIndiceVille(nomVille));
		}catch(VilleInexistanteException e) {
			e.getMessage();
		}
	}	
	
	
	
	/**
	 * Test paramétré de notre méthode listeVilleBorne
	 * Vérifie si la méthode renvoie bien la liste des villes possédants des bornes
	 */
	@Test
	public void listeVilleBorneTest() {
		for(Ville v : agglo.getEnssembleDeVille()) {
			v.setPossedeUneBorne(true);
		}
		assertEquals("Les villes possedant une borne sont : A B C D E ", agglo.listeVilleBornes());
	}

	
	
	/**
	 * Test paramétré de notre méthode ajoutRoute
	 * Vérifie si la méthode renvoie bien une exception si l'on met deux fois la meme ville en parametre
	 * 
	 * @param nomVille nom de la ville qui sera deux dans les parametre
	 */
	@ParameterizedTest
	@CsvSource({"A", "B", "C", "D", "E"})
	public void ajoutRouteSurLaMemeVilleTestException(String nomVille) {
		assertThrows(IllegalArgumentException.class, () -> {
			agglo.ajoutRoute(nomVille, nomVille);
		});
	}
	
	
	
	/**
	 * Test de notre méthode ajoutZoneDeRecharge
	 * Véridie si la méthode ajoute bien une zone de recharge dans les villes passé en parametre
	 */	
	@Test
	public void ajoutZoneDeRechargeTest() {
		agglo.ajoutZoneDeRecharge("C");
		assertTrue(villeC.getPossedeUneBorne());
		agglo.ajoutZoneDeRecharge("D");
		assertTrue(villeD.getPossedeUneBorne());		
		agglo.ajoutZoneDeRecharge("E");
		assertTrue(villeE.getPossedeUneBorne());
	}
	
	
	
	/**
	 * Test de notre méthode retirerZoneDeRecharge
	 * Véridie si la méthode retire bien une zone de recharge dans les villes passé en parametre
	 * tout en respectant les condition d'accessibilité
	 */ 
	@Test
	public void retirezZoneDeRechargeTest() {
        agglo.ajoutZoneDeRecharge("E");
		agglo.retirerZoneDeRecharge("E");
		assertTrue(villeE.getPossedeUneBorne());
		agglo.retirerZoneDeRecharge("A");
		assertFalse(villeA.getPossedeUneBorne());
		agglo.ajoutZoneDeRecharge("B");
		assertTrue(villeB.getPossedeUneBorne());		
	}
	
	
	
	/**
	 * Test de notre méthode villeVoisineSansBorne 
	 * Vérifie si la methode renvoie bien la liste des villes voisine n'ayant pas de borne(et pas de borne voisine)
	 * de la ville passé en parametre
	 */
	@Test
	public void villeVoisineSansBorneTest() {
        String result = agglo.villeVoisineSansBorne(villeA);
        assertEquals("", result);
        
        result = agglo.villeVoisineSansBorne(villeB);
        assertEquals("", result);
        
        result = agglo.villeVoisineSansBorne(villeC);
        assertEquals("D, E, ", result);
        
        result = agglo.villeVoisineSansBorne(villeD);
        assertEquals("", result);
        
        result = agglo.villeVoisineSansBorne(villeE);
        assertEquals("", result);
	}
	
	
	
	/**
	 * Test de notre méthode possedBorneVoisine
	 * Verifie si la méthode vérifie bien qu'une ville passé en parametre possede une borne voisine ou non 
	 */
	@Test
	public void possedeBorneVoisineTest() {
		assertTrue(agglo.possedUneBorneVoisine(villeA));
		assertTrue(agglo.possedUneBorneVoisine(villeB));
		assertTrue(agglo.possedUneBorneVoisine(villeC));
		assertFalse(agglo.possedUneBorneVoisine(villeD));
		assertFalse(agglo.possedUneBorneVoisine(villeE));
	}
	
	
	
	/**
	 * Test de notre méthode nbSatisfactionBorne
	 * Vérifie si la méthode renvoie bien le nombre de ville qu'une ville passé en paramétre
	 * pourrait satisfaire avec sa borne
	 */
	@Test
	public void nbSatisfactionBorneTest() {
		assertEquals(0, agglo.nbSatisfactionDeBorne(villeA));
		assertEquals(0, agglo.nbSatisfactionDeBorne(villeB));
		assertEquals(3, agglo.nbSatisfactionDeBorne(villeC));
		assertEquals(1, agglo.nbSatisfactionDeBorne(villeD));
		assertEquals(1, agglo.nbSatisfactionDeBorne(villeE));
	}
	
	
	
	/**
	 * Test de notre méthode respecteConditionAccessibilite
	 * Verifie si la methode vérifie bien qu'une agglomération passé en parametre 
	 * respecte les Condition d'Accessibilite aux bornes ou non
	 */
	@Test
	public void respecteConditionAccessibiliteTest() {
		assertFalse(agglo.respecteConditionAccessibilite());
	}
	
	
	/**
	 * Test de notre méthode optimisationScoreAgglomeration
	 * Verifie si la methode optimise bien le score(nombre de borne) d'une agglomération
	 */
	@Test
	public void optimisationScoreAgglomerationTest() {
		agglo.optimisationScoreAgglomeration();
		assertEquals("Les villes possedant une borne sont : C ", agglo.listeVilleBornes());
	}
	
	
	/**
	 * Test de notre méthode respecteConditionAccessibilite
	 * Verifie si la methode renvoie bien True aprés optimisation
	 * i.e l'agglomération réspecte bien les Conditions d'Accessibilite aux bornes
	 */
	@Test
	public void respecteConditionAccessibiliteApresOptimisationTest() {
		agglo.optimisationScoreAgglomeration();
		assertTrue(agglo.respecteConditionAccessibilite());
	}
	
}
