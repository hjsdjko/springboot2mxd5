package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YunyingshangguanDao;
import com.entity.YunyingshangguanEntity;
import com.service.YunyingshangguanService;
import com.entity.vo.YunyingshangguanVO;
import com.entity.view.YunyingshangguanView;

@Service("yunyingshangguanService")
public class YunyingshangguanServiceImpl extends ServiceImpl<YunyingshangguanDao, YunyingshangguanEntity> implements YunyingshangguanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YunyingshangguanEntity> page = this.selectPage(
                new Query<YunyingshangguanEntity>(params).getPage(),
                new EntityWrapper<YunyingshangguanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YunyingshangguanEntity> wrapper) {
		  Page<YunyingshangguanView> page =new Query<YunyingshangguanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YunyingshangguanVO> selectListVO(Wrapper<YunyingshangguanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YunyingshangguanVO selectVO(Wrapper<YunyingshangguanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YunyingshangguanView> selectListView(Wrapper<YunyingshangguanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YunyingshangguanView selectView(Wrapper<YunyingshangguanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
