package com.entity.view;

import com.entity.DanweizuzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 单位组织
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-12-29 17:38:04
 */
@TableName("danweizuzhi")
public class DanweizuzhiView  extends DanweizuzhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DanweizuzhiView(){
	}
 
 	public DanweizuzhiView(DanweizuzhiEntity danweizuzhiEntity){
 	try {
			BeanUtils.copyProperties(this, danweizuzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
