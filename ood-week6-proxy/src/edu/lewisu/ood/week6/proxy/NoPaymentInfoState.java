package edu.lewisu.ood.week6.proxy;

public class NoPaymentInfoState implements State {
	private static final long serialVersionUID = 2L;
	transient TicketMachine ticketMachine;
 
    public NoPaymentInfoState(TicketMachine ticketMachine) {
        this.ticketMachine = ticketMachine;
    }
 
	public void prepPayment() {
		System.out.println("Payment prepared");
		ticketMachine.setState(ticketMachine.getHasPaymentState());
	}
 
	public void cancelPayment() {
		System.out.println("Cannot cancel, payment not prepared yet");
	}
 
	public void makePayment() {
		System.out.println("Cannot make payment, payment not prepared yet");
	 }
 
	public void issueTicket() {
		System.out.println("Cannot issue ticket, awaiting payment");
	} 
	
	public void reset() { }
 
	public String toString() {
		return "waiting for payment";
	}
}
