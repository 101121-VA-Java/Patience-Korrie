package com.revature.models;

import java.util.Objects;

public class Hat {
	
	private int id;
	private String type;
	private int price;
	private String color;
	private int size;
//	private int numAvaliable;

	public Hat() {
		super();
	}

	public Hat(int id, String type, int price, String color, int size, int numAvaliable) {
		super();
		this.id = id;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Hat [id=" + id + ", type=" + type + ", price=" + price + ", color=" + color + ", size=" + size + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, id, price, size, type);
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
		return Objects.equals(color, other.color) && id == other.id && price == other.price && size == other.size
				&& Objects.equals(type, other.type);
	}
	
}
