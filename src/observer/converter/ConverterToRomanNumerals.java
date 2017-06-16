package observer.converter;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by tszin on 12/06/2017.
 */

/* Rules for Roman numerals
* 1-9 = I II III IV V VI VII VIII IX
* 10  = X
* 50 = L
* 100 = C
* 500 = D
* 1000 = M
*
*
I placed before X or V indicates one less, so four is IV (one less than five) and nine is IX (one less than ten)

X placed before L or C indicates ten less, so forty is XL (ten less than fifty) and ninety is XC (ten less than a hundred)

C placed before D or M indicates a hundred less, so four hundred is CD (a hundred less than five hundred)
and nine hundred is CM (a hundred less than a thousand)[5]\
* */
public class ConverterToRomanNumerals implements Observer {
//number for transfer into Roman numeral

    private static int givenNumber;

// counters for thousands, hundreds, dozens and remainder of givenNumber
    private static int numberOfThousands;
    private static int numberOfHundreds;
    private static int numberOfDozens;
    private static int remainderInTen;

    public ConverterToRomanNumerals() {
    }

    /* */
    public static void countThousands() {
        numberOfThousands = 0; //as it is static field, setting to "0" previous result
        while (givenNumber >= 1000) {
            givenNumber = givenNumber - 1000;
            numberOfThousands++;
        }
    }

    public static void countHundreds() {
        numberOfHundreds = 0;
        while (givenNumber >= 100) {
            givenNumber = givenNumber - 100;
            numberOfHundreds++;
        }
    }

    public static void countDozens() {
        numberOfDozens = 0;
        while (givenNumber >= 10) {
            givenNumber = givenNumber - 10;
            numberOfDozens++;
        }
    }

    public static void countRemainderInTen() {
        remainderInTen = givenNumber;
    }

    public static String converterFromArabicToRomanNumeral(int x) {

        // initializing fields for input Number
        givenNumber = x;

        // counting thousands, hundreds, dozens and remainder of givenNumber
        countThousands();
        countHundreds();
        countDozens();
        countRemainderInTen();

        //for checking
        //System.out.println(numberOfThousands + " " + numberOfHundreds + " " + numberOfDozens + " " + remainderInTen);

        String result = "";
        //printing thousands (classic Roman numerals allow max 3 thousands !!!)
        result += symbols_n_times("M", numberOfThousands);

        //printing hundreds
        if (numberOfHundreds > 0 && numberOfHundreds <= 3) {
            result += symbols_n_times("C", numberOfHundreds);
        } else if (numberOfHundreds == 4) {
            result += "CD";
        } else if (numberOfHundreds >= 5 && numberOfHundreds <= 8) {
            result += ("D" + (symbols_n_times("C", numberOfHundreds - 5)));
        } else if (numberOfHundreds == 9) {
            result += "CM";
        }

        //printing dozens
        if (numberOfDozens > 0 && numberOfDozens <= 3) {
            result += symbols_n_times("X", numberOfDozens);
        } else if (numberOfDozens == 4) {
            result += "XL";
        } else if (numberOfDozens >= 5 && numberOfDozens <= 8) {
            result += ("L" + (symbols_n_times("X", numberOfDozens - 5)));
        } else if (numberOfDozens == 9) {
            result += "XC";
        }

        //printing remainder
        if (remainderInTen > 0 && remainderInTen <= 3) {
            result += symbols_n_times("I", remainderInTen);
        } else if (remainderInTen == 4) {
            result += "IV";
        } else if (remainderInTen >= 5 && remainderInTen <= 8) {
            result += "V" + (symbols_n_times("I", remainderInTen - 5));
        } else if (remainderInTen == 9) {
            result += "IX";
        }

        return result;

    }
    // method just return x symbol  n times for reducing too much code in if-else statements

    public static String symbols_n_times(String x, int n) {
        String z = "";
        for (int i = 0; i < n; i++) {
            z = z + x;
        }
        return z;
    }

    @Override
    public void update(Observable o, Object arg) {

        Message msg = (Message) arg;
        if (msg.getAction().equals(UIMessages.CONVERT) && !msg.getArabicNumeral().isEmpty()) {
            String result = converterFromArabicToRomanNumeral(Integer.parseInt(msg.getArabicNumeral()));
            msg.setResponse(result);
            /* Now we need to send this result back to the object that originally
            sent the message. */
        }
    }

}
