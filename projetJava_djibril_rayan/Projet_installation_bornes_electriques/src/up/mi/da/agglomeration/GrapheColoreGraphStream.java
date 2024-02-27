/**
 * GrapheColoreGraphStream.java
 * 
 * @author Rayan Almohaize, Djibril Dahoub
 *
 */
package up.mi.da.agglomeration;

import java.util.ArrayList;
import java.util.List;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *Class permettant la création d'une interface pour que l'utilisateur puisse visualiser son agglomération
 */
public class GrapheColoreGraphStream {
	
	/**
	 * Permet d'afficher une fenêtre GraphStream avec le graph représentant l'agglomération crée et les bornes en rouge
	 * 
	 * @param agglo l'agglomération pour laquelle on veux afficher le graph représentant
	 */
	public static void grapheColore(Agglomeration agglo) {
        // Créer un graphe simple
        Graph graph = new SingleGraph("Mon Agglomération");
        List<Node> nodes = new ArrayList<Node>();
        
        //création des noeuds
        for(Ville v : agglo.getEnssembleDeVille()) {
        	Node n = graph.addNode(v.getNom());
        	/*
        	 * Les noeud possedant des bornes seront en rouge et les autres en noirs.
        	 * Les noeud pessederenont un texte en blanc(ce texte représentera le nom du noeud i.e le nom de la ville)
        	 */
            n.setAttribute("ui.style", "text-size: 40; text-color: white; size: 40px;");
        	if(v.getPossedeUneBorne()==true) {
                n.setAttribute("ui.style", "fill-color: rgb(255,0,0); text-size: 40; text-color: white; size: 40px;");
        	}
        	nodes.add(n);
        }
        
        //création des arêtes
        for(int i=0; i<agglo.getEnssembleDeVille().size(); i++) {
            for(int j=0; j<agglo.getEnssembleDeVille().size(); j++) {
            	if(agglo.getGraphe().estRelie(i, j)) {
            		Ville v1 = new Ville();
            		Ville v2 = new Ville();
            		for(Ville v : agglo.enssembleDeVille) {
            			if(v.getId()==i) {
            				v1.setId(v.getId());
            				v1.setNom(v.getNom());
            			}
               			if(v.getId()==j) {
            				v2.setId(v.getId());
            				v2.setNom(v.getNom());
            			}
            		}
            		int index1 = 0;
            		int index2 = 0;
            		for(int k=0; k<nodes.size(); k++) {
            			if(nodes.get(k).getId().equals(v1.getNom())) {
            				index1 = k;
            				//nommage des noeud
            				nodes.get(k).setAttribute("ui.label", v1.getNom());
            			}
            			if(nodes.get(k).getId().equals(v2.getNom())) {
            				index2 = k;
            				//nommage des noeud
            				nodes.get(k).setAttribute("ui.label", v2.getNom());
            			}
            		}
            		//Le cas où l'on a l'arête AB et BA par exemple, on en garde q'une seule car notre graphe est non orienté
            		if(graph.getEdge(v2.getNom()+v1.getNom())==null) {
            			graph.addEdge(v1.getNom()+v2.getNom(), nodes.get(index1), nodes.get(index2));
            		}
            	}
            }
        }
               
       // Ajouter un nœud spécial pour afficher le message de fin
        Node messageNode = graph.addNode("message");
        messageNode.setAttribute("ui.label", "Les ville contenant les bornes de recharge sont en rouge. Merci d'avoir utiliser notre application !");
        messageNode.setAttribute("xyz", 0.5, 5, 0); 
        messageNode.setAttribute("ui.style", "size : 0px; text-size: 30px; text-color: black;");
        
        //lancement de la fenêtre du graphe
        System.setProperty("org.graphstream.ui", "swing");
        graph.display();
	}
	
}
