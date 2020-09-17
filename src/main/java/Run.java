import com.alibaba.fastjson.JSONObject;
import org.apache.commons.cli.*;

import java.io.IOException;

public class Run {
    private Data data;
    private Options options;
    public Run(String[] args) {
        data = new Data();
        options = argInit();
        data = analyse(args);
    }
    public Options argInit() {
        Options options = new Options();
        options.addOption("i", "init", true, "init");
        options.addOption("u", "user", true, "user");
        options.addOption("e", "event", true, "event");
        options.addOption("r", "repo", true, "repo");
        return options;
    }

    public Data analyse(String[] args) {
        CommandLine commandLine = null;
        CommandLineParser parser = new DefaultParser();
        try {
            commandLine = parser.parse(options, args);
            if (commandLine.hasOption('i')) {
                data.init(commandLine.getOptionValue('i'));
            }
            if (commandLine.hasOption('u') && commandLine.hasOption('e')) {
                if (commandLine.hasOption('r')) {
                    System.out.print(data.getUserEventsRepos(commandLine.getOptionValue('u')
                            , commandLine.getOptionValue('r'), commandLine.getOptionValue('e')));
                } else {
                    System.out.print(data.getEventUsers(commandLine.getOptionValue('u')
                            ,commandLine.getOptionValue('e')));
                }
            }
            if (commandLine.hasOption('r') && commandLine.hasOption('e')) {
                if (commandLine.hasOption('u')) {
                    System.out.print(data.getUserEventsRepos(commandLine.getOptionValue('u')
                            , commandLine.getOptionValue('r'), commandLine.getOptionValue('e')));
                } else {
                    System.out.print(data.getEventsRepos(commandLine.getOptionValue('r')
                            , commandLine.getOptionValue('e')));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }
}
