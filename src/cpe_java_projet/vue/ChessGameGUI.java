/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpe_java_projet.vue;

import cpe_java_projet.controleur.ChessGameControlers;
import cpe_java_projet.model.Couleur;
import cpe_java_projet.model.PieceIHM;
import cpe_java_projet.tools.ChessImageProvider;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author nathanael
 */
public class ChessGameGUI extends JFrame implements java.util.Observer, MouseListener, MouseMotionListener{
    
    JPanel chessBoard;
    JLayeredPane layeredPane;

    public ChessGameGUI(String jeu_déchec, ChessGameControlers chessGameControler, Dimension dim)
    {
        //  Use a Layered Pane for this this application
 
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(dim);
        //layeredPane.addMouseListener(this);
        //layeredPane.addMouseMotionListener(this);
        
        //Add a chess board to the Layered Pane 
 
        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout( new GridLayout(8, 8) );
        chessBoard.setPreferredSize( dim );
        chessBoard.setBounds(0, 0, dim.width, dim.height);
        
        for (int i = 0; i < 64; i++)
        {
            JPanel square = new JPanel( new BorderLayout() );
            chessBoard.add( square );
 
            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground( i % 2 == 0 ? Color.black : Color.white );
            else
                square.setBackground( i % 2 == 0 ? Color.white : Color.black );
        }
        
        
        
        
    }

    @Override
    public void update(Observable o, Object arg)
    {

        List<PieceIHM> piecesIHM = (List<PieceIHM>) arg;

        JPanel panel;
        JLabel piece;
        // création d'un tableau 2D avec les noms des pièces
        for(PieceIHM pieceIHM : piecesIHM)
        {
            piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile(pieceIHM.getNamePiece(), pieceIHM.getCouleur())) );
            panel = (JPanel)chessBoard.getComponent((pieceIHM.getY()*8)+pieceIHM.getX());
            panel.add(piece);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
