package com.fenlibao.p2p.service;

import com.fenlibao.p2p.model.entity.*;
import com.fenlibao.p2p.model.entity.activity.AutoRegist;
import com.fenlibao.p2p.model.enums.VersionTypeEnum;
import com.fenlibao.p2p.model.form.BindIdCardForm;
import com.fenlibao.p2p.model.form.ModifyPasswordForm;
import com.fenlibao.p2p.model.form.RegisterForm;
import com.fenlibao.p2p.model.form.RetrievePasswordForm;
import com.fenlibao.p2p.model.form.user.Auth;
import com.fenlibao.p2p.model.global.BaseRequestForm;
import com.fenlibao.p2p.model.global.HttpResponse;
import com.fenlibao.p2p.model.global.ResponseCode;
import com.fenlibao.p2p.model.vo.*;
import com.fenlibao.p2p.model.vo.channel.RegisterChannelVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserInfoService {

    /**
     * 发放注册奖励
     *
     * @param phoneNum
     * @param userId
     */
    void grantAwardRegister(String phoneNum, String userId);

    /**
     * 首次登陆发放注册奖励
     *
     * @param phoneNum
     * @param userId
     */
    void grantAwardFirstLogin(String phoneNum, String userId);

    /**
     * 根据手机号或登陆名查询用户信息
     *
     * @param map
     * @return
     */
    UserInfo getUserInfoByPhoneNumOrUsername(Map<String, Object> map);

    /**
     * 绑定银行卡
     *
     * @param bindIdCardForm
     * @return
     */
    boolean bindIdCard(BindIdCardForm bindIdCardForm) throws Throwable;

    /**
     * 用户资产信息
     *
     * @param userId
     * @param yesterdayDate
     * @return
     */
    UserAssetInfoVO getUserAssetInfo(String userId, Date yesterdayDate);
    /**
     * 用户资产信息
     *
     * @param userId
     * @param yesterdayDate
     * @return
     */
    UserAssetInfoVO getUserAssetInfo(String userId);

    /**
     * 找回密码
     *
     * @param retrievePasswordForm
     * @return
     */
    HttpResponse retrievePassword(RetrievePasswordForm retrievePasswordForm);

    /**
     * 用户登录过系统，设置用户第一次登陆状态
     * @param userId
     * @return
     */
    boolean updateUserFirstLoginState(int userId);

    /**
     * 判断用户是否第一次登陆
     * @param userId
     * @return
     */
    boolean isUserFirstLogin(int userId);

    /**
     * 获取用户账户信息
     *
     * @param userId
     * @return
     */
    UserAccountInfoVO getUserAccountInfo(String userId);

    /**
     * 设置用户名
     */
    HttpResponse setUserName(String userId, String userName) throws Exception;

    /**
     * 根据手机号或用户名获取用户个数
     *
     * @param paramMap
     * @return
     */
    int getUserCount(Map paramMap);

    /**
     * 普通注册
     *
     * @param registerForm
     * @return
     */
    UserInfo register(BaseRequestForm baseRequestForm, RegisterForm registerForm) throws Exception;

    /**
     * 获取用户账户信息
     *
     * @param username
     * @param phoneNum
     * @return
     */
    UserAccountInfoVO getUserAccountInfoByPhoneNumOrUsername(String username, String phoneNum);


    /**
     * 修改密码
     *
     * @param modifyPasswordForm
     * @return
     */
    HttpResponse modifyPassword(ModifyPasswordForm modifyPasswordForm);

    /**
     * 验证手机号是否存在
     *
     * @param phone
     * @return
     */
    boolean checkPhone(String phone);

    /**
     * 更新用户手机安全认证
     *
     * @param phone
     * @param userId
     * @param status
     */
    void updatePhoneSecurity(String phone, String userId, String status);

    /**
     * 更新用户邮箱安全认证
     *
     * @param email
     * @param userId
     * @param status
     */
    void updateEmailSecurity(String email, String userId, String status);

    /**
     * 获取验证错误次数
     *
     * @param sendType
     * @param sendTo
     * @return
     */
    int matchVerifyCodeErrorCount(int sendType, String sendTo);

    /**
     * 添加验证错误记录
     *
     * @param checkError
     */
    void insertMatchVerifyCodeError(CheckError checkError);

    /**
     * 验证email是否存在
     *
     * @param email
     * @return
     */
    boolean checkEmail(String email);

    /**
     * 添加邮件发送记录
     *
     * @param email
     */
    void insertSendEmail(String userId, String email, String resource);

    /**
     * 获取用户发送邮件记录
     *
     * @param type
     * @param userId
     * @return
     */
    SendEmail getLastEmail(String type, String userId);

    /**
     * 获取用户安全认证信息
     *
     * @param userId
     * @return
     */
    UserSecurityAuthentication getUserSecurity(String userId);

    /**
     * 用户上传头像
     */
    String uploadUserPic(int userId, MultipartFile file, int type, String userPicUrl) throws IOException;

    /**
     * 发送短信
     *
     * @param phoneNum
     * @param type
     */
    void sendVerifySms(String phoneNum, int type, String userId,String userIp);

    /**
     * 用户当天发送短信的次数
     *
     * @param userId
     * @param type
     * @return
     */
	int getSendPhoneCount(String phone, int type);

    /**
     * 获取用户信息
     *
     * @param phoneNum
     * @param email
     * @return
     */
    UserInfo getUser(String phoneNum, String email, String userId);

    /**
     * @param phoneNum
     * @param type
     * @return
     */
    SmsValidcode getLastSmsCode(String phoneNum, String type);

    /**
     * 验证手机验证码
     *
     * @param phoneNum
     * @param type
     * @param SmsCode
     * @return 如果正确返回 null，其他返回相应的状态码
     */
    ResponseCode verifySmsCode(String phoneNum, String type, String SmsCode);

    /**
     * 修改昵称
     *
     * @param userId
     * @param nickname
     * @return
     */
    HttpResponse modifyNickName(Integer userId, String nickname);

    /**
     * 验证接口(银行卡删除,手机邮箱第三方账号解绑验证)
     *
     * @param userId
     * @param password
     * @return
     */
    boolean verify(Integer userId, String password) throws Exception;

    /**
     * 获取用户的消息
     *
     * @param userId
     * @param timestamp
     * @param isUp
     * @return
     */
    List<PrivateMessage> getUserMessage(String userId, String timestamp, String isUp, VersionTypeEnum versionType);


    /**
     * 获取平台信息(产品信息、总投资、总收益)
     * @param userId    用户ID
     * @param userInvalid 用户未登录状态
     * @return
     */
    PlatformInfoVo getPlatformInfo(String userId,boolean userInvalid);

    /**
     * 获取开店宝计划列表
     *
     * @return
     */
    List<ShopTreasureVo> getShopTreasureList(String time, String userId, String isUp);

    /**
     * 开店宝计划详情
     *
     * @param id
     * @param userId
     * @return
     */
    ShopTreasureInfoVo getShopTreasureInfo(String id, String userId);


    /**
     * 获取用户登录密码
     *
     * @param userId
     * @return
     */
    String getLoginPassword(int userId);

    /**
     * 练练 实名认证 记录保存
     *
     * @param authMap
     */
    void insertlianLianAuth(Map authMap) throws Exception;

    /**
     * 获取保存的实名记录的错误
     *
     * @param userName
     */
    int getUserLoginError(String userName) throws Exception;

    /**
     * 获取连连实名认证的记录次数
     *
     * @param id
     */
    int getUserAuthError(int id) throws Exception;

    /**
     * 更新的实名记录的错误
     *
     * @param userName
     */
    void updateUserLoginError(String userName, String addr) throws Exception;

    /**
     * 获取用户账户信息字段Map
     */
    Map<String, Object> getUserAccountInfoDataMap(UserAccountInfoVO userAccountInfoVO,int versiongControl);

    /**
     * 获取用户账户基础信息字段Map
     */
    Map<String, Object> getUserBaseAccountInfoDataMap(UserAccountInfoVO userAccountInfoVO,int versiongControl);

    /**
     * 获取用户消息数量
     *
     * @param userId
     * @return
     */
    int getUserMessageCount(String userId, String status, VersionTypeEnum vte);
    
    /**
     * 修改用户消息状态
     * @param messageIds 多个ID用英文逗号拼接
     * @param userId     用户ID
     * @param status     状态：WD:未读;YD:已读;SC:删除
     */
    void updateUserMessageStatus(String messageIds,int userId,String status);
    
	/**
	 * 验证身份证
	 * @param identityNo 身份证号码
	 * @param identityName 身份证姓名
	 * @return
	 */
	boolean verifyIdentity(String identityNo, String identityName, Integer userId) throws Throwable;
	
	/**
	 * 获取用户认证状态
	 * <p>手机认证、实名认证、是否设置交易密码
	 * @param userId
	 * @return
	 */
	Auth getAuthStatus(int userId);
	
	/**
	 * 获取可投资的标的信息列表
	 * @return
	 */
	List<ShopTreasureInfo> getCanInvestBidList();

    UserInfo getUserInfo(String phoneNum);

    /**
	 * 获取开店宝计划列表
	 * @param time
	 * @param status   标的状态(必传)
	 * @param proType  产品类型(必传)
	 * @param limit    获取记录数
	 * @param isNoviceStandard  是否是新手标(S/F 必传)
	 * @return
	 */
	List<ShopTreasureInfo> getBidList(String time,String[] status,String proType,int limit,String isNoviceBid);

	/**
	 * 根据IP或phone获取半小时或一天内的发送次数
	 * @param userIp    用户IP
	 * @param phoneNum  用户手机号
	 * @param halfhour  半小时内
	 * @param day       一天内
	 * @return   发送次数
	 */
    public int getSendSmsCount(String userIp,String phoneNum,Date halfhour,Date day);
    
    /**
     * for version 1.3.1+
     * 获取用户资产
     * @param userId
     * @return
     */
    Map<String, Object> getUserAssets(Integer userId);
    
    /** 
     * @Title: getUserAccount 
     * @Description:获取用户账户余额
     * @param userId
     * @param accountType
     * @return
     * @return: UserAccount
     **/
    UserAccount getUserAccount(String userId, String accountType);

    /**
     * 获取用户注册渠道信息
     * @param userId
     * @return
     */
    RegisterChannelVO getChannelInfo(int userId);

    /**
     * 获取用户资产总额
     * @param userId
     * @return
     */
    BigDecimal getUserTotalAssets(int userId);
    /**
     * 获取用户累计投资金额
     * @param userId
     * @return
     */
//    BigDecimal getUserInvestAmount(int userId);

    /**
     * @Title: getUserInfo
     * @Description: 获取用户信息
     * @param userId
     * @return
     * @return: UserInfo
     */
    UserInfo getUserInfo(int userId);

    /**
     * 获取用户服务协议
     * @param userId
     * @return
     */
    String getUserServiceAgreementUrl(int userId);

    /**
     * 校验是否可随时退出标白名单用户
     * @param userId
     * @return
     */
    int checkWhiteBoard(Integer userId);

    /**
     * 获取用户的Baofoo银行卡的信息
     * @param userId
     * @return
     */
    List<Map<String,Object>> getUserBaofooCardInfo(Integer userId);

    /**
     * 获取用户计划服务协议
     * @param userId
     * @return
     */
    String getUserServicePlanAgreementUrl(int userId,String isNovice,String planType);

    /**
     * 判断用户存管是否开户 0：否 ， 》=1：已开户
     * @param
     * @return
     */
    String isXWaccount(int userId);

    /**
     * for version 1.3.1+
     * 获取用户资产
     * @param userId
     * @return
     */
    Map<String, Object> getUserAssetsByXW(Integer userId);

    /**
     * 获取存管银行卡信息
     * @param userId
     * @return
     */
    Map<String, Object> getXWCardInfo(Integer userId);

    /**
     * 获取用户的基础信息
     * @param userId
     * @return
     */
    UserBaseInfo getuserBaseInfo(Integer userId);

    /**
     * 获取待确认新网存管用户编号（投资用户）
     */
    List<PlatformUser> getPlatformUserNo(String status,int limit);

    /**
     * 获取用户计划服务协议(区分存管版)
     * @param userId
     * @return
     */
    String getUserServicePlanAgreementUrlByCG(int userId,String isNovice,String planType);

    /**
     * 获取企业用户信息
     * @param userId
     * @return
     */
    Map<String, Object> getEnterpriseInfo(Integer userId);

    /**
     * 自动注册
     *
     * @param registerForm
     * @return
     */
    UserInfo autoRegister(BaseRequestForm baseRequestForm, RegisterForm registerForm, AutoRegist autoRegist) throws Exception;
}
