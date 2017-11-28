package cz.o2.stb.dm;

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
    private List<Stb> imageStbList1;
    @OneToMany(mappedBy = "category", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<RegisterFw> registerFwList;

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

    public List<Stb> getImageStbList1() {
        return imageStbList1;
    }

    public void setImageStbList1(List<Stb> imageStbList1) {
        this.imageStbList1 = imageStbList1;
    }

    public Stb addStb(Stb stb) {
        getImageStbList1().add(stb);
        stb.setCategory1(this);
        return stb;
    }

    public Stb removeStb(Stb stb) {
        getImageStbList1().remove(stb);
        stb.setCategory1(null);
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
        registerFw.setCategory(this);
        return registerFw;
    }

    public RegisterFw removeRegisterFw(RegisterFw registerFw) {
        getRegisterFwList().remove(registerFw);
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
