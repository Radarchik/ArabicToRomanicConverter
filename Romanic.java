
package romanic;

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
public class Romanic {
//number for transfer into Roman numeral
    static int givenNumber;

// counters for thousands, hundreds, dozens and remainder of givenNumber
    static  int numberOfThousands = 0;
    static  int numberOfHundreds = 0;
    static  int numberOfDozens = 0;
    static  int remainderInTen = 0;

    /* */
    public static void countThousands() {
         while (givenNumber >=1000){
            givenNumber = givenNumber-1000;
             numberOfThousands++;
         }
       }

    public static void countHundreds (){
        while (givenNumber >=100){
            givenNumber = givenNumber-100;
            numberOfHundreds++;
        }
    }

    public static void countDozens (){
        while (givenNumber >=10){
            givenNumber = givenNumber-10;
            numberOfDozens++;
        }
        remainderInTen=givenNumber;
    }



    public static void converterFromArabicToRomanNumeral(int x) {

        // initializing fields for input Number
        givenNumber = x;
        countThousands();
        countHundreds();
        countDozens();

        //for checking
       // System.out.println(numberOfThousands + " " + numberOfHundreds + " " + numberOfDozens + " " + remainderInTen);

        //printing thousands (classic Roman numerals allow max 3 thousands !!!)
        System.out.print(symbols_n_times("M", numberOfThousands));

        //printing hundreds
        if (numberOfHundreds > 0 && numberOfHundreds <= 3)
            System.out.print(symbols_n_times("C", numberOfHundreds));
        else if (numberOfHundreds == 4)
            System.out.print("CD");
        else if (numberOfHundreds >= 5 && numberOfHundreds <= 8)
            System.out.print("D" + (symbols_n_times("C", numberOfHundreds - 5)));
        else if (numberOfHundreds == 9)
            System.out.print("CM");


        //printing dozens
        if (numberOfDozens > 0 && numberOfDozens <= 3)
            System.out.print(symbols_n_times("X", numberOfDozens));
        else if (numberOfDozens == 4)
            System.out.print("XL");
        else if (numberOfDozens >= 5 && numberOfDozens <= 8)
            System.out.print("L" + (symbols_n_times("X", numberOfDozens - 5)));
        else if (numberOfDozens == 9)
            System.out.print("XC");


        //printing remainder
        if (remainderInTen > 0 && remainderInTen <= 3)
            System.out.print(symbols_n_times("I", remainderInTen));
        else if (remainderInTen == 4)
            System.out.print("IV");
        else if (remainderInTen >= 5 && remainderInTen <= 8)
            System.out.print("V" + (symbols_n_times("I", remainderInTen - 5)));
        else if (remainderInTen == 9)
            System.out.print("IX");

    }
            // method just return x symbol  n times for reducing too much code in if-else statements
            public static String symbols_n_times(String x, int n){
            String z = "";
            for (int i = 0; i <n ; i++) {
                z=z+x;
            }
            return z;
        }


    public static void main(String[] args) {

        converterFromArabicToRomanNumeral(707);

        }

}
