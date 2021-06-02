package world.homans.xunyue.model;

import com.alibaba.fastjson.annotation.JSONType;
import org.omg.CORBA.INTERNAL;
import org.w3c.dom.Text;
import world.homans.xunyue.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "`artists`")
@JSONType(orders = {"id","followers","genres", "name","popularity"})

public class Artists extends BaseEntity{
    @Column(name = "`id`")
    private String id;

    @Column(name = "`followers`")
    private Integer followers;

    @Column(name = "`genres`")
    private String genres;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`popularity`")
    private Integer popularity;

    public Artists(String id, Integer followers, String genres, String name, Integer popularity) {
        this.id = id;
        this.followers = followers;
        this.genres =genres;
        this.name =name;
        this.popularity =popularity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer  followers) {
        this.followers = followers;
    }

    public String getGenres() { return genres; }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopularity() { return popularity; }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }


}
