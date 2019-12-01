package pl.put.poznan.sqc.Helpers;

public class WhiteSpace {
    public static int AmountOnFront(String sentance){
        int amount = 0;
        for (int i = 0; i< sentance.length(); i++){
            if(sentance.charAt(i) == ' ')
                amount++;
            else
                return amount;
        }
        return amount;
    }
}
