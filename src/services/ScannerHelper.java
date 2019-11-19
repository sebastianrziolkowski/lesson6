package services;

import enums.GroupSymbol;
import java.util.Scanner;

public class ScannerHelper {

    public static String scanNextLine(){
        return new Scanner(System.in).nextLine();
    }

    public static GroupSymbol scanGroupSymbolEnum(){
        GroupSymbol groupSymbol = null;
        try {
            groupSymbol = GroupSymbol.valueOf(new Scanner(System.in).nextLine().toUpperCase());
        }
        catch (Exception e){
            System.out.println("Try again using(I, II.... IX, X): ");
            scanGroupSymbolEnum();
        }
        return groupSymbol;
    }

}
