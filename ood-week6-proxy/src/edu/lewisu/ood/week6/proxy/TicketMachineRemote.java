package edu.lewisu.ood.week6.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TicketMachineRemote extends Remote {
	public int getNumSeats() throws RemoteException;
	public String getLocation() throws RemoteException;
	public State getState() throws RemoteException;
}
