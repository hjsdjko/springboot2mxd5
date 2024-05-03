package com.dao;

import com.entity.YunyingshangguanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YunyingshangguanVO;
import com.entity.view.YunyingshangguanView;


/**
 * 运营商管
 * 
 * @author 
 * @email 
 * @date 2022-12-29 17:38:04
 */
public interface YunyingshangguanDao extends BaseMapper<YunyingshangguanEntity> {
	
	List<YunyingshangguanVO> selectListVO(@Param("ew") Wrapper<YunyingshangguanEntity> wrapper);
	
	YunyingshangguanVO selectVO(@Param("ew") Wrapper<YunyingshangguanEntity> wrapper);
	
	List<YunyingshangguanView> selectListView(@Param("ew") Wrapper<YunyingshangguanEntity> wrapper);

	List<YunyingshangguanView> selectListView(Pagination page,@Param("ew") Wrapper<YunyingshangguanEntity> wrapper);
	
	YunyingshangguanView selectView(@Param("ew") Wrapper<YunyingshangguanEntity> wrapper);
	

}
