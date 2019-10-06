package edu.lewisu.ood.week6.proxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TicketMachine extends UnicastRemoteObject implements TicketMachineRemote {
 
	private static final long serialVersionUID = 2L;  
	State soldOutState;
	State noPaymentState;
	State hasPaymentState;
	State soldState;
 
	State state;
	int numSeats = 0;
	String location;
	String[] destinations = new String[]{"South Park","Springfield","Washington D.C."};	
	
	public TicketMachine(int numSeats, String location) throws RemoteException {
		soldOutState = new SoldOutState(this);
		noPaymentState = new NoPaymentInfoState(this);
		hasPaymentState = new HasPaymentInfoState(this);
		soldState = new SoldState(this);

		this.numSeats = numSeats;
 		if (numSeats > 0) {
			state = noPaymentState;
		} else {
			state = soldOutState;
		}
 		this.location = location;
	}
 
	public void prepPayment() {
		state.prepPayment();
	}
 
	public void cancelPayment() {
		state.cancelPayment();
	}
 
	public void makePayment() {
		state.makePayment();
		state.issueTicket();
	}
 
	public void printTicket() {
		System.out.println("Printing ticket to... " 
				+ destinations[(int)(Math.random()*destinations.length)]);
		if (numSeats != 0) {
			numSeats = numSeats - 1;
		}
	}
 
	public int getNumSeats() {
		return numSeats;
	}
 
	public void setNumSeats(int numSeats) {
		this.numSeats += numSeats;
		System.out.println("\nThe number of open seats is now: " + this.numSeats);
		state.reset();
	}

	public void setState(State state) {
		this.state = state;
	}
    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoPaymentState() {
        return noPaymentState;
    }

    public State getHasPaymentState() {
        return hasPaymentState;
    }

    public State getSoldState() {
        return soldState;
    }
 
    public String getLocation() {
    	return location;
    }

    public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nRandom Transporters, Inc.");
		result.append("\nNumber of seat(s): " + numSeats);
		result.append("\n");
		result.append("Ticket machine is " + state + "\n");
		return result.toString();
	}

}
