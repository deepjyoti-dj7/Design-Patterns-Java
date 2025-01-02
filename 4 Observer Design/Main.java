import java.util.*;

interface ISubscriber {
    void notify(String message);
}

class User implements ISubscriber {
    private int userId;

    public User(int userId) {
        this.userId = userId;
    }

    @Override
    public void notify(String message) {
        System.out.println("User " + userId + " received message: " + message);
    }
}

class Group {
    private List<ISubscriber> users;

    public Group() {
        users = new ArrayList<>();
    }

    public void subscribe(ISubscriber user) {
        users.add(user);
    }

    public void unsubscribe(ISubscriber user) {
        users.remove(user);
    }

    public void notify(String message) {
        for (ISubscriber user : users) {
            user.notify(message);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Group group = new Group();

        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);

        group.subscribe(user1);
        group.subscribe(user2);
        group.subscribe(user3);

        group.notify("new msg");
        group.unsubscribe(user1);
        group.notify("new msg again");
    }
}