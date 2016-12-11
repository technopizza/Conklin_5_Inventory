/*******************************************************************************
* Filename: Main.java
* 
* Author: Conklin, Jason Date: November 3, 2016
* 
* Description: creates RngDrops objects and runs the program loop.
* 
* Input: Inventory
* 
* Output: Console
*******************************************************************************/
package inventory;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addToDrops(new RngDrops("bag_of_doritos", 2, false, "eat"));
        inv.addToDrops(new RngDrops("bottle_of_mountain_dew", 2, false, "chug"));
        inv.addToDrops(new RngDrops("meteorite", 15, false, "examine"));
        inv.addToDrops(new RngDrops("case_of_crippling_depression", 100000, false, "are emotionally destroyed by"));
        inv.addToDrops(new RngDrops("block_of_wood", 15, false, "sit on"));
        inv.addToDrops(new RngDrops("fedora", 2, false, "wear"));
        inv.addToDrops(new RngDrops("crying_baby", 10, false, "gently rock"));
        inv.addToDrops(new RngDrops("school_of_piranhas", 30, true, "get eaten by"));
        inv.addToDrops(new RngDrops("white_flag", 5, false, "wave"));
        inv.addToDrops(new RngDrops("pocket_disintegrator", 2, true, "activate"));
        inv.addToDrops(new RngDrops("pack_of_cigarettes", 2, true, "smoke"));
        while(inv.isAlive()){ //main loop
            inv.setCurrentDrop(inv.getRandomDrop());
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("A " + inv.getCurrentDrop().getName() + " just dropped!");
            System.out.println();
            System.out.println("What will you do?");
            System.out.println();
            System.out.println("Current Weight: " + inv.getWeight());
            System.out.println();
            switch(inv.menu()){
                case "1":
                    inv.checkBag();
                    break;
                case "2":
                    inv.pickUp();
                    break;
                case "3":
                    inv.dropItem();
                    break;
                case "4":
                    inv.useItem();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Bad Input.");
                    break;
            }
            
        }
        
    
    }
    
    
}
