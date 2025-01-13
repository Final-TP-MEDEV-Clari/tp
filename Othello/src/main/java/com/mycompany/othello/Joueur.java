/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.othello;

/**
 *
 * @author Clara
 */
public class Joueur {
    private String nom;
    private boolean peutJouer;
    private boolean couleur;
    
    public Joueur(){
        this.nom = "";
        this.peutJouer = true;
        this.couleur = false;
    }

    public boolean isPeutJouer() {
        return peutJouer;
    }

    public void setPeutJouer(boolean peutJouer) {
        this.peutJouer = peutJouer;
    }
    
  
    
}
