package ObserverPattern.Observer;

public class NewsSubscriber implements Subscriber {
    private final String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }

    @Override
    public String getName() {
        return name;
    }
}
