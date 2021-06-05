package world.homans.xunyue.base;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String INDEX_NAME = "index_entity";
    public static final String TYPE = "tstype";

    /*
    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
    */
}
