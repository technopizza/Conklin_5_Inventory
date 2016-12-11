package inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

/*******************************************************************************
* Filename: Inventory.java
* 
* Author: Conklin, Jason Date: November 3, 2016
* 
* Description: contains the methods for the menu loop, and uses ArrayLists and listIterators to manipulate RngDrops objects 
* 
* Input: RngDrops
* 
* Output: Console
*******************************************************************************/

public class Inventory {
    private ArrayList<RngDrops> drops;
    private ArrayList<RngDrops> inventory;
    ListIterator<RngDrops> listIterator;
    private RngDrops currentDrop;
    Scanner scanner = new Scanner(System.in);
    private int weight;
    private boolean alive;
    
    Inventory(){
        this.drops = new ArrayList();
        this.inventory = new ArrayList();
        this.alive = true;
        this.weight = 0;
    }
    /********************************************************************************
    * Method: menu
    * 
    * Description: prints the user menu of options, and returns user input
    *  
    * Parameters: none
    * 
    * Pre-Conditions: none
    * 
    * Post-Conditions: none
    *******************************************************************************/
    String menu(){
        System.out.println("1. Check Bag");
        System.out.println("2. Pick Up");
        System.out.println("3. Drop Item");
        System.out.println("4. Use Item");
        System.out.println("5. Ignore");
        return scanner.next();
    }
      /********************************************************************************
    * Method: checkBag
    * 
    * Description: lists out the contents of the bag
    *  
    * Parameters: none
    * 
    * Pre-Conditions: none
    * 
    * Post-Conditions: none
    *******************************************************************************/
        void checkBag(){
        listIterator = inventory.listIterator();
        if(inventory.size() > 0){
            System.out.println("The bag contains ");
            while(listIterator.hasNext()){
                System.out.println( listIterator.next().getName());
            }
        }
        else{
            System.out.println("The bag is empty...");
        }
    }
         /********************************************************************************
    * Method: pickUp
    * 
    * Description: Adds the current dropped item to the bag
    *  
    * Parameters: none
    * 
    * Pre-Conditions: none
    * 
    * Post-Conditions: none
    *******************************************************************************/
    void pickUp(){
        inventory.add(currentDrop);
        weight += currentDrop.getWeight();
        if(weight > 50){
            System.out.println("You have been killed by your " + currentDrop.getName() + ". You just couldn't bear its weight.");
            alive = false;
        }else{
            System.out.println("You place the " + currentDrop.getName() + " in your bag.");
        }
        
    }

     /********************************************************************************
    * Method: dropItem
    * 
    * Description: removes all instances of a user-chosen item from th bag
    *  
    * Parameters: none
    * 
    * Pre-Conditions: none
    * 
    * Post-Conditions: none
    *******************************************************************************/
    void dropItem(){
        System.out.println("What item do you want to drop?");
        String itemChoice = scanner.next();
        listIterator = inventory.listIterator();
        ArrayList toDelete = new ArrayList();
        if(inventory.size() > 0){
            int i = 0;
            while(listIterator.hasNext()){
                if(listIterator.next().getName().equalsIgnoreCase(itemChoice)){
                    toDelete.add(listIterator.previous());
                    listIterator.remove();
                    i++;
                }
            }
            inventory.removeAll(toDelete);
            System.out.println("Dropped " + i + " " + itemChoice + "(s)");
        }
        else{
            System.out.println("The bag is empty...");
        }
    }
    /********************************************************************************
    * Method: useItem
    * 
    * Description: prints the effects of the last picked up item
    *  
    * Parameters: none
    * 
    * Pre-Conditions: none
    * 
    * Post-Conditions: none
    *******************************************************************************/
    void useItem(){
        
        if(inventory.size() > 0){
            RngDrops lastItem = inventory.get(inventory.size() - 1);
            inventory.remove(lastItem);
            weight -= lastItem.getWeight();
            System.out.println("You " + lastItem.getAction() + " your" + lastItem.getName() + ".");
            if(lastItem.isKills()){
                System.out.println("You have died.");
                alive = false;
            }
        }
        else{
            System.out.println("The bag is empty...");
        }
    }

    public RngDrops getRandomDrop() {
        Random random = new Random();
        return drops.get(random.nextInt(drops.size()));
    }
    
    public void addToDrops (RngDrops drop){
        drops.add(drop);
    }
    

    public ArrayList<RngDrops> getInventory() {
        return inventory;
    }

    public RngDrops getCurrentDrop() {
        return currentDrop;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setCurrentDrop(RngDrops currentDrop) {
        this.currentDrop = currentDrop;
    }
    
}
