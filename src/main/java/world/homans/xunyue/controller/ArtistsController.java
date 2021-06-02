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

import java.util.List;


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
        return FastJsonUtils.resultSuccess(200, "搜索artists成功", results);
    }


}
