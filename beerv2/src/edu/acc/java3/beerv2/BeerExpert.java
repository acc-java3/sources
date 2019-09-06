package edu.acc.java3.beerv2;

import java.util.List;
import java.util.ArrayList;

public class BeerExpert {

    public List<String> getBrands(String color) {
        List<String> result = new ArrayList<>();
        switch (color) {
            case "light":
                result.add("Jail Pale Ale");
                result.add("Frogger Lager");
                break;
            case "amber":
                result.add("Tiffany Thiessen Amber Ale");
                result.add("Red Moose");
                break;
            case "brown":
                result.add("Frown Town Brown");
                result.add("Shorter Porter");
                break;
            case "dark":
                result.add("Gout Stout");
                break;
        }
        return result;
    }

}

