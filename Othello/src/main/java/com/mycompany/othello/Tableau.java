/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.othello;

/**
 *
 * @author Clara
 */
public class Tableau {
    public static int width = 8;
    public static int height = 8;

    private Peon[][] tableau;

    public Tableau() {
        this.tableau = new Peon[width][height];

    }
    
    public Peon[][] getTableau() {
        return tableau;
    }

    public void setTableau(Peon[][] tableau) {
        this.tableau = tableau;
    }
    
    public boolean peutPlacer(Joueur joueur, String case){
    
    }
}
