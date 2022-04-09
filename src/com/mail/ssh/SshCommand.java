package com.mail.ssh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.mail.sha6.SHA6Encryption;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class SshCommand {

	public SshCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void CreationCompteLinux(String user,String pass)
	{
		String hostname = "192.168.56.128";
		String username = "root";
		String password = "123456";

		try
		{
			/* Create a connection instance */

			Connection conn = new Connection(hostname);

			/* Now connect */

			conn.connect();

			/* Authenticate.
			 * If you get an IOException saying something like
			 * "Authentication method password not supported by the server at this stage."
			 * then please check the FAQ.
			 */

			boolean isAuthenticated = conn.authenticateWithPassword(username, password);

			if (isAuthenticated == false)
				throw new IOException("Authentification annulée !.");

			/* Create a session */

			Session sess = conn.openSession();
			String commande = "useradd "+user+" -p "+pass;

			sess.execCommand(commande);
			//sess.execCommand("uname -a && date && uptime && who");

			System.out.println(commande);

			/* 
			 * This basic example does not handle stderr, which is sometimes dangerous
			 * (please read the FAQ).
			 */

			InputStream stdout = new StreamGobbler(sess.getStdout());

			BufferedReader br = new BufferedReader(new InputStreamReader(stdout));

			while (true)
			{
				String line = br.readLine();
				if (line == null)
				{
					br.close();
					break;
				}
				System.out.println(line);
			}

			/* Show exit status, if available (otherwise "null") */

			System.out.println("ExitCode: " + sess.getExitStatus());

			/* Close this session */

			sess.close();

			/* Close the connection */

			conn.close();

		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(2);
		}
	}
}


