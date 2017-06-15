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
   // private ConverterToRomanNumerals generator;
    private ConverterToArabicNumerals generator;
    
    public Controller()
    {
        ui = new SimpleForm();
        //generator = new ConverterToRomanNumerals();
        generator = new ConverterToArabicNumerals();
        ui.addObserver(generator);
        ui.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new Controller();
    }
}
