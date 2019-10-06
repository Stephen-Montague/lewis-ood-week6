package edu.lewisu.ood.week6.proxy;

//import java.util.Random;

public class HasPaymentInfoState implements State {
	private static final long serialVersionUID = 2L;
	transient TicketMachine ticketMachine;
 
	public HasPaymentInfoState(TicketMachine ticketMachine) {
		this.ticketMachine = ticketMachine;
	}
  
	public void prepPayment() {
		System.out.println("Cannot prepare payment again, payment already prepared");
	}
 
	public void cancelPayment() {
		System.out.println("Payment cancelled, as requested");
		ticketMachine.setState(ticketMachine.getNoPaymentState());
	}
 
	public void makePayment() {
		System.out.println("Payment made...");
		ticketMachine.setState(ticketMachine.getSoldState());
	}

    public void issueTicket() {
        System.out.println("No ticket printed");
    }
    
    public void reset() { }
 
	public String toString() {
		return "awaiting confirmation of payment details";
	}
}
