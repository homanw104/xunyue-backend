package world.homans.xunyue.controller;

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


@RestController
@RequestMapping("/artists")
@Api(description = "歌手接口")
public class ArtistsController extends BaseController {
    @Autowired
    private ArtistsService artistsService;


    @GetMapping(value = "/artists", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "查找内容", notes = "通过id查找artists")
    public String search(@ApiParam(name = "id", value = "id",required = true) @RequestParam String id) {
        List<Artists> results;
        results=artistsService.searchById(id);
        if (results.size() == 1) {
            return FastJsonUtils.resultSuccess(200, "搜索artists成功", results.get(0));
        } else {
            return FastJsonUtils.resultError(404, "id不存在", null);
        }
    }

    @ResponseBody
    @PostMapping(value = "/insert", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "添加歌手", notes = "添加歌手")
    public String insert(
            @ApiParam(name = "id", value = "艺术家编号", required = true) @RequestParam String id,
            @ApiParam(name = "followers", value = "粉丝数目", required = true) @RequestParam int followers,
            @ApiParam(name = "genres", value = "流派", required = true) @RequestParam String genres,
            @ApiParam(name = "name", value = "艺术家名字", required = true) @RequestParam String name,
            @ApiParam(name = "popularity", value = "受欢迎程度", required = true) @RequestParam int popularity) {
        System.out.println(name);
        //long id = super.getIdGeneratorUtils().nextId();
        Artists artists = new Artists(id, followers, genres, name, popularity);
        artistsService.insertArtists(artists);
        Map<String, Object> result = new HashMap<>();
        result.put("id", id);
        return FastJsonUtils.resultSuccess(200, "保存内容成功", result);
    }

}
