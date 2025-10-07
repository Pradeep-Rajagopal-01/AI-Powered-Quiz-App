import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class QuizApp {

//    String apiKey = "";
//    String endPoint = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + apiKey;
//
//    //String question = "Give me a random quiz question and its answer in JSON format. The JSON should have three keys: 'question', 'options', and 'answer'. The 'options' key should have a value of an array of four strings, and the 'answer' key should have a value of a string that is one of the options. Do not include any text before or after the JSON.";
//
//    public void sendRequest() throws Exception {
//        // Create a JSON string that represents the request payload including your question
//        String jsonPayload = "{\n" +
//                "  \"contents\": [\n" +
//                "    {\n" +
//                "      \"parts\": [\n" +
//                "        {\n" +
//                "          \"text\": \"Give me a random quiz question about general knowledge. The question should be a string, the options should be an array of four strings, and the answer should be the single correct string from the options.\"\n" +
//                "        }\n" +
//                "      ]\n" +
//                "    }\n" +
//                "  ],\n" +
//                "  \"generationConfig\": {\n" +
//                "    \"responseMimeType\": \"application/json\",\n" +
//                "    \"responseSchema\": {\n" +
//                "      \"type\": \"OBJECT\",\n" +
//                "      \"properties\": {\n" +
//                "        \"question\": { \"type\": \"STRING\" },\n" +
//                "        \"options\": {\n" +
//                "          \"type\": \"ARRAY\",\n" +
//                "          \"items\": { \"type\": \"STRING\" }\n" +
//                "        },\n" +
//                "        \"answer\": { \"type\": \"STRING\" }\n" +
//                "      },\n" +
//                "      \"required\": [\"question\", \"options\", \"answer\"]\n" +
//                "    }\n" +
//                "  }\n" +
//                "}";
//        // Build the HTTP client
//        HttpClient client = HttpClient.newHttpClient();
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(endPoint))
//                .header("Content-Type", "application/json")//This line is needed so that the server knows what type of data ex:json to send in the body.
//                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
//                .build();
//
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        String responseBodyString = response.body();
//
//        System.out.println("Status code: " + response.statusCode());
//        System.out.println("Response: " + response.body());
//
//        GeminiResponseParser geminiResponseParser = new GeminiResponseParser();
//        geminiResponseParser.parseResponse(responseBodyString);

//        JsonObject fullResponse = JsonParser.parseString(responseBodyString).getAsJsonObject();
//        JsonObject candidate = fullResponse.getAsJsonArray("candidates").get(0).getAsJsonObject();
//        JsonObject content = candidate.getAsJsonObject("content");
//        JsonElement textElement = content.getAsJsonArray("parts").get(0).getAsJsonObject().get("text");
//
//        String quizJsonString = textElement.getAsString();
//
//        JsonObject quizData = JsonParser.parseString(quizJsonString).getAsJsonObject();
//
//        String question = quizData.get("question").getAsString();
//        JsonArray optionsArray = quizData.get("options").getAsJsonArray();
//        String answer = quizData.get("answer").getAsString();
//        answer = answer.toLowerCase();
//
//        System.out.println("Question: " + question);
//        System.out.println("Correct Answer: " + answer);
//        System.out.print("Options: ");
//        for (JsonElement option : optionsArray) {
//            System.out.print(option.getAsString() + ", ");
//        }
//        System.out.println();

//        Scanner sc = new Scanner(System.in);
//        String userAnswer = sc.next().toLowerCase();
//        if (userAnswer.equals(answer)){
//            System.out.println("Your answer is correct");
//        }else {
//            System.out.println("Wrong Answer");
//        }


    public static void main(String[] args) {
        GeminiClient geminiClient = new GeminiClient();
        for (int i = 0; i < 2; i++) {
            try {
                geminiClient.sendRequest();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

