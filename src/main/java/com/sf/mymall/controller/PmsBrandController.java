package com.sf.mymall.controller;

import com.sf.mymall.api.CommonResult;
import com.sf.mymall.dto.PmsBrandParam;
import com.sf.mymall.model.PmsBrand;
import com.sf.mymall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.beans.IntrospectionException;
import java.util.List;

@Controller
@RequestMapping("/brand")
@Api(value = "PmsBrandController" ,description = "商品品牌管理")
public class PmsBrandController {

    @Autowired
    private PmsBrandService brandService;

    @ApiOperation(value = "获取全部品牌列表")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getList(){
        List<PmsBrand> datas = brandService.listAllBrand();
        return CommonResult.success(datas);
    }

    @ApiOperation(value = "新增品牌")
    @RequestMapping(value = "/addAction",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addAction(@Validated @RequestBody PmsBrandParam pmsBrandParam){
        boolean flag = brandService.createBrand(pmsBrandParam);
        if(flag){
            return CommonResult.success("新增品牌成功");
        }else {
            return CommonResult.failed("新增品牌失败");
        }
    }

    @ApiOperation(value = "更新品牌")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateAction(@PathVariable("id") long id,@Validated @RequestBody PmsBrandParam param){
        boolean flag = brandService.updateBrand(id,param);
        if(flag){
            return CommonResult.success("更新品牌成功");
        }else {
            return CommonResult.failed("更新品牌失败");
        }
    }

    @ApiOperation(value = "删除品牌")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteAction(@PathVariable("id") Long id){
        boolean flag = brandService.deleteBrand(id);
        if (flag){
            return CommonResult.success("删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }

    @ApiOperation(value = "根据品牌名称分页获取品牌列表")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getList(@RequestParam(value = "keyword",required = false) String keyword,
                                                @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        List<PmsBrand> datas = brandService.listBrand(keyword,pageNum,pageSize);
        return CommonResult.success(datas);
    }

    @ApiOperation(value = "根据编号获取品牌信息")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> getItem(@PathVariable Long id){
        return CommonResult.success(brandService.getBrand(id));
    }

    @ApiOperation(value = "批量删除品牌")
    @RequestMapping(value = "/delete/batch",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteBatch(@RequestParam("ids") List<Long> ids){
        boolean flag = brandService.deleteBatch(ids);
        if (flag){
            return CommonResult.success("批量删除品牌成功");
        }else{
            return CommonResult.failed("批量删除失败");
        }
    }

    public CommonResult updateShowStatus(@RequestParam("ids") List<Long> ids,
                                         @RequestParam("showStatus")Integer showStatus){
        boolean flag = brandService.updateShowStatus(ids,showStatus);
        if(flag){
            return CommonResult.success("批量更新状态成功");
        }else {
            return CommonResult.failed("批量更新显示状态失败");
        }
    }
//
//    @ApiOperation(value = "批量更新厂家制造商状态")
//    @RequestMapping(value = "/update/factoryStatus", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult updateFactoryStatus(@RequestParam("ids") List<Long> ids,
//                                            @RequestParam("factoryStatus") Integer factoryStatus) {
//        int count = brandService.updateFactoryStatus(ids, factoryStatus);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }

}
