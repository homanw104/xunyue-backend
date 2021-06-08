package world.homans.xunyue.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import world.homans.xunyue.model.Artists;
import world.homans.xunyue.model.Artists;
import world.homans.xunyue.model.Tracks;
import world.homans.xunyue.util.MyMapper;

import java.util.List;

public interface TracksDao extends MyMapper<Tracks> {

    @Select(value = "select * from tracks where id=#{id}")
    List<Tracks> selectById(@Param("id") String id);

    @Update(value = "update tracks set name=#{name}, explicit=#{explicit}, artists=#{artists},duration_ms=#{duration_ms},release_date=#{release_date},popularity=#{popularity} where id=#{id}")
    void updateById(Tracks newTra);

    void insertTracks(Tracks tracks);
    List<Tracks> selectByNameInd(String name);
    List<Tracks> selectByName(String name);
    List<Tracks> selectByAid(String id_artists);
    List<Tracks> selectTop8();
    void deleteTracks(String id);
}