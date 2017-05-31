package cpe_java_projet.model;



/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 * 
 * Interface de toutes les implémentation de jeu de plateau
 * un objet Game sera l'implémentation d'un objet BoardGames
 * = mise en oeuvre du DP Bridge
 */
public interface Games  {

	
	/**
	 * @param x abscisse de la case
	 * @param y ordonnée de la case
	 * @return true si une pièce se trouve aux coordonnées indiquées
	 */
	public boolean isPieceHere(int x, int y) ;

	/**
	 * @param xInit abscisse de la case de départ
	 * @param yInit ordonnée de la case de départ
	 * @param xFinal abscisse de la case d'arrivée
	 * @param yFinal ordonnée de la case d'arrivée
	 * @return true si  piece du jeu peut être déplacée aux coordonnées finales,
	 *  false sinon
	 */
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk,
			boolean isCastlingPossible);

	/**
	 * @param xInit abscisse de la case de départ
	 * @param yInit ordonnée de la case de départ
	 * @param xFinal abscisse de la case d'arrivée
	 * @param yFinal ordonnée de la case d'arrivée
	 * @return true si déplacement pièce effectué
	 */
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) ;


	/**
	 * @param xCatch abscisse de la pièce à capturer
	 * @param yCatch ordonnée de la pièce à capturer
	 * @return true si la piece aux coordonnées finales
	 * a été capturée
	 */
	public boolean capture(int xCatch, int yCatch) ;



}

