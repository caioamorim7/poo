class Session {
    private static int counter = 0;
    private final int id = ++counter;

    static void reset(int base) {
        counter = base;
    }

    int getId() {
        return id;
    }

    static int current() {
        return counter;
    }
}

public class Q07 {
    public static void main(String[] args) {
        Session.reset(200);
        Session first = new Session();
        Session second = new Session();
        System.out.println(first.getId() + ":" + second.getId() + ":" + Session.current());
    }
}
