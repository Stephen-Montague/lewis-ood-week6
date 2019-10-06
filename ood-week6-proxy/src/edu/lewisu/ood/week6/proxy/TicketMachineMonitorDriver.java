package edu.lewisu.ood.week6.proxy;

import java.rmi.Naming;

public class TicketMachineMonitorDriver {
	 
		public static void main(String[] args) {
			String[] location = {"rmi://newyork.ticketmachine.com/ticketmachine",
			                     "rmi://okc.ticketmachine.com/ticketmachine",
			                     "rmi://sanfran.ticketmachine.com/ticketmachine"}; 

// Tested to simulate run with arguments
//			args = new String[1];
//			args[0] = "localhost";
			
			if (args.length < 1) {
				System.out.println("Location required (e.g., 'localhost').");
				System.out.println("Please specify location and run again.");
				System.exit(1);
			}
			
			if (args.length >= 0)
	        {
	            location = new String[1];
	            location[0] = "rmi://" + args[0] + "/ticketmachine";
	        }
			
			TicketMachineMonitor[] monitor = new TicketMachineMonitor[location.length];
			
			for (int i=0;i < location.length; i++) {
				try {
	           		TicketMachineRemote machine = 
							(TicketMachineRemote) Naming.lookup(location[i]);
	           		monitor[i] = new TicketMachineMonitor(machine);
					System.out.println(monitor[i]);
	        	} catch (Exception e) {
	            	e.printStackTrace();
	        	}
			}
	 
			for(int i=0; i < monitor.length; i++) {
				monitor[i].report();
			}
		}
}


