package cz.o2.vs.cdb.stb;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Stb.findAll", query = "select o from Stb o") })
@Table(name = "\"stb\"")
public class Stb implements Serializable {
    @Id
    @Column(nullable = false)
    private int id;
    private String mac;
    @OneToMany(mappedBy = "imageStb", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<History1> history1List;
    @ManyToOne
    @JoinColumn(name = "VERSION_FW")
    private RegisterFw registerFw;
    @ManyToOne
    @JoinColumn(name = "IMAGE")
    private ImageStb imageStb;
    @OneToMany(mappedBy = "imageStb1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<History> historyList;
    @ManyToOne
    @JoinColumn(name = "CATEGORY")
    private Category category1;

    public Stb() {
    }

    public Stb(Category category1, int id, ImageStb imageStb, String mac, RegisterFw registerFw) {
        this.category1 = category1;
        this.id = id;
        this.imageStb = imageStb;
        this.mac = mac;
        this.registerFw = registerFw;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }


    public List<History1> getHistory1List() {
        return history1List;
    }

    public void setHistory1List(List<History1> history1List) {
        this.history1List = history1List;
    }

    public History1 addHistory1(History1 history1) {
        getHistory1List().add(history1);
        history1.setImageStb(this);
        return history1;
    }

    public History1 removeHistory1(History1 history1) {
        getHistory1List().remove(history1);
        history1.setImageStb(null);
        return history1;
    }

    public RegisterFw getRegisterFw() {
        return registerFw;
    }

    public void setRegisterFw(RegisterFw registerFw) {
        this.registerFw = registerFw;
    }

    public ImageStb getImageStb() {
        return imageStb;
    }

    public void setImageStb(ImageStb imageStb) {
        this.imageStb = imageStb;
    }

    public List<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
    }

    public History addHistory(History history) {
        getHistoryList().add(history);
        history.setImageStb1(this);
        return history;
    }

    public History removeHistory(History history) {
        getHistoryList().remove(history);
        history.setImageStb1(null);
        return history;
    }

    public Category getCategory1() {
        return category1;
    }

    public void setCategory1(Category category1) {
        this.category1 = category1;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("id=");
        buffer.append(getId());
        buffer.append(',');
        buffer.append("mac=");
        buffer.append(getMac());
        buffer.append(',');
        buffer.append(']');
        return buffer.toString();
    }
}
