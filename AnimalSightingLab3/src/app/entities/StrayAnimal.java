package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class StrayAnimal {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
    @Pattern(regexp = "^(cat|dog)$", message = "Type can only be 'cat' or 'dog'")
    private String type;

    @Column
    @NotNull
    private String color;

    @Column
    @NotNull
    private Boolean neutered;

    @Column
    @NotNull
    @Size(max = 50, message = "Description cannot exceed 50 characters")
    private String description;
	
	public StrayAnimal() {

	}
	
	public StrayAnimal(String type, String color, Boolean neutered, String description) {
		this.type = type;
		this.color = color;
		this.neutered = neutered;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getNeutered() {
		return neutered;
	}

	public void setNeutered(Boolean neutered) {
		this.neutered = neutered;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
