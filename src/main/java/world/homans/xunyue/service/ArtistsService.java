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

    public void insertArtists(Artists artists) {
        artistsDao.insertArtists(artists);
    }

    public void update(Artists newArt) {
        artistsDao.updateById(newArt);
    }

    // artists 和 tracks 都进行模糊搜索并根据 popularity 排序
    public List<Artists> searchByName(String name) {
        return artistsDao.selectByName(name);
    }

    // 单独进行模糊搜索
    public List<Artists> searchByNameInd(String name) {
        return artistsDao.selectByNameInd(name);
    }

    public void deleteArtists(String id) {
        artistsDao.deleteArtists(id);
    }

}
