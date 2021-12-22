package com.sf.mymall.service;

import com.sf.mymall.dto.PmsBrandParam;
import com.sf.mymall.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {
    /**
    * 查询所有品牌
    */
    List<PmsBrand> listAllBrand();

    /**
    新增品牌
    */
    boolean createBrand(PmsBrandParam pmsBrandParam);

    /**
    * 更新品牌
    */
    boolean updateBrand(long id, PmsBrandParam param);

    /**
    * 删除品牌
   */
    boolean deleteBrand(Long id);

    /**
    * 根据品牌名称分页查找
    */
    List<PmsBrand> listBrand(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 根据编号获取品牌信息
    */
    PmsBrand getBrand(Long id);

    /**
    * 批量删除品牌
    */
    boolean deleteBatch(List<Long> ids);

    /**
     * 批量更新品牌显示状态
     */
    boolean updateShowStatus(List<Long> ids, Integer showStatus);
}
