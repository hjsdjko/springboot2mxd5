package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YonghuzuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YonghuzuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YonghuzuView;


/**
 * 用户组
 *
 * @author 
 * @email 
 * @date 2022-12-29 17:38:04
 */
public interface YonghuzuService extends IService<YonghuzuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YonghuzuVO> selectListVO(Wrapper<YonghuzuEntity> wrapper);
   	
   	YonghuzuVO selectVO(@Param("ew") Wrapper<YonghuzuEntity> wrapper);
   	
   	List<YonghuzuView> selectListView(Wrapper<YonghuzuEntity> wrapper);
   	
   	YonghuzuView selectView(@Param("ew") Wrapper<YonghuzuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YonghuzuEntity> wrapper);
   	

}

