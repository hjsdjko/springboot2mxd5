package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DanweizuzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DanweizuzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DanweizuzhiView;


/**
 * 单位组织
 *
 * @author 
 * @email 
 * @date 2022-12-29 17:38:04
 */
public interface DanweizuzhiService extends IService<DanweizuzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DanweizuzhiVO> selectListVO(Wrapper<DanweizuzhiEntity> wrapper);
   	
   	DanweizuzhiVO selectVO(@Param("ew") Wrapper<DanweizuzhiEntity> wrapper);
   	
   	List<DanweizuzhiView> selectListView(Wrapper<DanweizuzhiEntity> wrapper);
   	
   	DanweizuzhiView selectView(@Param("ew") Wrapper<DanweizuzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DanweizuzhiEntity> wrapper);
   	

}

