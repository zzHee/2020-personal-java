import org.apache.commons.cli.*;

public class ProcessOptions {
//    public static Options generateOp() {
//        final Options options = new Options();
//        options.addOption(new Option("help", "help", false, "command help"));
//        options.addOption(new Option("i", "init", false, "get the file path"));
//        options.addOption(new Option("u", "user", true, "get the user name"));
//        options.addOption(new Option("e", "event", true, "type of event"));
//        options.addOption(new Option("r", "repo", true, "name of repo"));
//        return options;
//    }
//
//    public static void testOptions(String[] args) {
//        Options options = new Options();
//        Option opt = new Option("h", "help", false, "Print help");
//        opt.setRequired(false);
//        options.addOption(opt);
//
//        opt = new Option("c", "configFile", true, "Name server config properties file");
//        opt.setRequired(false);
//        options.addOption(opt);
//
//        opt = new Option("p", "printConfigItem", false, "Print all config item");
//        opt.setRequired(false);
//        options.addOption(opt);
//
//        HelpFormatter hf = new HelpFormatter();
//        hf.setWidth(110);
//        CommandLine commandLine = null;
//        CommandLineParser parser = new DefaultParser();
//        try {
//            commandLine = parser.parse(options, args);
//            if (commandLine.hasOption('h')) {
//                // 打印使用帮助
//                hf.printHelp("None", options, true);
//            }
//            if (commandLine.hasOption('c')) {
//                System.out.println("hasc");
//            }
//            // 打印opts的名称和值
//            System.out.println("--------------------------------------");
//            Option[] opts = commandLine.getOptions();
//            if (opts != null) {
//                for (Option opt1 : opts) {
//                    String name = opt1.getLongOpt();
//                    String value = commandLine.getOptionValue(name);
//                    System.out.println(name + "=>" + value);
//                }
//            }
//        }
//        catch (ParseException e) {
//            hf.printHelp("None", options, true);
//        }
//    }
}
