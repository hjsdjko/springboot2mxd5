package com.dao;

import com.entity.JieruguanliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JieruguanliVO;
import com.entity.view.JieruguanliView;


/**
 * 接入管理
 * 
 * @author 
 * @email 
 * @date 2022-12-29 17:38:04
 */
public interface JieruguanliDao extends BaseMapper<JieruguanliEntity> {
	
	List<JieruguanliVO> selectListVO(@Param("ew") Wrapper<JieruguanliEntity> wrapper);
	
	JieruguanliVO selectVO(@Param("ew") Wrapper<JieruguanliEntity> wrapper);
	
	List<JieruguanliView> selectListView(@Param("ew") Wrapper<JieruguanliEntity> wrapper);

	List<JieruguanliView> selectListView(Pagination page,@Param("ew") Wrapper<JieruguanliEntity> wrapper);
	
	JieruguanliView selectView(@Param("ew") Wrapper<JieruguanliEntity> wrapper);
	

}
