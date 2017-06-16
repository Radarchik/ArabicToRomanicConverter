package observer.controller;

import observer.converter.ConverterToRomanNumerals;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import observer.converter.ConverterToArabicNumerals;
import observer.gui.SimpleForm;

/**
 *
 * @author tszin
 */
public class Controller
{
    private SimpleForm ui;
    private ConverterToRomanNumerals generator1;
    private ConverterToArabicNumerals generator2;
    
    public Controller()
    {
        ui = new SimpleForm();
        generator1 = new ConverterToRomanNumerals();
        generator2 = new ConverterToArabicNumerals();
        ui.addObserver(generator1);
        ui.addObserver(generator2);
        ui.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new Controller();
    }
}
