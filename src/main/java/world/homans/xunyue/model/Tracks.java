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

    @Column(name = "`danceability`")
    private Double danceability;

    @Column(name = "`energy`")
    private Double energy;

    @Column(name = "`key`")
    private int key;

    @Column(name = "`loudness`")
    private Double loudness;

    @Column(name = "`mode`")
    private int mode;

    @Column(name = "`speechiness`")
    private Double speechiness;

    @Column(name = "`acousticness`")
    private Double acousticness;

    @Column(name = "`instrumentalness`")
    private Double instrumentalness;

    @Column(name = "`liveness`")
    private Double liveness;

    @Column(name = "`valence`")
    private Double valence;

    @Column(name = "`tempo`")
    private Double tempo;

    @Column(name = "`time_signature`")
    private Integer time_signature;



    public Tracks(String id, String name, int popularity, int duration_ms, int explicit, String artists,
                  String id_artists, String release_date, Double danceability, Double energy, int key, Double loudness, int mode ,
                  Double speechiness, Double acousticness, Double instrumentalness, Double liveness, Double valence,
                  Double tempo, int time_signature) {
        this.id = id;
        this.name = name;
        this.popularity =popularity;
        this.duration_ms = duration_ms;
        this.explicit = explicit;
        this.artists = artists;
        this.id_artists =id_artists;
        this.release_date = release_date;
        this.danceability = danceability;
        this.energy = energy;
        this.key = key;
        this.loudness = loudness;
        this.mode =mode;
        this.speechiness = speechiness;
        this.acousticness =acousticness;
        this.instrumentalness =instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.time_signature = time_signature;
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

    public Double getDanceability() {
        return danceability;
    }

    public void setDanceability(Double danceability) {
        this.danceability = danceability;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Double getLoudness() {
        return loudness;
    }

    public void setLoudness(Double loudness) {
        this.loudness = loudness;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public Double getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(Double speechiness) {
        this.speechiness = speechiness;
    }

    public Double getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(Double acousticness) {
        this.acousticness = acousticness;
    }

    public Double getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(Double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public Double getLiveness() {
        return liveness;
    }

    public void setLiveness(Double liveness) {
        this.liveness = liveness;
    }

    public Double getValence() {
        return valence;
    }

    public void setValence(Double valence) {
        this.valence = valence;
    }

    public Double getTempo() {
        return tempo;
    }

    public void setTempo(Double tempo) {
        this.tempo = tempo;
    }

    public Integer getTime_signature() {
        return time_signature;
    }

    public void setTime_signature(Integer time_signature) {
        this.time_signature = time_signature;
    }
}
