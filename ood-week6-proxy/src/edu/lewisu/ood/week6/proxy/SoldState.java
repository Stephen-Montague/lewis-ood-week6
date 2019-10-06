package edu.lewisu.ood.week6.proxy;

public class SoldState implements State {
	private static final long serialVersionUID = 2L;
	transient TicketMachine ticketMachine;
 
    public SoldState(TicketMachine ticketMachine) {
        this.ticketMachine = ticketMachine;
    }
       
	public void prepPayment() {
		System.out.println("Please wait while we issue the ticket");
	}
 
	public void cancelPayment() {
		System.out.println("Ticket sold. To make changes, please take your ticket to the clerk.");
	}
 
	public void makePayment() {
		System.out.println("The payment has already been processed.");
	}
 
	public void issueTicket() {
		ticketMachine.printTicket();
		if (ticketMachine.getNumSeats() > 0) {
			System.out.println("Successful");
			ticketMachine.setState(ticketMachine.getNoPaymentState());
		} else {
			System.out.println("Successful - all seats now filled\n");
			ticketMachine.setState(ticketMachine.getSoldOutState());
		}
	}
	
	public void reset() { }
 
	public String toString() {
		return "printing a ticket";
	}
}


