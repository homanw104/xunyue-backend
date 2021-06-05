package world.homans.xunyue.controller;

import world.homans.xunyue.model.Artists;
import world.homans.xunyue.model.Tracks;
import world.homans.xunyue.service.TracksService;
import world.homans.xunyue.util.FastJsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import world.homans.xunyue.base.BaseController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/tracks")
@Api(description = "歌曲信息接口")
public class TracksController extends BaseController {
    @Autowired
    private TracksService tracksService;

    @GetMapping(value = "", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "查找内容", notes = "通过id查找track")
    public String getTrackById(@ApiParam(name = "id", value = "id",required = true) @RequestParam String id) {
        Tracks keyTracks = new Tracks();
        keyTracks.setId(id);
        List<Tracks> results;
        results = tracksService.select(keyTracks);
        if (results.size() == 1) {
            return FastJsonUtils.resultSuccess(200, "搜索track成功", results.get(0));
        } else {
            return FastJsonUtils.resultError(404, "id不存在", null);
        }
    }
    @PostMapping("/update")
    @ApiOperation(value = "修改歌曲信息", notes = "修改歌曲信息")
    public String updateInfo(@ApiParam(name = "id", value = "歌曲id",required = true)@RequestParam String id,
                             @ApiParam(name = "name", value = "歌曲名称")@RequestParam(required = false, defaultValue = "") String name,
                             @ApiParam(name = "explicit", value = "是否暴露")@RequestParam(required = false, defaultValue = "") int explicit,
                             @ApiParam(name = "artists", value = "艺人名字")@RequestParam(required = false, defaultValue = "") String artists,
                             @ApiParam(name = "duration_ms", value = "时长")@RequestParam(required = false, defaultValue = "") int duration_ms,
                             @ApiParam(name = "release_date", value = "发行时间")@RequestParam(required = false, defaultValue = "") String release_date,
                             @ApiParam(name = "popularity", value = "受欢迎程度")@RequestParam(required = false, defaultValue = "") int popularity

    ) {
        Tracks newTra=tracksService.searchById(id).get(0);
        if(!"".equals(name))
            newTra.setName(name);
        if(!"".equals(explicit))
            newTra.setExplicit(explicit);
        if(!"".equals(artists))
            newTra.setArtists(artists);
        if(!"".equals(duration_ms))
            newTra.setExplicit(duration_ms);
        if(!"".equals(release_date))
            newTra.setArtists(release_date);
        if(!"".equals(popularity))
            newTra.setPopularity(popularity);
        tracksService.update(newTra);
        return FastJsonUtils.resultSuccess(200, "修改成功", null);

    }

}
