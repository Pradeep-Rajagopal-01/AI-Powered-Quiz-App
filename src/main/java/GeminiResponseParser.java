import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Scanner;

public class GeminiResponseParser {

    public void parseResponse(String responseBodyString){

        JsonObject fullResponse = JsonParser.parseString(responseBodyString).getAsJsonObject();
        JsonObject candidate = fullResponse.getAsJsonArray("candidates").get(0).getAsJsonObject();
        JsonObject content = candidate.getAsJsonObject("content");
        JsonElement textElement = content.getAsJsonArray("parts").get(0).getAsJsonObject().get("text");

        String quizJsonString = textElement.getAsString();

        JsonObject quizData = JsonParser.parseString(quizJsonString).getAsJsonObject();

        String question = quizData.get("question").getAsString();
        JsonArray optionsArray = quizData.get("options").getAsJsonArray();
        String answer = quizData.get("answer").getAsString().toLowerCase().replace(" ","");
//        answer = answer.toLowerCase();

        System.out.println("Question: " + question);
//        System.out.println("Correct Answer: " + answer);
        System.out.print("Options: ");
        for (JsonElement option : optionsArray) {
            System.out.print(option.getAsString() + ", ");
        }

        Scanner sc = new Scanner(System.in);
        String userAnswer = sc.next().toLowerCase();
        if (userAnswer.equals(answer)){
            System.out.println("Your Answer Is Correct");
            QuizApp.pointsTracker++;
            System.out.println("Current Score : " + QuizApp.pointsTracker);
        }else {
            System.out.println("Wrong Answer");
        }
    }
}
