/**
 * Created by ian on 7/16/17.
 */
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

    public class Cli {
        private static final Logger log = Logger.getLogger(Cli.class.getName());
        private String[] args = null;
        private Options options = new Options();

        public Cli(String[] args) {

            this.args = args;

            options.addOption("h", "help", false, "show help.");
            options.addOption("off", "turnOff", false, "Turn off the TV .");
            options.addOption("on", "turnON", false, "Turn on the TV. experimental");
            options.addOption("message", "showMessage", true, "Show a message on the TV.");
            options.addOption("input", "switchInput", true, "Switch the input of the TV to something else.");

        }

        public void parse() {
            CommandLineParser parser = new DefaultParser();

            CommandLine cmd = null;
            try {
                cmd = parser.parse(options, args);

                if (cmd.hasOption("h"))
                    help();

                if (cmd.hasOption("off")) {
                    //log.log(Level.INFO, "Using cli argument -off=" + cmd.getOptionValue("v"));
                    TV.turnOff();
                } else {
                }

                if (cmd.hasOption("on")) {
                    TV.WakeOnLan("192.168.1.255", "A0:6F:AA:5F:27:D4");
                }

                if (cmd.hasOption("message")){
                    log.log(Level.INFO, "Using cli argument -message=" + cmd.getOptionValue("message"));
                    boolean test3 = TV.showFloat(cmd.getOptionValue("message"));
                }

                if (cmd.hasOption("input")){
                    log.log(Level.INFO, "Using cli argument -input=" + cmd.getOptionValue("input"));
                    boolean test = TV.switchInput(cmd.getOptionValue("input"));
                }

            } catch (ParseException e) {
                log.log(Level.SEVERE, "Failed to parse comand line properties", e);
                help();
            }
        }

        private void help() {
            // This prints out some help
            HelpFormatter formater = new HelpFormatter();

            formater.printHelp("Main", options);
            System.exit(0);
        }
    }

