package world.homans.xunyue.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;
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
public class SearchController extends BaseController {
    @Autowired
    private TracksService tracksService;
    private ArtistsService artistsService;

    @GetMapping(value = "", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "模糊搜索", notes = "通过关键词模糊搜索 tracks 与 artists")
    public String search(@ApiParam(name = "name", value = "name", required = true) @RequestParam String name) {
        Map<String, Object> results = new HashMap<>();
        // TODO for hhp 调用 tracksService.search 和 artistService.search 查询，结果合并在一个 json 中返回
        // 当然也你可以写一个 SearchService 来一起调用上面两个 service
        Tracks keyTracks = new Tracks();
        keyTracks.setName(name);
        Artists keyArtists = new Artists();
        keyArtists.setName(name);
        List<Tracks> tracksresults;
        List<Artists> artistsresults;
        tracksresults = tracksService.select(keyTracks);
        artistsresults = artistsService.select(keyArtists);

        return FastJsonUtils.resultSuccess(200, "搜索成功", results);

    }

}
