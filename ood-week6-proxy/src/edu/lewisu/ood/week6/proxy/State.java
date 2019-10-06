package edu.lewisu.ood.week6.proxy;

import java.io.Serializable;

public interface State extends Serializable {
 
	public void prepPayment();
	public void cancelPayment();
	public void makePayment();
	public void issueTicket();
	
	public void reset();
}
