package ObserverPattern.Subject;

import ObserverPattern.Observer.Subscriber;

public interface NewsAgency {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void startRandomNewsPublishing();
    void stopNotifying();
}
