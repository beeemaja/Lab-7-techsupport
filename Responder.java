import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java. util.HashSet;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input HashSet<String>.
 * 
 * @author     Mayya Bareeva, Huong Phan, Omar Gabarine
 * @version    0.1 (04.06.2018)
 */
public class Responder
{
    private Random random;
    private ArrayList <String> responses;
    private HashMap<String, String> answersMap;
    private HashSet<String> words;
    /**
     * Construct a Responder.
     */
    
    public Responder()
    {
        random = new Random();
        responses = new ArrayList<>();
        answersMap = new HashMap<>();
        words = new HashSet<> ();
        
       fillResponse();
       fillResponseMap();
    }

    /**
     * Generate a default response.
     * @return  The default response.
     */
    public String generateResponse()
    {
      int index = random.nextInt(responses.size()); 
      return responses.get(index);
    }
    /**
     * Generate a response according to the inserted set of Strings. 
     * @return The response.
     * @param words The inserted data by the user. The inserted data will be 
     * split into the substrings.
     */
    public String generateResponse(HashSet <String> words){
     for (String word : words){
        String answer = answersMap.get(word);
     if (answer != null){
        return answer;
        }
    }
       return generateResponse();
        }
    
    /**
     * The range of default responses when the programm does not know what to say.
     */
    public void fillResponse(){
      responses.add("Did you check the FAQ section on our website?");
      responses.add("Could you describe the problem more detailed, please?");
      responses.add("Did you try to restart the application and close other ones?");
      responses.add("You can ask this question on the forum of our website - \n" + 
      "you will get the help immediately.");
      responses.add("That sounds odd. Please, send us an email with a full  \n"
      + "description of your problem!");
    }
    
    /**
     * The range of responses that are printed out according to the inserted String.
     */
    public void fillResponseMap(){
    answersMap.put("slow","Probably, our app is not compatible \n" +
    "with the OS of your PC.");
    
    answersMap.put("call","We understand your frustration. Unfortunately, \n" + 
    "the phone call assistance is not supported. However, you can provide the \n" + 
    "following information about your problem in the email.");
    
    answersMap.put("refund", "I am sorry to hear you are not happy with our app. \n" +
    "As we can not give you a refund (more details in terms and conditions), \n" +
    "I would glad to offer you an alternative. \n" + 
    "Please, send us an email with a refund object.");
    
    answersMap.put("install","Probably, you have forgotten to insert \n" + 
    "the password while app installation. Check your email with an access object.");
    answersMap.put("download", "For downloading our app on your device \n" + 
    "make sure you have enough space on it.");
    
    }
}
