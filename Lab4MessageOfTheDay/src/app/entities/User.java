package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long pk;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "cellphone_number", nullable = false, unique = false, length = 15)
    private String cellphoneNumber;

    // Constructors
    public User() {}

    public User(String name, String cellphoneNumber) {
        this.name = name;
        this.cellphoneNumber = cellphoneNumber;
    }

    // Getters and Setters
    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }
}