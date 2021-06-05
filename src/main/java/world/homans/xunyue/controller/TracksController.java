package world.homans.xunyue.controller;

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


}
