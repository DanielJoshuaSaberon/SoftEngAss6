package ObserverPattern;

import ObserverPattern.Observer.*;
import ObserverPattern.Subject.*;
import java.util.*;

public class NewsService {
    public static void main(String[] args) {
        BreakingNewsAgency alertSystem = new BreakingNewsAgency();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nOptions:");
            System.out.println("1: Subscribe to Breaking News");
            System.out.println("2: Unsubscribe from Breaking News");
            System.out.println("3: Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your name to subscribe: ");
                    String name = scanner.next();
                    NewsSubscriber subscriber = new NewsSubscriber(name);
                    alertSystem.subscribe(subscriber);
                    break;
                case 2:
                    System.out.print("Enter your name to unsubscribe: ");
                    name = scanner.next();
                    subscriber = new NewsSubscriber(name);
                    alertSystem.unsubscribe(subscriber);
                    break;
                case 3:
                    alertSystem.stopNotifying();
                    exit = true;
                    System.out.println("Exiting the Breaking News Service.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
