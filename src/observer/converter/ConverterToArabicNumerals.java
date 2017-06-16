/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer.converter;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tszin
 */
public class ConverterToArabicNumerals implements Observer {

    static String[] Rome = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
        "IX", "V", "IV", "I"};
    static int[] Arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public int romeToArab(String rome) throws IndexOutOfBoundsException {

        StringBuilder romeNumber = new StringBuilder(rome.toUpperCase());
        int arabNumber = 0, i = 0;
// Check the passed string for presence characters
        if (romeNumber.length() > 0) {
            while (true) {
                do {

                    if (Rome[i].length() <= romeNumber.length()) {
                        //Select a substring from the string and compare it with the value from the array Arab
                        if (Rome[i].equals(romeNumber.substring(0,
                                Rome[i].length()))) {
                            // Then add the number corresponding to the index of the element 
                            //of the Roman numeral from the Arab array
                            arabNumber += Arab[i];
                            // And remove from the line the Roman numeral
                            romeNumber.delete(0, Rome[i].length());
                            if (romeNumber.length() == 0) {
                                return arabNumber;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } while (true && romeNumber.length() != 0);
                i++;
            }
        }
        return 0;

    }

    @Override
    public void update(Observable o, Object arg) {

        Message msg = (Message) arg;
        if (msg.getAction().equals(UIMessages.CONVERT) && !msg.getRomanNumeral().isEmpty()) {
            try {   //catching Exception from method romeToArab, so this is validation for right input
                int result = new ConverterToArabicNumerals().romeToArab(msg.getRomanNumeral());
                msg.setResponse(String.valueOf(result));
                /* Now we need to send this result back to the object that originally
                 sent the message. */
            } catch (IndexOutOfBoundsException ex) {
                //if the Exception was cought - input roman number was invalid
                msg.setResponse("Wrong number");
            }
        }
    }

}
