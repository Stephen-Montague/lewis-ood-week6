package edu.lewisu.ood.week6.proxy;

public class SoldOutState implements State {
	private static final long serialVersionUID = 2L;
	transient TicketMachine ticketMachine;
 
    public SoldOutState(TicketMachine ticketMachine) {
        this.ticketMachine = ticketMachine;
    }
 
	public void prepPayment() {
		System.out.println("Cannot prepare payment, all seats filled");
	}
 
	public void cancelPayment() {
		System.out.println("No payment to cancel");
	}
 
	public void makePayment() {
		System.out.println("Payment attempted, but no seats available");
	}
 
	public void issueTicket() {
		System.out.println("No ticket to print");
	}
	
	public void reset() { 
		ticketMachine.setState(ticketMachine.getNoPaymentState());
	}
 
	public String toString() {
		return "sold out";
	}
}
