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


import com.dao.YonghuzuDao;
import com.entity.YonghuzuEntity;
import com.service.YonghuzuService;
import com.entity.vo.YonghuzuVO;
import com.entity.view.YonghuzuView;

@Service("yonghuzuService")
public class YonghuzuServiceImpl extends ServiceImpl<YonghuzuDao, YonghuzuEntity> implements YonghuzuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YonghuzuEntity> page = this.selectPage(
                new Query<YonghuzuEntity>(params).getPage(),
                new EntityWrapper<YonghuzuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YonghuzuEntity> wrapper) {
		  Page<YonghuzuView> page =new Query<YonghuzuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YonghuzuVO> selectListVO(Wrapper<YonghuzuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YonghuzuVO selectVO(Wrapper<YonghuzuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YonghuzuView> selectListView(Wrapper<YonghuzuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YonghuzuView selectView(Wrapper<YonghuzuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
