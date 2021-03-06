package com.fenlibao.p2p.controller.v_3.v_3_0_0.experiencegold;

import com.fenlibao.p2p.model.form.experiencegold.ExperienceGoldEarningsForm;
import com.fenlibao.p2p.model.global.*;
import com.fenlibao.p2p.service.experiencegold.IExperienceGoldService;
import com.fenlibao.p2p.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 体验金控制器
 * @author yangzengcai
 * @date 2015年11月18日
 */
@RestController("v_3_0_0/ExperienceGoldController")
@RequestMapping(value = "experience/gold", headers = APIVersion.v_3_0_0)
public class ExperienceGoldController {

	private static final Logger logger = LogManager.getLogger(ExperienceGoldController.class);

	@Resource
	private IExperienceGoldService experienceGoldService;

	/**
	 * 用户体验金列表
	 * @param params
	 * @param timestamp
	 * @param isUp
	 * @param type
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	HttpResponse list(@ModelAttribute BaseRequestFormExtend params,
					  String timestamp, Integer isUp, Integer type, Integer status,String yieldStatus) {
		HttpResponse response = new HttpResponse();
		if (!params.validate() || isUp == null || status == null) {
			response.setCodeMessage(ResponseCode.EMPTY_PARAM
					);
			return response;
		}

		//获取体验金列表
		Map<String,Object> mapData = new HashMap<>();
		try {
			//根据条件查询体验金
			Map<String,Object> paramMap = new HashMap<>();
			paramMap.put("userId",params.getUserId());
			paramMap.put("status",status);
			paramMap.put("isUp", isUp);
			if(!StringUtils.isBlank(yieldStatus)){
				if("1".equals(yieldStatus)){
					paramMap.put("yieldStatus",InterfaceConst.EXPERIENCEGOLD_WJX_STATUS);
				}else if("2".equals(yieldStatus)){
					paramMap.put("yieldStatus",InterfaceConst.EXPERIENCEGOLD_JXZ_STATUS);
				}else if("3".equals(yieldStatus)){
					paramMap.put("yieldStatus",InterfaceConst.EXPERIENCEGOLD_YWC_STATUS);
				}
			}
			if(type != null){
				paramMap.put("type",type);
			}
			if(!StringUtils.isBlank(timestamp)){
				Date time = DateUtil.timestampToDate(Long.valueOf(timestamp));
				paramMap.put("time",time);
			}

			List userExperienceGolds = experienceGoldService.getExperienceGolds(paramMap);
			mapData.put("list",userExperienceGolds);
			response.setData(mapData);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			response.setCodeMessage(ResponseCode.FAILURE );
		}
		return response;
	}

	/**
	 * 体验金详情
	 * @param params
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	HttpResponse detail(@ModelAttribute BaseRequestFormExtend params,
						Integer status) {
		HttpResponse response = new HttpResponse();
		Map<String, Object> data = new HashMap<>();
		if (!params.validate() || status == null) {
			response.setCodeMessage(ResponseCode.EMPTY_PARAM
					);
			return response;
		}
		try {
			data = experienceGoldService.getDetail(params.getUserId(), status);
			response.setData(data);
		} catch (Exception e) {
			response.setCodeMessage(ResponseCode.FAILURE
					);
			logger.error(e.toString(), e);
		}
		return response;
	}


	/**
	 * 体验金收益列表
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/earnings/list", method = RequestMethod.GET)
	HttpResponse earnings(@ModelAttribute BaseRequestFormExtend params,
						  String timestamp) {
		HttpResponse response = new HttpResponse();
		Map<String, Object> data = new HashMap<>();
		List<ExperienceGoldEarningsForm> list;
		if (!params.validate()) {
			response.setCodeMessage(ResponseCode.EMPTY_PARAM
					);
			return response;
		}
		try {
			if (StringUtils.isBlank(timestamp) 
					|| "null".equalsIgnoreCase(timestamp)) {
				timestamp = null;
			}
			list = experienceGoldService.getEarningsList(params.getUserId(), timestamp);
			data.put("experienceGoldEarningsList", list);
			response.setData(data);
		} catch (Exception e) {
			response.setCodeMessage(ResponseCode.FAILURE
					);
			logger.error(e.toString(), e);
		}
		return response;
	}

	/**
	 * 体验金累计收益
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/earnings/total", method = RequestMethod.GET)
	HttpResponse totalEarnings(@ModelAttribute BaseRequestFormExtend params) {
		HttpResponse response = new HttpResponse();
		BigDecimal totalEarnings;
		Map<String, Object> data = new HashMap<>();
		if (!params.validate()) {
			response.setCodeMessage(ResponseCode.EMPTY_PARAM
					);
			return response;
		}
		try {
			totalEarnings = experienceGoldService.getTotalEarnings(params.getUserId());
			data.put("amount", totalEarnings.toString());
			response.setData(data);
		} catch (Exception e) {
			response.setCodeMessage(ResponseCode.FAILURE
					);
			logger.error(e.toString(), e);
		}

		return response;
	}

}
