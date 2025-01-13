/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.othello;

/**
 *
 * @author Clara et Larissa
 */
public class Joueur {
    private String nom;
    private boolean peutJouer;
    private boolean couleur;
    
    /**
     * Constructeur par default Joueur
     */
    public Joueur(){
        this.nom = "";
        this.peutJouer = true;
        this.couleur = false;
    }

    /**
     * Getter PeutJouer
     * @return getPeutJouer
     */
    public boolean getPeutJouer() {
        return peutJouer;
    }

    /**
     * Setter PeutJouer
     * @param peutJouer
     */
    public void setPeutJouer(boolean peutJouer) {
        this.peutJouer = peutJouer;
    }

    /**
     * getter Nom
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter Couleur
     * @return couleur
     */
    public boolean getCouleur() {
        return couleur;
    }

    /**
     * setter Couleur
     * @param couleur
     */
    public void setCouleur(boolean couleur) {
        this.couleur = couleur;
    }
    
    
    
}
