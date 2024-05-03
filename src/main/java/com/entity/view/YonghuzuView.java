package com.entity.view;

import com.entity.YonghuzuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 用户组
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-12-29 17:38:04
 */
@TableName("yonghuzu")
public class YonghuzuView  extends YonghuzuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YonghuzuView(){
	}
 
 	public YonghuzuView(YonghuzuEntity yonghuzuEntity){
 	try {
			BeanUtils.copyProperties(this, yonghuzuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
