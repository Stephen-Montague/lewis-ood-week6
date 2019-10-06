package edu.lewisu.ood.week6.proxy;

import java.rmi.RemoteException;

public class TicketMachineMonitor {
	TicketMachineRemote machine;

	public TicketMachineMonitor(TicketMachineRemote machine) {
		this.machine = machine;
	}

	public void report() {
		try {
			System.out.println("Ticket Machine: " + machine.getLocation());
			System.out.println("Seats available: " + machine.getNumSeats());
			System.out.println("Current state: " + machine.getState());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}