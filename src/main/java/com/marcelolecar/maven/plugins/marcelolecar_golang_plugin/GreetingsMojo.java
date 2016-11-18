package com.marcelolecar.maven.plugins.marcelolecar_golang_plugin;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.codehaus.plexus.util.StringUtils;
import org.codehaus.plexus.util.cli.CommandLineException;
import org.codehaus.plexus.util.cli.CommandLineUtils;
import org.codehaus.plexus.util.cli.Commandline;

@Mojo(name = "sayhi")
public class GreetingsMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException {
        getLog().info("Hello, world.");

        String[] arguments = new String[] { "build" };

        Commandline commandline = new Commandline();
        commandline.setExecutable("go");
        commandline.addArguments(arguments);
        commandline.setWorkingDirectory(new File("/home/marcelolecar/dev/git/plataformas-eldorado/eldorado-renova-facil/src"));

        CommandLineUtils.StringStreamConsumer err = new CommandLineUtils.StringStreamConsumer();
        CommandLineUtils.StringStreamConsumer out = new CommandLineUtils.StringStreamConsumer();

        int exitCode;
        try {
            exitCode = CommandLineUtils.executeCommandLine(commandline, out, err);
        } catch (CommandLineException e) {
            e.printStackTrace();
        }

        String output = out.getOutput();
        if (!StringUtils.isEmpty(output)) {
            System.out.println(output);
        }

        String error = err.getOutput();
        if (!StringUtils.isEmpty(error)) {
            System.out.println(error);
        }
    }

    public static void main(String[] args) throws MojoExecutionException {
        new GreetingsMojo().execute();
    }

}
