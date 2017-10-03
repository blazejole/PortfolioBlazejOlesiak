package pl.blazejolesiak.demo.models.portfolioModel;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "project")
public class ProjectModel {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String  projectname;
    private String projectdesc;
    private String imgurl;


    public ProjectModel() {
    }

    public ProjectModel(String projectname, String projectdesc, String imgurl) {
        this.projectname = projectname;
        this.projectdesc = projectdesc;
        this.imgurl = imgurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectdesc() {
        return projectdesc;
    }

    public void setProjectdesc(String projectdesc) {
        this.projectdesc = projectdesc;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
