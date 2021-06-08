package world.homans.xunyue.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.elasticsearch.annotations.Query;
import world.homans.xunyue.model.Artists;
import world.homans.xunyue.util.MyMapper;

import java.util.List;

public interface ArtistsDao extends MyMapper<Artists> {

    @Select(value = "select * from artists where id=#{id}")
    List<Artists> selectById(@Param("id") String id);

    void insertArtists(Artists artists);

    @Update(value = "update artists set followers=#{followers}, genres=#{genres}, name=#{name},popularity=#{popularity} where id=#{id}")
    void updateById(Artists newArt);

    List<Artists> selectByName(String name);

    void deleteArtists(String id);

}

