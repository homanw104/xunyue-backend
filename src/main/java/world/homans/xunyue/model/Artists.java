package world.homans.xunyue.model;

import com.alibaba.fastjson.annotation.JSONType;
import world.homans.xunyue.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "`artists`")
@JSONType(orders = {"id", "followers", "genres", "name", "popularity"})

public class Artists extends BaseEntity {
    @Column(name = "`id`")
    private String id;

    @Column(name = "`followers`")
    private int followers;

    @Column(name = "`genres`")
    private String genres;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`popularity`")
    private int popularity;

    public Artists(String id, int followers, String genres, String name, int popularity) {
        this.id = id;
        this.followers = followers;
        this.genres = genres;
        this.name = name;
        this.popularity = popularity;
    }

    public Artists() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

}
