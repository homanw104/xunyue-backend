package world.homans.xunyue.controller;

import me.ccampo.uuid62.core.util.UUIDUtilsKt;
import world.homans.xunyue.model.Artists;
import world.homans.xunyue.service.ArtistsService;
import world.homans.xunyue.util.FastJsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import world.homans.xunyue.base.BaseController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/artists")
@Api(description = "歌手接口")
public class ArtistsController extends BaseController {

    @Autowired
    private ArtistsService artistsService;

    @GetMapping(value = "/info", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "通过id查找内容", notes = "通过id查找artists")
    public String search(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        List<Artists> results;
        results = artistsService.searchById(id);
        if (results.size() == 1) {
            return FastJsonUtils.resultSuccess(200, "搜索artists成功", results.get(0));
        } else {
            return FastJsonUtils.resultError(404, "id不存在", null);
        }
    }

    @GetMapping(value = "/search", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "通过name查找内容", notes = "通过name查找artists")
    public String searchByName(@ApiParam(name = "name", value = "name", required = true) @RequestParam String name) {
        List<Artists> results;
        results = artistsService.searchByNameInd(name);
        if (results.size() == 0) {
            return FastJsonUtils.resultSuccess(404, "name不存在", results);
        } else {
            return FastJsonUtils.resultSuccess(200, "搜索artists成功", results);
        }
    }

    @PostMapping(value = "/insert", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "添加歌手", notes = "添加歌手")
    public String insert(
            @ApiParam(name = "followers", value = "粉丝数目", required = true) @RequestParam int followers,
            @ApiParam(name = "genres", value = "流派", required = true) @RequestParam String genres,
            @ApiParam(name = "name", value = "艺术家名字", required = true) @RequestParam String name,
            @ApiParam(name = "popularity", value = "受欢迎程度", required = true) @RequestParam int popularity) {
        String id = UUIDUtilsKt.toBase62String(UUID.randomUUID());
        Artists artists = new Artists(id, followers, genres, name, popularity);
        artistsService.insertArtists(artists);
        Map<String, Object> result = new HashMap<>();
        result.put("id", id);
        return FastJsonUtils.resultSuccess(200, "保存内容成功", result);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改艺术家信息", notes = "修改艺术家信息")
    public String updateInfo(@ApiParam(name = "id", value = "艺术家id", required = true) @RequestParam String id,
                             @ApiParam(name = "followers", value = "粉丝数量") @RequestParam(required = false, defaultValue = "") int followers,
                             @ApiParam(name = "genres", value = "流派") @RequestParam(required = false, defaultValue = "") String genres,
                             @ApiParam(name = "name", value = "艺术家名字") @RequestParam(required = false, defaultValue = "") String name,
                             @ApiParam(name = "popularity", value = "受欢迎程度") @RequestParam(required = false, defaultValue = "") int popularity) {
        Artists newArt = artistsService.searchById(id).get(0);
        if (!"".equals(followers))
            newArt.setFollowers(followers);
        if (!"".equals(genres))
            newArt.setGenres(genres);
        if (!"".equals(name))
            newArt.setName(name);
        if (!"".equals(popularity))
            newArt.setPopularity(popularity);
        artistsService.update(newArt);
        return FastJsonUtils.resultSuccess(200, "修改成功", null);
    }

    @PostMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "删除歌手", notes = "删除歌手")
    public String delete(@ApiParam(name = "id", value = "艺术家id", required = true) @RequestParam String id) {
        artistsService.deleteArtists(id);
        return FastJsonUtils.resultSuccess(200, "删除artists内容成功", null);
    }

}
