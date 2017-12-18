package cz.o2.vs.cdb.stb;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "ImageStb.findAll", query = "select o from ImageStb o") })
@Table(name = "\"image_stb\"")
public class ImageStb implements Serializable {
    @Id
    @Column(nullable = false)
    private int id;
    private String name;
    @OneToMany(mappedBy = "imageStb", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Stb> imageStbList1;
    @OneToMany(mappedBy = "imageStb1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<RegisterFw> registerFwList;

    public ImageStb() {
    }

    public ImageStb(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Stb> getImageStbList1() {
        return imageStbList1;
    }

    public void setImageStbList1(List<Stb> imageStbList1) {
        this.imageStbList1 = imageStbList1;
    }

    public Stb addStb(Stb stb) {
        getImageStbList1().add(stb);
        stb.setImageStb(this);
        return stb;
    }

    public Stb removeStb(Stb stb) {
        getImageStbList1().remove(stb);
        stb.setImageStb(null);
        return stb;
    }

    public List<RegisterFw> getRegisterFwList() {
        return registerFwList;
    }

    public void setRegisterFwList(List<RegisterFw> registerFwList) {
        this.registerFwList = registerFwList;
    }

    public RegisterFw addRegisterFw(RegisterFw registerFw) {
        getRegisterFwList().add(registerFw);
        registerFw.setImageStb1(this);
        return registerFw;
    }

    public RegisterFw removeRegisterFw(RegisterFw registerFw) {
        getRegisterFwList().remove(registerFw);
        registerFw.setImageStb1(null);
        return registerFw;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("id=");
        buffer.append(getId());
        buffer.append(',');
        buffer.append("name=");
        buffer.append(getName());
        buffer.append(',');
        buffer.append(']');
        return buffer.toString();
    }
}
