public class Q01 {
    public static void main(String[] args) {
        var version = Runtime.version();
        var vmName = System.getProperty("java.vm.name");
        int space = vmName.indexOf(' ');
        String tag = space > 0 ? vmName.substring(0, space) : vmName;
        System.out.println(tag + "-" + version.feature());
    }
}
