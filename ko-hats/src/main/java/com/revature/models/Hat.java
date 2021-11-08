package com.revature.models;

import java.util.Objects;

public class Hat {
	
	private int id;
	private String type;
	private int price;
	private String color;
	private String size;
	private Customer ownedBy;

	public Hat() {
		super();
	}

	public Hat(int id, String type, int price, String color, String size, Customer ownedBy) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
		this.color = color;
		this.size = size;
		this.ownedBy = ownedBy;
	}

	


	public Hat(int id, String type, int price, String color, String size, int ownedById) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
		this.color = color;
		this.size = size;
	}

	public Hat(int id) {
		super();
		this.id = id;
	}

	public Hat(String type, int price, String color, String size) {
		super();
		this.type = type;
		this.price = price;
		this.color = color;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Customer getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(Customer ownedBy) {
		this.ownedBy = ownedBy;
	}
	public int getOwnedById() {
		return ownedBy.getId();
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, id, ownedBy, price, size, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hat other = (Hat) obj;
		return Objects.equals(color, other.color) && id == other.id && Objects.equals(ownedBy, other.ownedBy)
				&& price == other.price && Objects.equals(size, other.size) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Hat [id=" + id + ", type=" + type + ", price=" + price + ", color=" + color + ", size=" + size
				+ ", ownedBy=" + ownedBy + "]";
	}
	

	
	


	
	
	

}