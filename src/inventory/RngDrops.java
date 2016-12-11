package inventory;

/*******************************************************************************
* Filename: RngDrops.java
* 
* Author: Conklin, Jason Date: November 3, 2016
* 
* Description: defines variables and getter/setters of the RngDrops object
* 
* Input: None
* 
* Output: None
*******************************************************************************/
public class RngDrops {
    private String name;
    private int weight;
    private boolean kills;
    private String action;

    public RngDrops(String name, int weight, boolean kills, String action) {
        this.name = name;
        this.weight = weight;
        this.kills = kills;
        this.action = action;
    }    
    
    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isKills() {
        return kills;
    }

    public String getAction() {
        return action;
    }
    
}
