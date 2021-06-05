package world.homans.xunyue.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import world.homans.xunyue.model.Tracks;
import world.homans.xunyue.util.MyMapper;

import java.util.List;

public interface TracksDao extends MyMapper<Tracks> {

    @Select(value = "select * from tracks where id=#{id}")
    List<Tracks> selectById(@Param("id") String id);

    @Select(value = "select * from tracks where name=#{name}")
    List<Tracks> selectByName(@Param("name") String name);

}