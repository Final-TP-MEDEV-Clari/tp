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
    
    public void init() {
        this.tableau[3][3] = new Peon(true, 3, 3);
        this.tableau[4][4] = new Peon(true, 4, 4);
        
        this.tableau[3][4] = new Peon(false, 3, 4);
        this.tableau[4][3] = new Peon(false, 4, 3);
    }
    
    public Peon[][] getTableau() {
        return tableau;
    }

    public void setTableau(Peon[][] tableau) {
        this.tableau = tableau;
    }
    
    public boolean peutPlacer(Joueur joueur, String pos){
        char letter = pos.charAt(0);
        int number = (int)(pos.charAt(1));
        
        int position = pos - 'a' + 1;

    }
}
