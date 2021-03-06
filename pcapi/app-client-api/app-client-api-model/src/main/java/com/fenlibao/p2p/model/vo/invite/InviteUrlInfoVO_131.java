/**   
 * Copyright © 2015 fenlibao.com. All rights reserved.
 * 
 * @Title: InviteUrlInfo.java 
 * @Prject: app-client-api-model
 * @Package: com.fenlibao.p2p.model.vo.invite 
 * @Description: TODO
 * @author: laubrence  
 * @date: 2015-11-10 下午9:23:05 
 * @version: V1.1   
 */
package com.fenlibao.p2p.model.vo.invite;

/** 
 * @ClassName: InviteUrlInfo 
 * @Description: TODO
 * @author: laubrence
 * @date: 2015-11-10 下午9:23:05  
 */
public class InviteUrlInfoVO_131 {
	
	public String inviteUrl;  //web邀请url
	
	private String invitePicUrl;//邀请信息中的小图标
	
	private String friendShareInviteTitle;//好友分享邀请信息标题
	
	private String friendShareInviteMsg;//好友分享邀请信息
	
//	public String friendCircleInviteMsg; //朋友圈邀请信息
	
	public int isSmrz; //是否实名认证
	
//	public String phoneSmsInviteMsg;//手机短信信息

	public String getInviteUrl() {
		return inviteUrl;
	}

	public void setInviteUrl(String inviteUrl) {
		this.inviteUrl = inviteUrl;
	}

	public String getInvitePicUrl() {
		return invitePicUrl;
	}

	public void setInvitePicUrl(String invitePicUrl) {
		this.invitePicUrl = invitePicUrl;
	}

	public String getFriendShareInviteTitle() {
		return friendShareInviteTitle;
	}

	public void setFriendShareInviteTitle(String friendShareInviteTitle) {
		this.friendShareInviteTitle = friendShareInviteTitle;
	}

	public String getFriendShareInviteMsg() {
		return friendShareInviteMsg;
	}

	public void setFriendShareInviteMsg(String friendShareInviteMsg) {
		this.friendShareInviteMsg = friendShareInviteMsg;
	}

//	public String getFriendCircleInviteMsg() {
//		return friendCircleInviteMsg;
//	}
//
//	public void setFriendCircleInviteMsg(String friendCircleInviteMsg) {
//		this.friendCircleInviteMsg = friendCircleInviteMsg;
//	}

	public int getIsSmrz() {
		return isSmrz;
	}

	public void setIsSmrz(int isSmrz) {
		this.isSmrz = isSmrz;
	}

//	public String getPhoneSmsInviteMsg() {
//		return phoneSmsInviteMsg;
//	}
//
//	public void setPhoneSmsInviteMsg(String phoneSmsInviteMsg) {
//		this.phoneSmsInviteMsg = phoneSmsInviteMsg;
//	}

}
