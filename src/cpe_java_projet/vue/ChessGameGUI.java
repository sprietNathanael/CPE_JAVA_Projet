/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpe_java_projet.vue;

import cpe_java_projet.controleur.ChessGameControlers;
import cpe_java_projet.model.Coord;
import cpe_java_projet.model.PieceIHM;
import cpe_java_projet.tools.ChessImageProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author nathanael
 */
public class ChessGameGUI extends JFrame implements java.util.Observer, MouseListener, MouseMotionListener{
    
    private JPanel chessBoard;
    private JLayeredPane layeredPane;
    private JLabel chessPiece;
    
    private int xAdjustment;
    private int yAdjustment;
    private Coord currentCoordinates;
    private ChessGameControlers chessGameControler;
    
    public ChessGameGUI(String jeu_déchec, ChessGameControlers chessGameControler, Dimension dim)
    {
        
        this.chessGameControler = chessGameControler;
        //  Use a Layered Pane for this this application
 
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(dim);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);
        
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
    
    public int getComponentIndex(Component component) {
        if (component != null && component.getParent() != null) {
            Container c = component.getParent();
            for (int i = 0; i < c.getComponentCount(); i++) {
                if (c.getComponent(i) == component)
                return i;
            }
        }
        return -1;
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
            panel.removeAll();
            panel.add(piece);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        chessPiece = null;
        this.currentCoordinates = null;
        Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
 
        if (c instanceof JPanel) 
            return;
 
        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        int componentIndex = getComponentIndex(c.getParent());
        int y = (int) (componentIndex / 8);
        int x = componentIndex - (y*8);
        Coord coordinates = new Coord(x,y);
        if(this.chessGameControler.isPlayerOK(coordinates))
        {
            this.currentCoordinates = coordinates;
            chessPiece = (JLabel)c;
            chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
            chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
            layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(chessPiece == null) return;
        
        chessPiece.setVisible(false);
        Component c =  chessBoard.findComponentAt(e.getX(), e.getY());

        int componentIndex;
        if (c instanceof JLabel) {
            componentIndex = getComponentIndex(c.getParent());
        } else {
            componentIndex = getComponentIndex(c);
        }
        int y = componentIndex / 8;
        int x = componentIndex - (y * 8);
        Coord coordinates = new Coord(x, y);
        this.chessGameControler.move(this.currentCoordinates, coordinates);
        chessPiece = null;
        this.currentCoordinates = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (chessPiece == null) return;
         chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
}
