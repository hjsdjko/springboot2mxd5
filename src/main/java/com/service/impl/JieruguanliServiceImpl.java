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


import com.dao.JieruguanliDao;
import com.entity.JieruguanliEntity;
import com.service.JieruguanliService;
import com.entity.vo.JieruguanliVO;
import com.entity.view.JieruguanliView;

@Service("jieruguanliService")
public class JieruguanliServiceImpl extends ServiceImpl<JieruguanliDao, JieruguanliEntity> implements JieruguanliService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JieruguanliEntity> page = this.selectPage(
                new Query<JieruguanliEntity>(params).getPage(),
                new EntityWrapper<JieruguanliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JieruguanliEntity> wrapper) {
		  Page<JieruguanliView> page =new Query<JieruguanliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JieruguanliVO> selectListVO(Wrapper<JieruguanliEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JieruguanliVO selectVO(Wrapper<JieruguanliEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JieruguanliView> selectListView(Wrapper<JieruguanliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JieruguanliView selectView(Wrapper<JieruguanliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
