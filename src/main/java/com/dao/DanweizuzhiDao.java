package com.dao;

import com.entity.DanweizuzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DanweizuzhiVO;
import com.entity.view.DanweizuzhiView;


/**
 * 单位组织
 * 
 * @author 
 * @email 
 * @date 2022-12-29 17:38:04
 */
public interface DanweizuzhiDao extends BaseMapper<DanweizuzhiEntity> {
	
	List<DanweizuzhiVO> selectListVO(@Param("ew") Wrapper<DanweizuzhiEntity> wrapper);
	
	DanweizuzhiVO selectVO(@Param("ew") Wrapper<DanweizuzhiEntity> wrapper);
	
	List<DanweizuzhiView> selectListView(@Param("ew") Wrapper<DanweizuzhiEntity> wrapper);

	List<DanweizuzhiView> selectListView(Pagination page,@Param("ew") Wrapper<DanweizuzhiEntity> wrapper);
	
	DanweizuzhiView selectView(@Param("ew") Wrapper<DanweizuzhiEntity> wrapper);
	

}
