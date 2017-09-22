package pl.blazejolesiak.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "titlepage")
public class TitleModel {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    private String name;
    private String specialization;

    public TitleModel() {
    }

    public TitleModel(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
