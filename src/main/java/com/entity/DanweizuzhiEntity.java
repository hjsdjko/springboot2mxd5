package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 单位组织
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-12-29 17:38:04
 */
@TableName("danweizuzhi")
public class DanweizuzhiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DanweizuzhiEntity() {
		
	}
	
	public DanweizuzhiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 用户组
	 */
					
	private String yonghuzu;
	
	/**
	 * 单位名称
	 */
					
	private String danweimingcheng;
	
	/**
	 * 单位类型
	 */
					
	private String danweileixing;
	
	/**
	 * 单位位置
	 */
					
	private String danweiweizhi;
	
	/**
	 * 单位图片
	 */
					
	private String danweitupian;
	
	/**
	 * 所属关系
	 */
					
	private String suoshuguanxi;
	
	/**
	 * mac地址
	 */
					
	private String macdizhi;
	
	/**
	 * 登记日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date dengjiriqi;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：用户组
	 */
	public void setYonghuzu(String yonghuzu) {
		this.yonghuzu = yonghuzu;
	}
	/**
	 * 获取：用户组
	 */
	public String getYonghuzu() {
		return yonghuzu;
	}
	/**
	 * 设置：单位名称
	 */
	public void setDanweimingcheng(String danweimingcheng) {
		this.danweimingcheng = danweimingcheng;
	}
	/**
	 * 获取：单位名称
	 */
	public String getDanweimingcheng() {
		return danweimingcheng;
	}
	/**
	 * 设置：单位类型
	 */
	public void setDanweileixing(String danweileixing) {
		this.danweileixing = danweileixing;
	}
	/**
	 * 获取：单位类型
	 */
	public String getDanweileixing() {
		return danweileixing;
	}
	/**
	 * 设置：单位位置
	 */
	public void setDanweiweizhi(String danweiweizhi) {
		this.danweiweizhi = danweiweizhi;
	}
	/**
	 * 获取：单位位置
	 */
	public String getDanweiweizhi() {
		return danweiweizhi;
	}
	/**
	 * 设置：单位图片
	 */
	public void setDanweitupian(String danweitupian) {
		this.danweitupian = danweitupian;
	}
	/**
	 * 获取：单位图片
	 */
	public String getDanweitupian() {
		return danweitupian;
	}
	/**
	 * 设置：所属关系
	 */
	public void setSuoshuguanxi(String suoshuguanxi) {
		this.suoshuguanxi = suoshuguanxi;
	}
	/**
	 * 获取：所属关系
	 */
	public String getSuoshuguanxi() {
		return suoshuguanxi;
	}
	/**
	 * 设置：mac地址
	 */
	public void setMacdizhi(String macdizhi) {
		this.macdizhi = macdizhi;
	}
	/**
	 * 获取：mac地址
	 */
	public String getMacdizhi() {
		return macdizhi;
	}
	/**
	 * 设置：登记日期
	 */
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
	}

}
