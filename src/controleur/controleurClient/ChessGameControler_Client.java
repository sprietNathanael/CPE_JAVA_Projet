/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.controleurClient;

import cpe_java_projet.controleur.ChessGameControlers;
import cpe_java_projet.model.Coord;
import socket.socketClient.SocketSender_Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nathanael
 */
public class ChessGameControler_Client implements ChessGameControlers{
    
    private SocketSender_Client socket_sender;
    
    public ChessGameControler_Client(SocketSender_Client sender) {
        this.socket_sender = sender;
    }

    
    @Override
    public boolean move(Coord initCoord, Coord finalCoord) {
        List<Coord> liste = new ArrayList<Coord>(Arrays.asList(initCoord,finalCoord));
        System.out.println("move " + liste);
        this.socket_sender.send(liste);
        return false;
    }

    @Override
    public boolean isEnd() {
        this.socket_sender.send("isEnd");
        return false;
    }

    @Override
    public boolean isPlayerOK(Coord initCoord) {
        System.out.println("isPlayerOk " + initCoord);
        this.socket_sender.send(initCoord);
        return true;
    }

    @Override
    public String getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
