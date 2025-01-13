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
    private Tableau tableau;

    
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

    
    public boolean isPeutJouer() {
        return peutJouer;
    }

    public void setPeutJouer(boolean peutJouer) {
        this.peutJouer = peutJouer;
    }

    public void setTableau(Tableau tableau) {
        this.tableau = tableau;
    }
    
    /**
     * Setter PeutJouer
     * @param peutJouer
     */
    public void calculPeutJouer() {
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                if (tableau.peutPlacer(this, i, j)) {
                    this.peutJouer = true;
                    return;
                }
            }
        }
        this.peutJouer = false;
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
