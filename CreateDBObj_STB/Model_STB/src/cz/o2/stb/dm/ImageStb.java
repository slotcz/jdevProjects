package cz.o2.stb.dm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "ImageStb.findAll", query = "select o from ImageStb o") })
@Table(name = "\"image_stb\"")
public class ImageStb implements Serializable {
    private static final long serialVersionUID = 1178380713150933218L;
    @Id
    @Column(nullable = false)
    private int id;
    private String name;

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
        buffer.append(']');
        return buffer.toString();
    }
}
