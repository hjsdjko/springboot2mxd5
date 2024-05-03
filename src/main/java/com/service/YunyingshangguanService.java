package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YunyingshangguanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YunyingshangguanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YunyingshangguanView;


/**
 * 运营商管
 *
 * @author 
 * @email 
 * @date 2022-12-29 17:38:04
 */
public interface YunyingshangguanService extends IService<YunyingshangguanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YunyingshangguanVO> selectListVO(Wrapper<YunyingshangguanEntity> wrapper);
   	
   	YunyingshangguanVO selectVO(@Param("ew") Wrapper<YunyingshangguanEntity> wrapper);
   	
   	List<YunyingshangguanView> selectListView(Wrapper<YunyingshangguanEntity> wrapper);
   	
   	YunyingshangguanView selectView(@Param("ew") Wrapper<YunyingshangguanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YunyingshangguanEntity> wrapper);
   	

}

