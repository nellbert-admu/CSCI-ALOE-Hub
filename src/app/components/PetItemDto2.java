package app.components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PetItemDto2 
{
	private Long pk;
	
	
	
	public Long getPk() {
		return pk;
	}
	public void setPk(Long pk) {
		this.pk = pk;
	}
	@Override
	public String toString() {
		return "PetItemDto2 [pk=" + pk + "]";
	}
	
	
	
}
