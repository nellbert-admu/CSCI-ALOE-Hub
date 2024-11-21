package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
    private Long id;

    @Column
    @NotNull
    private String locationName;  // Example: Faura, CTC, etc.

    @Column
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    private Double latitude;      // Latitude of the location

    @Column
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private Double longitude;  // Longitude of the location
    
	public Location() {

	}
	
	public Location(String locationName, Double latitude, Double longitude) {
		this.locationName = locationName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	

}
