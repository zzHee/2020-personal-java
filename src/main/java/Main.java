public class Main {
    public static void main(String[] args) {
        String[] arg = {"-i", "D:/"};
        Run run = new Run(arg);
        arg = new String[]{"-u", "rspt", "-e", "PushEvent"};
        run.analyse(arg);
        arg = new String[]{"-r", "izuzero/xe-module-ajaxboard", "-e", "PushEvent"};
        run.analyse(arg);
        arg = new String[]{"u", "zhouzhi2015", "-r", "zhouzhi2015/temp", "-e", "PushEvent"};
        run.analyse(arg);
//        System.out.println("Hello World");
//        Run run = new Run(args);
    }
}
