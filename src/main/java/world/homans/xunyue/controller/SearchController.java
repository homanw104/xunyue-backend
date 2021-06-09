package world.homans.xunyue.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import world.homans.xunyue.base.BaseController;
import world.homans.xunyue.model.Artists;
import world.homans.xunyue.model.Tracks;
import world.homans.xunyue.service.ArtistsService;
import world.homans.xunyue.service.TracksService;
import world.homans.xunyue.util.FastJsonUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/search")
@Api(description = "模糊搜索接口")
@CrossOrigin
public class SearchController extends BaseController {

    @Autowired
    private TracksService tracksService;

    @Autowired
    private ArtistsService artistsService;

    @GetMapping(value = "", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "模糊搜索", notes = "通过关键词模糊搜索 tracks 与 artists")
    public String search(@ApiParam(name = "name", value = "name", required = true) @RequestParam String name) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> result1 = new HashMap<>();
        Map<String, Object> result2 = new HashMap<>();
        Map<String, Object> topResults = new HashMap<>();
        List<Tracks> tracksResults;
        List<Artists> artistsResults;
        tracksResults = tracksService.searchByName(name);
        artistsResults = artistsService.searchByName(name);
        result1.put("artists", artistsResults);
        result2.put("tracks",tracksResults);
        result.put("top", topResults);
        String type = "";
        if (artistsResults.size() == 0 && tracksResults.size() == 0) {
            return FastJsonUtils.resultSuccess(404, "没有相关信息", null);
        } else {
            if (artistsResults.size() == 0) {
                topResults.put("data", tracksResults.get(0));
                type = "tracks";
            } else if (tracksResults.size() == 0) {
                topResults.put("data", artistsResults.get(0));
                type = "artists";
            } else {
                int a = artistsResults.get(0).getPopularity();
                int b = tracksResults.get(0).getPopularity();
                if (a > b) {
                    topResults.put("data", artistsResults.get(0));
                    type = "artists";
                } else {
                    topResults.put("data", tracksResults.get(0));
                    type = "tracks";
                }
            }
            topResults.put("type", type);
            result.put("top", topResults);
            result.putAll(result1);
            result.putAll(result2);
            return FastJsonUtils.resultSuccess(200, "搜索成功", result);
        }
    }
}
