package cz.o2.vs.cdb.stb;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "History1.findAll", query = "select o from History1 o") })
@Table(name = "\"history_1\"")
public class History1 implements Serializable {
    @Column(name = "DATE_UPDATE")
    private Timestamp dateUpdate;
    @Id
    @Column(nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "STB")
    private Stb imageStb;
    @ManyToOne
    @JoinColumn(name = "VERSION_FW")
    private RegisterFw registerFw1;

    public History1() {
    }

    public History1(Timestamp dateUpdate, int id, Stb imageStb, RegisterFw registerFw1) {
        this.dateUpdate = dateUpdate;
        this.id = id;
        this.imageStb = imageStb;
        this.registerFw1 = registerFw1;
    }


    public Timestamp getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Timestamp dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Stb getImageStb() {
        return imageStb;
    }

    public void setImageStb(Stb imageStb) {
        this.imageStb = imageStb;
    }

    public RegisterFw getRegisterFw1() {
        return registerFw1;
    }

    public void setRegisterFw1(RegisterFw registerFw1) {
        this.registerFw1 = registerFw1;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("dateUpdate=");
        buffer.append(getDateUpdate());
        buffer.append(',');
        buffer.append("id=");
        buffer.append(getId());
        buffer.append(',');
        buffer.append(']');
        return buffer.toString();
    }
}
