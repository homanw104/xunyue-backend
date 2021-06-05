package world.homans.xunyue.service;

import world.homans.xunyue.base.BaseServiceImpl;
import world.homans.xunyue.dao.ArtistsDao;
import world.homans.xunyue.model.Artists;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArtistsService extends BaseServiceImpl<Artists> {
    @Resource
    private ArtistsDao artistsDao;

    @Override
    public Mapper<Artists> getMapper() {

        return artistsDao;
    }


    public List<Artists> searchById(String id) {
        return artistsDao.selectById(id);
    }

    public  void insertArtists(Artists artists) {
        artistsDao.insertArtists(artists);
    };

    public void update(Artists newArt) {
        artistsDao.updateById(newArt);
    }
}
