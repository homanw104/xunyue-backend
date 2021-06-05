package world.homans.xunyue.service;

import world.homans.xunyue.base.BaseServiceImpl;
import world.homans.xunyue.dao.TracksDao;
import world.homans.xunyue.model.Artists;
import world.homans.xunyue.model.Tracks;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TracksService extends BaseServiceImpl<Tracks> {
    @Resource
    private TracksDao tracksDao;

    @Override
    public Mapper<Tracks> getMapper() {
        return tracksDao;
    }

    public List<Tracks> searchById(String id) {
        return tracksDao.selectById(id);
    }

    public  void insertTracks(Tracks tracks) {
        tracksDao.insertTracks(tracks);
    };

}
