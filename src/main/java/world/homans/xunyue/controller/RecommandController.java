package world.homans.xunyue.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.homans.xunyue.base.BaseController;
import world.homans.xunyue.model.Tracks;
import world.homans.xunyue.service.TracksService;
import world.homans.xunyue.util.FastJsonUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/recommand")
@Api(description = "推荐接口")
public class RecommandController extends BaseController {

    @Autowired
    private TracksService tracksService;

    @GetMapping(value = "/top8", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "推荐歌单", notes = "推荐歌单")
    public String recommend() {
        Map<String, Object> result = new HashMap<>();
        List<Tracks> recommendResults;
        recommendResults = tracksService.showTop8();
        result.put("recommend", recommendResults);
        return FastJsonUtils.resultSuccess(200, "拉取推荐列表成功", result);
    }

}
