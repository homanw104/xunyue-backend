package world.homans.xunyue.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import world.homans.xunyue.model.Artists;
import world.homans.xunyue.util.MyMapper;

import java.util.List;

public interface ArtistsDao extends MyMapper<Artists> {

    @Select(value = "select * from artists where id=#{id}")
    List<Artists> selectById(@Param("id") String id);

}