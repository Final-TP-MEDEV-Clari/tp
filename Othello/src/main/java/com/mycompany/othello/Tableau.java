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
    
    public boolean peutPlacer(Joueur joueur, int x, int y){
        
     
    return false;

    }
    
    public boolean isFull() {
        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                if (tableau[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
