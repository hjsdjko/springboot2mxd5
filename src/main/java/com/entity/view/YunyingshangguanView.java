package com.entity.view;

import com.entity.YunyingshangguanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 运营商管
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-12-29 17:38:04
 */
@TableName("yunyingshangguan")
public class YunyingshangguanView  extends YunyingshangguanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YunyingshangguanView(){
	}
 
 	public YunyingshangguanView(YunyingshangguanEntity yunyingshangguanEntity){
 	try {
			BeanUtils.copyProperties(this, yunyingshangguanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
