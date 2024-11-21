package app.components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PetItemDto 
{
	private Long pk;
	private String type;  // food, toy, accessory
	private Double price;
	private String brand;
	private String description;
	private int quantity;
	private Boolean discounted;
	
	
	
	public Long getPk() {
		return pk;
	}
	public void setPk(Long pk) {
		this.pk = pk;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Boolean getDiscounted() {
		return discounted;
	}
	public void setDiscounted(Boolean discounted) {
		this.discounted = discounted;
	}
	@Override
	public String toString() {
		return "PetItemDto [pk=" + pk + ", type=" + type + ", price=" + price + ", brand=" + brand + ", description="
				+ description + ", quantity=" + quantity + ", discounted=" + discounted + "]";
	}
	
	
	
	
	
	
}
