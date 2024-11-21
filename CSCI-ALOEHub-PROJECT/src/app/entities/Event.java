package app.entities;

import javax.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000) // Optional: Adjust length based on expected size of description
    private String description;

    @Column(nullable = false)
    private String date;  // Using String instead of Date

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String location;

    // Many-to-One relationship with Organization (one organization can have many events)
    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    // Default constructor
    public Event() {}

    // Constructor with parameters for easier creation
    public Event(String title, String description, String date, String time, String location, Organization organization) {
        this.title = title;
        this.description = description;
        this.date = date;  // Using String for date
        this.time = time;
        this.location = location;
        this.organization = organization;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}