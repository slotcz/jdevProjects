package cz.o2.vs.cdb.stb;

import java.io.Serializable;

import java.sql.Timestamp;

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
@NamedQueries({ @NamedQuery(name = "RegisterFw.findAll", query = "select o from RegisterFw o") })
@Table(name = "\"register_fw\"")
public class RegisterFw implements Serializable {
    @Column(name = "CODE_PATCH")
    private String codePatch;
    @Column(name = "DATE_FW")
    private Timestamp dateFw;
    @Id
    @Column(nullable = false)
    private int id;
    @Column(name = "MANUAL_PATH")
    private String manualPath;
    private String version;
    private Category category;
    private Model model;
    @OneToMany(mappedBy = "registerFw", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Stb> imageStbList;
    @OneToMany(mappedBy = "registerFw1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<History1> history1List1;
    @ManyToOne
    @JoinColumn(name = "IMG_TYPE")
    private ImageStb imageStb1;
    @OneToMany(mappedBy = "registerFw2", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<History> historyList1;

    public RegisterFw() {
    }

    public RegisterFw(Category category, String codePatch, Timestamp dateFw, int id, ImageStb imageStb1,
                      String manualPath, Model model, String version) {

        this.category = category;
        this.codePatch = codePatch;
        this.dateFw = dateFw;
        this.id = id;
        this.imageStb1 = imageStb1;
        this.manualPath = manualPath;
        this.model = model;
        this.version = version;
    }


    public String getCodePatch() {
        return codePatch;
    }

    public void setCodePatch(String codePatch) {
        this.codePatch = codePatch;
    }

    public Timestamp getDateFw() {
        return dateFw;
    }

    public void setDateFw(Timestamp dateFw) {
        this.dateFw = dateFw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getManualPath() {
        return manualPath;
    }

    public void setManualPath(String manualPath) {
        this.manualPath = manualPath;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Stb> getImageStbList() {
        return imageStbList;
    }

    public void setImageStbList(List<Stb> imageStbList) {
        this.imageStbList = imageStbList;
    }

    public Stb addStb(Stb stb) {
        getImageStbList().add(stb);
        stb.setRegisterFw(this);
        return stb;
    }

    public Stb removeStb(Stb stb) {
        getImageStbList().remove(stb);
        stb.setRegisterFw(null);
        return stb;
    }

    public List<History1> getHistory1List1() {
        return history1List1;
    }

    public void setHistory1List1(List<History1> history1List1) {
        this.history1List1 = history1List1;
    }

    public History1 addHistory1(History1 history1) {
        getHistory1List1().add(history1);
        history1.setRegisterFw1(this);
        return history1;
    }

    public History1 removeHistory1(History1 history1) {
        getHistory1List1().remove(history1);
        history1.setRegisterFw1(null);
        return history1;
    }

    public ImageStb getImageStb1() {
        return imageStb1;
    }

    public void setImageStb1(ImageStb imageStb1) {
        this.imageStb1 = imageStb1;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<History> getHistoryList1() {
        return historyList1;
    }

    public void setHistoryList1(List<History> historyList1) {
        this.historyList1 = historyList1;
    }

    public History addHistory(History history) {
        getHistoryList1().add(history);
        history.setRegisterFw2(this);
        return history;
    }

    public History removeHistory(History history) {
        getHistoryList1().remove(history);
        history.setRegisterFw2(null);
        return history;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("codePatch=");
        buffer.append(getCodePatch());
        buffer.append(',');
        buffer.append("dateFw=");
        buffer.append(getDateFw());
        buffer.append(',');
        buffer.append("id=");
        buffer.append(getId());
        buffer.append(',');
        buffer.append("manualPath=");
        buffer.append(getManualPath());
        buffer.append(',');
        buffer.append("version=");
        buffer.append(getVersion());
        buffer.append(']');
        return buffer.toString();
    }

}
