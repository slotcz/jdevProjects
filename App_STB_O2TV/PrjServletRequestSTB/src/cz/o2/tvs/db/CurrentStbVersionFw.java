package cz.o2.tvs.db;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "CurrentStbVersionFw.findAll", query = "select o from CurrentStbVersionFw o") })
@Table(name = "\"current_stb_version_fw\"")
public class CurrentStbVersionFw implements Serializable {
    private static final long serialVersionUID = 1465094391100213503L;
    private String category;
    private String image;
    private String mac;
    private String version;

    public CurrentStbVersionFw() {
    }

    public CurrentStbVersionFw(String category, String image, String mac, String version) {
        this.category = category;
        this.image = image;
        this.mac = mac;
        this.version = version;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
