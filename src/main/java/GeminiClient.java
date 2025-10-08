import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeminiClient {

    String apiKey = "";
    String endPoint = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + apiKey;

    public void sendRequest() throws Exception {
        // Create a JSON string that represents the request payload including your question
        String jsonPayload = "{\n" +
                "  \"contents\": [\n" +
                "    {\n" +
                "      \"parts\": [\n" +
                "        {\n" +
                "          \"text\": \"Give me a random quiz question about general knowledge. The question should be a string, the options should be an array of four strings, and the answer should be the single correct string from the options.\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"generationConfig\": {\n" +
                "    \"responseMimeType\": \"application/json\",\n" +
                "    \"responseSchema\": {\n" +
                "      \"type\": \"OBJECT\",\n" +
                "      \"properties\": {\n" +
                "        \"question\": { \"type\": \"STRING\" },\n" +
                "        \"options\": {\n" +
                "          \"type\": \"ARRAY\",\n" +
                "          \"items\": { \"type\": \"STRING\" }\n" +
                "        },\n" +
                "        \"answer\": { \"type\": \"STRING\" }\n" +
                "      },\n" +
                "      \"required\": [\"question\", \"options\", \"answer\"]\n" +
                "    }\n" +
                "  }\n" +
                "}";
        // Build the HTTP client
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endPoint))
                .header("Content-Type", "application/json")//This line is needed so that the server knows what type of data ex:json to send in the body.
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBodyString = response.body();

//        System.out.println("Status code: " + response.statusCode()); // Coded this for testing purposes not needed anymore. Just prints the API response.
//        System.out.println("Response: " + response.body());

        GeminiResponseParser geminiResponseParser = new GeminiResponseParser();
        geminiResponseParser.parseResponse(responseBodyString);
    }
}
