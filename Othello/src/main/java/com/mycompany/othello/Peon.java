/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.othello;

/**
 *
 * @author Clara
 */
public class Peon {
    private boolean couleur;
    private int x;
    private int y;
    
    public Peon(boolean couleur, int x, int y)  {
        this.couleur = couleur; // blanc = true, noir = false
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isCouleur() {
        return couleur;
    }

    public void setCouleur(boolean couleur) {
        this.couleur = couleur;
    }
}
