package com.fenlibao.p2p.model.vo.notice;

import java.util.Date;
/** 
 * @author: junda.feng
 */
public class ArticleVo {
	
	public Integer articleId;

    public String articleTitle;//文章标题f06

    public String source;//来源07
    
    public String introduction;//文章摘要08

	public Date publishTime;//发布时间12

	public String imgUrl;//封面图片文件编码09
	
	public String articleDetailUrl; //详情

	public String channel;//媒体渠道

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getArticleDetailUrl()
	{
		return articleDetailUrl;
	}

	public void setArticleDetailUrl(String articleDetailUrl)
	{
		this.articleDetailUrl = articleDetailUrl;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}