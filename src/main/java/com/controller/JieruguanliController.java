package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JieruguanliEntity;
import com.entity.view.JieruguanliView;

import com.service.JieruguanliService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 接入管理
 * 后端接口
 * @author 
 * @email 
 * @date 2022-12-29 17:38:04
 */
@RestController
@RequestMapping("/jieruguanli")
public class JieruguanliController {
    @Autowired
    private JieruguanliService jieruguanliService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		JieruguanliEntity u = jieruguanliService.selectOne(new EntityWrapper<JieruguanliEntity>().eq("jieruzhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"jieruguanli",  "接入管理" );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody JieruguanliEntity jieruguanli){
    	//ValidatorUtils.validateEntity(jieruguanli);
    	JieruguanliEntity u = jieruguanliService.selectOne(new EntityWrapper<JieruguanliEntity>().eq("jieruzhanghao", jieruguanli.getJieruzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		jieruguanli.setId(uId);
        jieruguanliService.insert(jieruguanli);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        JieruguanliEntity u = jieruguanliService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	JieruguanliEntity u = jieruguanliService.selectOne(new EntityWrapper<JieruguanliEntity>().eq("jieruzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        jieruguanliService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JieruguanliEntity jieruguanli,
		HttpServletRequest request){
        EntityWrapper<JieruguanliEntity> ew = new EntityWrapper<JieruguanliEntity>();

		PageUtils page = jieruguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jieruguanli), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JieruguanliEntity jieruguanli, 
		HttpServletRequest request){
        EntityWrapper<JieruguanliEntity> ew = new EntityWrapper<JieruguanliEntity>();

		PageUtils page = jieruguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jieruguanli), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JieruguanliEntity jieruguanli){
       	EntityWrapper<JieruguanliEntity> ew = new EntityWrapper<JieruguanliEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jieruguanli, "jieruguanli")); 
        return R.ok().put("data", jieruguanliService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JieruguanliEntity jieruguanli){
        EntityWrapper< JieruguanliEntity> ew = new EntityWrapper< JieruguanliEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jieruguanli, "jieruguanli")); 
		JieruguanliView jieruguanliView =  jieruguanliService.selectView(ew);
		return R.ok("查询接入管理成功").put("data", jieruguanliView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JieruguanliEntity jieruguanli = jieruguanliService.selectById(id);
        return R.ok().put("data", jieruguanli);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JieruguanliEntity jieruguanli = jieruguanliService.selectById(id);
        return R.ok().put("data", jieruguanli);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JieruguanliEntity jieruguanli, HttpServletRequest request){
    	jieruguanli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jieruguanli);
    	JieruguanliEntity u = jieruguanliService.selectOne(new EntityWrapper<JieruguanliEntity>().eq("jieruzhanghao", jieruguanli.getJieruzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		jieruguanli.setId(new Date().getTime());
        jieruguanliService.insert(jieruguanli);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JieruguanliEntity jieruguanli, HttpServletRequest request){
    	jieruguanli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jieruguanli);
    	JieruguanliEntity u = jieruguanliService.selectOne(new EntityWrapper<JieruguanliEntity>().eq("jieruzhanghao", jieruguanli.getJieruzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		jieruguanli.setId(new Date().getTime());
        jieruguanliService.insert(jieruguanli);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JieruguanliEntity jieruguanli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jieruguanli);
        jieruguanliService.updateById(jieruguanli);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jieruguanliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JieruguanliEntity> wrapper = new EntityWrapper<JieruguanliEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = jieruguanliService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
