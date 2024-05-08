import java.util.Scanner;

public class DiseaseConsultationChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = "";
        System.out.println("Hello, I am a disease consultation chatbot. What's your name?");
        String name = scanner.nextLine();
        System.out.println("Nice to meet you, " + name + "!");
        
        while (!message.equalsIgnoreCase("bye")) {
            System.out.println("Bot: How can I help you today?");
            System.out.println("1. I have symptoms and want to know what they might mean.");
            System.out.println("2. I have a medical condition and need advice on how to manage it.");
            System.out.print(name + ": ");
            message = scanner.nextLine();
            String response = "";

            switch (message) {
                case "1":
                    response = symptomChecker();
                    break;
                case "2":
                    response = conditionManagement();
                    break;
                default:
                    response = "I'm sorry, I don't understand. Can you please choose one of the options above?";
                    break;
            }
            System.out.println("Bot: " + response);
        }
        System.out.println("Goodbye, " + name + "!");
        scanner.close();
    }

    public static String symptomChecker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bot: What symptoms are you experiencing?");
        String symptoms = scanner.nextLine().toLowerCase();

        if (symptoms.contains("fever") && symptoms.contains("cough")) {
            return "You may have a respiratory infection such as the flu. Please rest and stay hydrated, and seek medical attention if your symptoms worsen or persist.";
        } else if (symptoms.contains("headache") && symptoms.contains("nausea")) {
            return "You may have a migraine. Please try to rest in a quiet and dark environment, and take an over-the-counter pain reliever if needed. If your symptoms persist or worsen, please seek medical attention.";
        } else if (symptoms.contains("chest pain") || symptoms.contains("shortness of breath")) {
            return "You may be having a heart attack. Please call emergency services immediately.";
        } else {
            return "I'm sorry, I'm unable to provide a diagnosis based on the symptoms you've provided. Please seek medical attention if your symptoms worsen or persist.";
        }
    }

    public static String conditionManagement() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bot: What medical condition do you need advice on managing?");
        String condition = scanner.nextLine().toLowerCase();
        switch (condition) {
            case "diabetes":
                return "To manage diabetes, it's important to maintain a healthy diet, exercise regularly, monitor your blood sugar levels, and take any medications or insulin as prescribed. Make sure to follow your doctor's recommendations and attend regular check-ups.";
            case "asthma":
                return "To manage asthma, it's important to avoid triggers such as cigarette smoke or air pollution, take any prescribed medications as directed, and monitor your symptoms regularly. Make sure to follow your doctor's recommendations and regular check-ups.";
            case "hypertension":
                return "To manage hypertension, it's important to maintain a healthy diet, exercise regularly, avoid smoking and excessive alcohol consumption, and take any prescribed medications as directed. Make sure to follow your doctor's recommendations and regular check-ups.";
            default:
                return "I'm sorry, I don't have specific advice on managing that medical condition. Please consult with your doctor for more information.";
        }
    }
}
