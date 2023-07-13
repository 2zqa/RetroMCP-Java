package org.mcphackers.mcp.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.mcphackers.mcp.MCP;

public class MainCLI extends MCP {
	private static final Ansi LOGO = new Ansi().fgCyan().a("  _____      _             ").fgYellow().a("__  __  _____ _____").a('\n').fgCyan().a(" |  __ \\    | |           ").fgYellow().a("|  \\/  |/ ____|  __ \\").a('\n').fgCyan().a(" | |__) |___| |_ _ __ ___ ").fgYellow().a("| \\  / | |    | |__) |").a('\n').fgCyan().a(" |  _  // _ \\ __| '__/ _ \\").fgYellow().a("| |\\/| | |    |  ___/").a('\n').fgCyan().a(" | | \\ \\  __/ |_| | | (_) ").fgYellow().a("| |  | | |____| |").a('\n').fgCyan().a(" |_|  \\_\\___|\\__|_|  \\___/").fgYellow().a("|_|  |_|\\_____|_|").a('\n').fgDefault();

	public static void main(String[] args) {
		AnsiConsole.systemInstall();
		System.out.println(LOGO.toString());

		MainCLI mcp = new MainCLI();
		mcp.initializeMCP();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String prompt = new Ansi().fgCyan().a("> ").toString();
		while (true) {
			try {
				System.out.print(prompt);
				String line = reader.readLine();
				if ("exit".equalsIgnoreCase(line)) {
					System.exit(0);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
