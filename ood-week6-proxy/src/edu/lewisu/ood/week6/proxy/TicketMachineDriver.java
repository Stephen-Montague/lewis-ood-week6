package edu.lewisu.ood.week6.proxy;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

/*
 * Stephen Montague
 * Object Oriented Development
 * Fall 2019 - Term 1
 * Week 6 - Proxy
 *
 * Summary:
 *     Demonstrates a Proxy Pattern using a remote Ticket Machine theme.
 *     Slightly mods remote Gumball-themed code from course textbook -
 *     Head First Design Patterns, by Freeman, et al., available from -
 *     https://www.wickedlysmart.com/head-first-design-patterns/
 *
 * Program Notes:
 *     Uses a Proxy Pattern to get status from a remote ticket machine.
 *
 *     Sample output:
 *     
 *     TicketMachine <location> <seats>
 */

public class TicketMachineDriver {

	public static void main(String[] args) {
		TicketMachineRemote ticketMachine = null;
		int seats;

// Tested to simulate running with arguments
//		args = new String[2];
//		args[0] = "localhost";
//		args[1] = "300";
		
		if (args.length < 2) {
			System.out.println("TicketMachine <location> <seats>");
			System.exit(1);
		}
		
		seats = Integer.parseInt(args[1]);
		
		try {
			ticketMachine = new TicketMachine(seats, args[0]);   
			Naming.rebind("//" + args[0] + "/ticketmachine", ticketMachine); 
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
