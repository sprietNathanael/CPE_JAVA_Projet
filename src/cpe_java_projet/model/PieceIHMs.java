/**
 * 
 */
package cpe_java_projet.model;

import java.io.Serializable;

/**
 * @author francoise.perrin
 * Cette interface permet de réduire l'interface de Pieces  
 * en ne donnant que des getters
 */
public interface PieceIHMs extends Serializable {
	
	/**
	 * @return indice de la colonne où est positionnée la piece
	 */
	public int getX();
	
	/**
	 * @return indice de la ligne où est positionnée la piece
	 */
	public int getY();
	
	/**
	 * @return couleur de la piece
	 */
	public Couleur getCouleur();
	

	/**
	 * @return le nom de la pièce (Tour, Cavalier, etc.)
	 *
	 */
	public String getNamePiece();
	
}
