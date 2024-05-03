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


import com.dao.DanweizuzhiDao;
import com.entity.DanweizuzhiEntity;
import com.service.DanweizuzhiService;
import com.entity.vo.DanweizuzhiVO;
import com.entity.view.DanweizuzhiView;

@Service("danweizuzhiService")
public class DanweizuzhiServiceImpl extends ServiceImpl<DanweizuzhiDao, DanweizuzhiEntity> implements DanweizuzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DanweizuzhiEntity> page = this.selectPage(
                new Query<DanweizuzhiEntity>(params).getPage(),
                new EntityWrapper<DanweizuzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DanweizuzhiEntity> wrapper) {
		  Page<DanweizuzhiView> page =new Query<DanweizuzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DanweizuzhiVO> selectListVO(Wrapper<DanweizuzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DanweizuzhiVO selectVO(Wrapper<DanweizuzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DanweizuzhiView> selectListView(Wrapper<DanweizuzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DanweizuzhiView selectView(Wrapper<DanweizuzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
