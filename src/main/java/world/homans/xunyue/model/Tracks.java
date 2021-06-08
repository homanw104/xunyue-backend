package world.homans.xunyue.model;
import com.alibaba.fastjson.annotation.JSONType;
import world.homans.xunyue.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "`tracks`")
@JSONType(orders = {"id","name","popularity", "duration_ms","explicit","artists",
        "id_artists","release_date", "danceability","energy","key","loudness","mode",
        "speechiness","acousticness","instrumentalness","liveness","valence",
        "tempo","time_signature"})
public class Tracks extends BaseEntity {

    @Column(name = "`id`")
    private String id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`popularity`")
    private int popularity;

    @Column(name = "`duration_ms`")
    private int duration_ms;

    @Column(name = "`explicit`")
    private int explicit;

    @Column(name = "`artists`")
    private String artists;

    @Column(name = "`id_artists`")
    private String id_artists;

    @Column(name = "`release_date`")
    private String release_date;


    public Tracks(String id, String name, int popularity, int duration_ms, int explicit, String artists,
                  String id_artists, String release_date) {
        this.id = id;
        this.name = name;
        this.popularity =popularity;
        this.duration_ms = duration_ms;
        this.explicit = explicit;
        this.artists = artists;
        this.id_artists =id_artists;
        this.release_date = release_date;

    }

    public Tracks() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String  name) {
        this.name = name;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Integer getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(Integer duration_ms) {
        this.duration_ms = duration_ms;
    }

    public Integer getExplicit() {
        return explicit;
    }

    public void setExplicit(Integer explicit) {
        this.explicit = explicit;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getId_artists() {
        return id_artists;
    }

    public void setId_artists(String id_artists) {
        this.id_artists = id_artists;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }


}
