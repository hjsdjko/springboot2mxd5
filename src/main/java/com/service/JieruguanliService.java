package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JieruguanliEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JieruguanliVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JieruguanliView;


/**
 * 接入管理
 *
 * @author 
 * @email 
 * @date 2022-12-29 17:38:04
 */
public interface JieruguanliService extends IService<JieruguanliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JieruguanliVO> selectListVO(Wrapper<JieruguanliEntity> wrapper);
   	
   	JieruguanliVO selectVO(@Param("ew") Wrapper<JieruguanliEntity> wrapper);
   	
   	List<JieruguanliView> selectListView(Wrapper<JieruguanliEntity> wrapper);
   	
   	JieruguanliView selectView(@Param("ew") Wrapper<JieruguanliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JieruguanliEntity> wrapper);
   	

}

