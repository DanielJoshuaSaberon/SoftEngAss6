package ObserverPattern.Observer;

public interface Subscriber {
    void update(String news);
    String getName();
}
