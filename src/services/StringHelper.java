package services;

import resources.Constans;

import java.util.ArrayList;
import java.util.List;

public class StringHelper {

    public static String guessGender(String name){
        if(name.endsWith("a")){
            return Constans.GENDER_FEMALE;
        }
        else return Constans.GENDER_MALE;
    }

    public static List<Double> convertStringOfDoubeToListOfDouble(String stringOfDouble){
        String[] arrayOfDouble = stringOfDouble.split(",");
        List<Double> listOfFloat = new ArrayList<>();
        for (String s : arrayOfDouble) {
            listOfFloat.add(Double.valueOf(s));
        }
        return listOfFloat;
    }
}
