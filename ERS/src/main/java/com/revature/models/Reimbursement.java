package com.revature.models;

import java.util.Objects;

public class Reimbursement {
	private int id;
	private double amount;
	private int submitted;
	private String description;
	//private blob
	private int author;
	private int resolver;
	private int status_Id;
	private int type_Id;
	
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reimbursement(int id, double amount, int submitted, String description, int author, int resolver,
			int status_Id, int type_Id) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status_Id = status_Id;
		this.type_Id = type_Id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public int getSubmitted() {
		return submitted;
	}


	public void setSubmitted(int submitted) {
		this.submitted = submitted;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getAuthor() {
		return author;
	}


	public void setAuthor(int author) {
		this.author = author;
	}


	public int getResolver() {
		return resolver;
	}


	public void setResolver(int resolver) {
		this.resolver = resolver;
	}


	public int getStatus_Id() {
		return status_Id;
	}


	public void setStatus_Id(int status_Id) {
		this.status_Id = status_Id;
	}


	public int getType_Id() {
		return type_Id;
	}


	public void setType_Id(int type_Id) {
		this.type_Id = type_Id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, id, resolver, status_Id, submitted, type_Id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount) && author == other.author
				&& Objects.equals(description, other.description) && id == other.id && resolver == other.resolver
				&& status_Id == other.status_Id && submitted == other.submitted && type_Id == other.type_Id;
	}
	
	
	
}


