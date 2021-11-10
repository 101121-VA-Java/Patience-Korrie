package com.revature.models;

import java.util.Objects;

public class Payments {
	protected int Id;
	protected int customerId;
	protected double payed;
	protected double remaining;
	
	
	
	public Payments(int id, int customerId, double payed, double remaining) {
		super();
		Id = id;
		this.customerId = customerId;
		this.payed = payed;
		this.remaining = remaining;
	}



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public double getPayed() {
		return payed;
	}



	public void setPayed(double payed) {
		this.payed = payed;
	}



	public double getRemaining() {
		return remaining;
	}



	public void setRemaining(double remaining) {
		this.remaining = remaining;
	}



	@Override
	public int hashCode() {
		return Objects.hash(Id, customerId, payed, remaining);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payments other = (Payments) obj;
		return Id == other.Id && customerId == other.customerId
				&& Double.doubleToLongBits(payed) == Double.doubleToLongBits(other.payed)
				&& Double.doubleToLongBits(remaining) == Double.doubleToLongBits(other.remaining);
	}



	@Override
	public String toString() {
		return "Payments [Id=" + Id + ", customerId=" + customerId + ", payed=" + payed + ", remaining=" + remaining
				+ "]";
	}
	
	
	
	
}
