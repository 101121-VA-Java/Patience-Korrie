package com.revature.models;

import java.util.Objects;

public class Reimb {
	private int id;
	private double amount;
	private String submitted;
	private String resolved;
	private String description;
	private String recipt;
	private Users author;
	private Users resolver;
	private Status status;
	private Type type;
	
	
	public Reimb() {
		super();
	}


	public Reimb(int id, double amount, String submitted, String resolved, String description, String recipt,
			Users author, Users resolver, Status status, Type type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.recipt = recipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}


	public Reimb(int id, double amount, String submitted, String description, Users author, Status status, Type type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.author = author;
		this.status = status;
		this.type = type;
	}



	


	public Reimb(int id, double amount, String submitted, int status,  int type, String description, int author) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
	
		
	}





	public Reimb(int id, double amount, String submitted, int status, String description, int authorId,
			int type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		}


	public Reimb(int id, double amount, String submitted, String resolved, String description, int resolverId,
			int type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
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


	public String getSubmitted() {
		return submitted;
	}


	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}


	public String getResolved() {
		return resolved;
	}


	public void setResolved(String resolved) {
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


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, id, recipt, resolved, resolver, status, submitted, type);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimb other = (Reimb) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(author, other.author) && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(recipt, other.recipt) && Objects.equals(resolved, other.resolved)
				&& Objects.equals(resolver, other.resolver) && Objects.equals(status, other.status)
				&& Objects.equals(submitted, other.submitted) && Objects.equals(type, other.type);
	}


	@Override
	public String toString() {
		return "Reimb [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", recipt=" + recipt + ", author=" + author + ", resolver="
				+ resolver + ", status=" + status + ", type=" + type + "]";
	}

	

}