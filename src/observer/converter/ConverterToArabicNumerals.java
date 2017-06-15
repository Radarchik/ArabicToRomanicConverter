/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer.converter;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author tszin
 */
public class ConverterToArabicNumerals implements Observer {
 
	static String[] Rome = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
			"IX", "V", "IV", "I" };
	static int[] Arab = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	public int romeToArab(String rome) {
		
StringBuilder romeNumber = new StringBuilder(rome);
int arabNumber = 0, i = 0;
// Проверяем переданную строку на наличие символов
if (romeNumber.length() > 0) {
	while (true) {
	do {

		if (Rome[i].length() <= romeNumber.length()) {
		// Выделяем из строки подстроку и сравниваем со
		// значением из массива Arab
		if (Rome[i].equals(romeNumber.substring(0,
			Rome[i].length()))) {
			// После чего прибавляем число соответствующее
			// индексу элемента римской цифры из массива Arab
			arabNumber += Arab[i];
			// и удаляем из строки римскую цифру
			romeNumber.delete(0, Rome[i].length());
			if (romeNumber.length() == 0)
			return arabNumber;
		} else
			break;
		} else
		break;
	} while (true && romeNumber.length() != 0);
	i++;
	}
}
return 0;

}

    @Override
    public void update(Observable o, Object arg) {

        
         Message msg = (Message) arg;
        if(msg.getAction().equals(UIMessages.CONVERT))
        {
            int result = new ConverterToArabicNumerals().romeToArab(msg.getRomanNumeral());
            msg.setResponse(String.valueOf(result));
            /* Now we need to send this result back to the object that originally
            sent the message. */
        }
    }
    
}
