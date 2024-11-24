package ObserverPattern.Subject;

import ObserverPattern.Observer.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BreakingNewsAgency implements NewsAgency {
    private final List<Subscriber> subscribers;
    private final List<String> breakingNews;
    private boolean running;
    private Thread randomNewsThread;

    public BreakingNewsAgency() {
        this.subscribers = new ArrayList<>();
        this.breakingNews = new ArrayList<>();
        this.running = false;

        breakingNews.add("Major earthquake shakes the city.");
        breakingNews.add("New tech breakthrough in AI!");
        breakingNews.add("Global stock markets surge.");
        breakingNews.add("Severe weather warnings issued.");
        breakingNews.add("Celebrity announces surprise retirement.");
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
            System.out.println(subscriber.getName() + " subscribed to Breaking News.");

            if (!running) {
                startRandomNewsPublishing();
            }
        }
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        if (subscribers.remove(subscriber)) {
            System.out.println(subscriber.getName() + " unsubscribed from Breaking News.");

            if (subscribers.isEmpty()) {
                stopNotifying();
            }
        }
    }

    @Override
    public void startRandomNewsPublishing() {
        running = true;

        randomNewsThread = new Thread(() -> {
            Random random = new Random();

            while (running) {
                try {
                    // Wait for a random time between 5 to 10 seconds
                    int delay = 5000 + random.nextInt(5000);
                    Thread.sleep(delay);

                    if (!subscribers.isEmpty()) {
                        // Randomly pick and publish breaking news
                        String news = breakingNews.get(random.nextInt(breakingNews.size()));
                        System.out.println("\nBreaking News Published: " + news);
                        for (Subscriber subscriber : subscribers) {
                            subscriber.update(news);
                        }
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Random news publishing thread interrupted.");
                }
            }
        });

        randomNewsThread.setDaemon(true); // Mark thread as daemon
        randomNewsThread.start();
    }

    @Override
    public void stopNotifying() {
        running = false;
        if (randomNewsThread != null && randomNewsThread.isAlive()) {
            randomNewsThread.interrupt();
        }
        System.out.println("Random news publishing stopped. No active subscribers.");
    }
}
