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
@NamedQueries({ @NamedQuery(name = "Model.findAll", query = "select o from Model o") })
@Table(name = "\"model\"")
public class Model implements Serializable {
    private String fabricate;
    @Id
    @Column(nullable = false)
    private int id;
    private String name;
    @OneToMany(mappedBy = "model", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<RegisterFw> registerFwList1;

    public Model() {
    }

    public Model(String fabricate, int id, String name) {
        this.fabricate = fabricate;
        this.id = id;
        this.name = name;
    }


    public String getFabricate() {
        return fabricate;
    }

    public void setFabricate(String fabricate) {
        this.fabricate = fabricate;
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

    public List<RegisterFw> getRegisterFwList1() {
        return registerFwList1;
    }

    public void setRegisterFwList1(List<RegisterFw> registerFwList1) {
        this.registerFwList1 = registerFwList1;
    }

    public RegisterFw addRegisterFw(RegisterFw registerFw) {
        getRegisterFwList1().add(registerFw);
        registerFw.setModel(this);
        return registerFw;
    }

    public RegisterFw removeRegisterFw(RegisterFw registerFw) {
        getRegisterFwList1().remove(registerFw);
        registerFw.setModel(null);
        return registerFw;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("fabricate=");
        buffer.append(getFabricate());
        buffer.append(',');
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
