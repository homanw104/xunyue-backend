package world.homans.xunyue.controller;


import me.ccampo.uuid62.core.util.UUIDUtilsKt;
import world.homans.xunyue.model.Tracks;
import world.homans.xunyue.service.TracksService;
import world.homans.xunyue.util.FastJsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import world.homans.xunyue.base.BaseController;

import java.util.*;


@RestController
@RequestMapping("/tracks")
@Api(description = "歌曲信息接口")
public class TracksController extends BaseController {
    @Autowired
    private TracksService tracksService;

    @GetMapping(value = "/info", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "通过id查找内容", notes = "通过id查找track")
    public String getTrackById(@ApiParam(name = "id", value = "id",required = true) @RequestParam String id) {
        List<Tracks> results;
        results = tracksService.searchById(id);
        if (results.size() == 1) {
            return FastJsonUtils.resultSuccess(200, "搜索track成功", results.get(0));
        } else {
            return FastJsonUtils.resultError(404, "id不存在", null);
        }
    }
    @GetMapping(value = "/search", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "通过name查找内容", notes = "通过name查找artists")
    public String searchByName(@ApiParam(name = "name", value = "name",required = true) @RequestParam String name) {
        List<Tracks> results;
        results=tracksService.searchByName(name);
        if (results.size() == 1) {
            return FastJsonUtils.resultSuccess(200, "搜索track成功", results.get(0));
        } else {
            return FastJsonUtils.resultError(404, "name不存在", null);
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

    @ResponseBody
    @PostMapping(value = "/insert", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "添加曲目", notes = "添加曲目")
    public String insert(
            @ApiParam(name = "name", value = "曲目名称", required = true) @RequestParam String name,
            @ApiParam(name = "popularity", value = "受欢迎程度", required = true) @RequestParam int popularity,
            @ApiParam(name = "duration_ms", value = "时间") @RequestParam(required = false,defaultValue = "0") int duration_ms,
            @ApiParam(name = "explicit", value = "概述") @RequestParam(required = false,defaultValue = "0") int explicit,
            @ApiParam(name = "artists", value = "歌手", required = true) @RequestParam String artists,
            @ApiParam(name = "id_artists", value = "艺术家id") @RequestParam(required = false,defaultValue = "") String id_artists,
            @ApiParam(name = "release_date", value = "发行日期") @RequestParam(required = false,defaultValue = "") String release_date,
            @ApiParam(name = "danceability", value = "舞蹈适配度") @RequestParam(required = false,defaultValue = "") Double danceability,
            @ApiParam(name = "energy", value = "力量感") @RequestParam(required = false,defaultValue = "") Double energy,
            @ApiParam(name = "key", value = "关键词") @RequestParam(required = false,defaultValue = "0") int key,
            @ApiParam(name = "loudness", value = "响度") @RequestParam(required = false,defaultValue = "") Double loudness,
            @ApiParam(name = "mode", value = "模式") @RequestParam(required = false,defaultValue = "0") int mode,
            @ApiParam(name = "speechiness", value = "速度") @RequestParam(required = false,defaultValue = "") Double speechiness,
            @ApiParam(name = "acousticness", value = "穿透性") @RequestParam(required = false,defaultValue = "") Double acousticness,
            @ApiParam(name = "instrumentalness", value = "演奏设备") @RequestParam(required = false,defaultValue = "") Double instrumentalness,
            @ApiParam(name = "liveness", value = "现场感") @RequestParam(required = false,defaultValue = "") Double liveness,
            @ApiParam(name = "valence", value = "价带") @RequestParam(required = false,defaultValue = "") Double valence,
            @ApiParam(name = "tempo", value = "节拍") @RequestParam(required = false,defaultValue = "") Double tempo,
            @ApiParam(name = "time_signature", value = "节拍记号") @RequestParam(required = false,defaultValue = "0") int time_signature){
        System.out.println(name);
        String id = UUIDUtilsKt.toBase62String(UUID.randomUUID());
        Tracks tracks = new Tracks(id, name, popularity, duration_ms, explicit, artists,
                id_artists, release_date, danceability, energy, key, loudness, mode ,
                speechiness, acousticness, instrumentalness, liveness, valence,
                tempo, time_signature);
        tracksService.insertTracks(tracks);
        Map<String, Object> result = new HashMap<>();
        result.put("id", id);
        return FastJsonUtils.resultSuccess(200, "保存内容成功", result);
    }


}
