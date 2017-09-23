package net.twasi.core;

import net.twasi.core.cli.CommandLineInterface;
import net.twasi.core.config.Config;
import net.twasi.core.interfaces.Interface;
import net.twasi.core.logger.TwasiLogger;
import net.twasi.core.plugin.Plugin;

public class Main {

    private static CommandLineInterface cli = new CommandLineInterface();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        TwasiLogger.log.info("Starting Twasi Core");

        TwasiLogger.log.debug("Reading config");
        Config.load();

        TwasiLogger.log.debug("Loading interfaces");
        Interface.load();

        TwasiLogger.log.debug("Loading plugins");
        Plugin.load();

        float time = System.currentTimeMillis() - start;
        double longTime = time / 1000;
        TwasiLogger.log.info("Twasi ready. Started in " + longTime + " seconds.");

        cli.start();
    }

}