package observer.converter;

/**
 *
 * @author Tarasz Szinyovics
 */
public class Message
{
    private String arabicNumeral;
    private String romanNumeral;
    private String action;
    private String response;

    public Message(String action, String arabicNumeral, String romanNumeral) {
        this.action = action;
        this.arabicNumeral = arabicNumeral;
        this.romanNumeral = romanNumeral;
    }

         
    public String getArabicNumeral() {
        return arabicNumeral;
    }

    public String getRomanNumeral() {
        return romanNumeral;
    }
    

    /**
     * @return the action
     */
    public String getAction()
    {
        return action;
    }
    
    public void setResponse(String response)
    {
        this.response = response;
    }
    
    public String getResponse()
    {
        return response;
    }
}
