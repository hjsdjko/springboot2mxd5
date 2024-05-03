package com.dao;

import com.entity.YonghuzuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YonghuzuVO;
import com.entity.view.YonghuzuView;


/**
 * 用户组
 * 
 * @author 
 * @email 
 * @date 2022-12-29 17:38:04
 */
public interface YonghuzuDao extends BaseMapper<YonghuzuEntity> {
	
	List<YonghuzuVO> selectListVO(@Param("ew") Wrapper<YonghuzuEntity> wrapper);
	
	YonghuzuVO selectVO(@Param("ew") Wrapper<YonghuzuEntity> wrapper);
	
	List<YonghuzuView> selectListView(@Param("ew") Wrapper<YonghuzuEntity> wrapper);

	List<YonghuzuView> selectListView(Pagination page,@Param("ew") Wrapper<YonghuzuEntity> wrapper);
	
	YonghuzuView selectView(@Param("ew") Wrapper<YonghuzuEntity> wrapper);
	

}
