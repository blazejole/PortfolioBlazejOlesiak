package pl.blazejolesiak.demo.models;

import javax.persistence.*;

@Entity
@Table(name ="aboutme")


public class AboutModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String aboutme;

    public AboutModel() {
    }

    public AboutModel( String aboutMe) {
        this.aboutme = aboutMe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }
}
