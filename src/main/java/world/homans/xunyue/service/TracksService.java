package world.homans.xunyue.service;

import world.homans.xunyue.base.BaseServiceImpl;
import world.homans.xunyue.dao.TracksDao;
import world.homans.xunyue.model.Tracks;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
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

    public void update(Tracks newTra) {
        tracksDao.updateById(newTra);
    }

    public void insertTracks(Tracks tracks) {
        tracksDao.insertTracks(tracks);
    }

    public List<Tracks> searchByNameInd(String name) {
        return tracksDao.selectByNameInd(name);
    }

    public List<Tracks> searchByName(String name) {
        return tracksDao.selectByName(name);
    }

    public List<Tracks> searchByAid(String id_artists) {
        return tracksDao.selectByAid(id_artists);
    }

    public List<Tracks> showTop8() {
        return tracksDao.selectTop8();
    }

    public void deleteTracks(String id) {
        tracksDao.deleteTracks(id);
    }

}
