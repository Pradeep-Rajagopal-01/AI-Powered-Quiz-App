

public class QuizApp {

    public static int pointsTracker=0;
    public static void main(String[] args) {
        GeminiClient geminiClient = new GeminiClient();
        for (int i = 0; i < 2; i++) {
            try {
                geminiClient.sendRequest();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Your Final Score is : " + pointsTracker);
    }
}

