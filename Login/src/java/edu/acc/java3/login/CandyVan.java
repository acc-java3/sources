package edu.acc.java3.login;

public class CandyVan {
    private static final String[] treasures =
    {
        "Lolly", "Jolly Rancher", "Hubba Bubba", "Chupachup",
        "Hershey's Kiss", "Nutella Oreo", "Pickeled Egg"
    };
    
    public static String getRandomTreasure() {
        return treasures[(int)(Math.random() * treasures.length)];
    }
}
