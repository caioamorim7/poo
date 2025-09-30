abstract class Report {
    private final String name;

    protected Report(String name) {
        this.name = name;
    }

    protected String header() {
        return "Report " + name;
    }

    protected abstract String body();

    public void print() {
        System.out.println(header() + ":" + body());
    }
}

class DailyReport extends Report {
    DailyReport() {
        super("Daily");
    }

    @Override
    protected String body() {
        return "OK";
    }
}

public class Q10 {
    public static void main(String[] args) {
        Report report = new DailyReport();
        report.print();
    }
}
