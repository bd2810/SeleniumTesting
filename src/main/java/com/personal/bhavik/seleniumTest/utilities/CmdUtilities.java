package com.personal.bhavik.seleniumTest.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcabi.ssh.Shell;

public class CmdUtilities {
	
	private final static Logger logger = LoggerFactory.getLogger(CmdUtilities.class);
	private static Shell shell;

	public void executeCommand(String[] command) {
		
		try {
			log(command.toString());
			Process process = Runtime.getRuntime().exec(command);
			logOutput(process.getInputStream(), "");
			logOutput(process.getErrorStream(), "Error: ");
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void logOutput(InputStream inputStream, String prefix) {
		new Thread(() -> {
			Scanner scanner = new Scanner(inputStream, "UTF-8");
			while (scanner.hasNextLine()) {
				synchronized (this) {
					log(prefix + scanner.nextLine());
				}
			}
			scanner.close();
		}).start();
	}

	private static SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss:SSS");

	private synchronized void log(String message) {
		System.out.println(format.format(new Date()) + ": " + message);
	}
	
    public static String exec(String cmd) {
        String stdout = "";
        try {
            stdout = new Shell.Plain(shell).exec(cmd);
            logger.info(stdout);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stdout;
    }

}
