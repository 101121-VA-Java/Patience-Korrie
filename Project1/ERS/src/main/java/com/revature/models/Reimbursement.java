package com.revature.models;

import java.util.Objects;

public class Reimbursement {
	private int id;
	private double amount;
	private boolean submitted;
	private boolean resolved;
	private String description;
	private String recipt;
	private Users author;
	private Users resolver;
	private Status status_Id;
	private Type type_Id;
	
	
	public Reimbursement() {
		super();
	}


	public Reimbursement(int id, double amount, boolean submitted, boolean resolved, String description, String recipt,
			Users author, Users resolver, Status status_Id, Type type_Id) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.recipt = recipt;
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


	public boolean isSubmitted() {
		return submitted;
	}


	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}


	public boolean isResolved() {
		return resolved;
	}


	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getRecipt() {
		return recipt;
	}


	public void setRecipt(String recipt) {
		this.recipt = recipt;
	}


	public Users getAuthor() {
		return author;
	}


	public void setAuthor(Users author) {
		this.author = author;
	}


	public Users getResolver() {
		return resolver;
	}


	public void setResolver(Users resolver) {
		this.resolver = resolver;
	}


	public Status getStatus_Id() {
		return status_Id;
	}


	public void setStatus_Id(Status status_Id) {
		this.status_Id = status_Id;
	}


	public Type getType_Id() {
		return type_Id;
	}


	public void setType_Id(Type type_Id) {
		this.type_Id = type_Id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, id, recipt, resolved, resolver, status_Id, submitted, type_Id);
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
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(author, other.author) && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(recipt, other.recipt) && resolved == other.resolved
				&& Objects.equals(resolver, other.resolver) && Objects.equals(status_Id, other.status_Id)
				&& submitted == other.submitted && Objects.equals(type_Id, other.type_Id);
	}


	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", recipt=" + recipt + ", author=" + author + ", resolver="
				+ resolver + ", status_Id=" + status_Id + ", type_Id=" + type_Id + "]";
	}
	
	

}