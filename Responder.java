import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java. util.HashSet;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2016.02.29)
 */
public class Responder
{
    private Random random;
    private ArrayList <String> responses;
    private HashMap<String, String> answersMap;
    private HashSet<String> words;
    /**
     * Construct a Responder - nothing to do
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
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
      int index = random.nextInt(responses.size()); 
      return responses.get(index);
    }
    
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
     * The range of default responses when the programme does not know the answer.
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
     * The range of answers (values) and their keywords.
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
