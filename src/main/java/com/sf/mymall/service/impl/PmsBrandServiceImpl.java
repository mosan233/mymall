package com.sf.mymall.service.impl;

import com.github.pagehelper.PageHelper;
import com.sf.mymall.dto.PmsBrandParam;
import com.sf.mymall.mapper.PmsBrandMapper;
import com.sf.mymall.model.PmsBrand;
import com.sf.mymall.model.PmsBrandExample;
import com.sf.mymall.service.PmsBrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public boolean createBrand(PmsBrandParam pmsBrandParam) {
        PmsBrand record = new PmsBrand();
        BeanUtils.copyProperties(pmsBrandParam,record);
        if(StringUtils.isEmpty(record.getFirstLetter())){
            record.setFirstLetter(record.getName().substring(0,1));
        }
        int count = brandMapper.insertSelective(record);
        return count == 1 ? true : false;
    }

    @Override
    public boolean updateBrand(long id, PmsBrandParam param) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(param,pmsBrand);
        pmsBrand.setId(id);
        if(StringUtils.isEmpty(pmsBrand.getFirstLetter())){
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0,1));
        }
        int count = brandMapper.updateByPrimaryKeySelective(pmsBrand);
        return count == 1 ? true : false;
    }

    @Override
    public boolean deleteBrand(Long id) {
        int count  = brandMapper.deleteByPrimaryKey(id);
        return count == 1 ? true : false;
    }

    @Override
    public List<PmsBrand> listBrand(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsBrandExample example = new PmsBrandExample();
        PmsBrandExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(keyword)){
            criteria.andNameLike("%"+keyword+"%");
        }
        List<PmsBrand> datas = brandMapper.selectByExample(example);
        return datas;
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteBatch(List<Long> ids) {
        PmsBrandExample example = new PmsBrandExample();
        PmsBrandExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        int count = brandMapper.deleteByExample(example);
        return count > 0 ? true :false;
    }

    @Override
    public boolean updateShowStatus(List<Long> ids, Integer showStatus) {
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setShowStatus(showStatus);
        PmsBrandExample example = new PmsBrandExample();
        PmsBrandExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        int count = brandMapper.updateByExampleSelective(pmsBrand,example);
        return count > 0 ? true : false;
    }
}
