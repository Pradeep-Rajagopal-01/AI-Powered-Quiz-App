public class QuizApp {

    public static void main(String[] args) {
        GeminiResponseParser geminiResponseParser =new GeminiResponseParser();
        try {
            geminiResponseParser.sendRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
