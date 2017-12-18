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
@NamedQueries({ @NamedQuery(name = "Category.findAll", query = "select o from Category o") })
@Table(name = "\"category\"")
public class Category implements Serializable {
    @Id
    @Column(nullable = false)
    private int id;
    private String type;
    @OneToMany(mappedBy = "category1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Stb> imageStbList2;
    @OneToMany(mappedBy = "category", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<RegisterFw> registerFwList2;

    public Category() {
    }

    public Category(int id, String type) {
        this.id = id;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Stb> getImageStbList2() {
        return imageStbList2;
    }

    public void setImageStbList2(List<Stb> imageStbList2) {
        this.imageStbList2 = imageStbList2;
    }

    public Stb addStb(Stb stb) {
        getImageStbList2().add(stb);
        stb.setCategory1(this);
        return stb;
    }

    public Stb removeStb(Stb stb) {
        getImageStbList2().remove(stb);
        stb.setCategory1(null);
        return stb;
    }

    public List<RegisterFw> getRegisterFwList2() {
        return registerFwList2;
    }

    public void setRegisterFwList2(List<RegisterFw> registerFwList2) {
        this.registerFwList2 = registerFwList2;
    }

    public RegisterFw addRegisterFw(RegisterFw registerFw) {
        getRegisterFwList2().add(registerFw);
        registerFw.setCategory(this);
        return registerFw;
    }

    public RegisterFw removeRegisterFw(RegisterFw registerFw) {
        getRegisterFwList2().remove(registerFw);
        registerFw.setCategory(null);
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
        buffer.append("type=");
        buffer.append(getType());
        buffer.append(']');
        return buffer.toString();
    }
}
