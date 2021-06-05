package world.homans.xunyue.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;
import world.homans.xunyue.base.BaseController;
import world.homans.xunyue.util.FastJsonUtils;

@RestController
@RequestMapping("/search")
@Api(description = "模糊搜索接口")
public class SearchController extends BaseController {

    @GetMapping(value = "", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "模糊搜索", notes = "通过关键词模糊搜索 tracks 与 artists")
    public String search(@ApiParam(name = "query", value = "query", required = true) @RequestParam String query) {
        Json results = new Json("{}");

        // TODO for hhp 调用 tracksService.search 和 artistService.search 查询，结果合并在一个 json 中返回
        // 当然也你可以写一个 SearchService 来一起调用上面两个 service

        return FastJsonUtils.resultSuccess(200, "搜索成功", results);
    }

}
