package com.taotaoti.common.vo;

public class ReturnFileUpVo {
	String delete_type;
	String delete_url;
	String name;
	int size;
	String thumbnail_url ;
	String type;
	String url;
	String error;
//	String delete_type = "DELETE";
//	String delete_url = "http://suricloud.co/server/php/?file=400x300.jpg";
//	String name = "400x300.jpg";
//	int size = 33999;
//	String thumbnail_url = "http://suricloud.co/server/php/files/thumbnail/400x300.jpg";
//	String type = "image/jpeg";
//	String url = "http://suricloud.co/server/php/files/400x300.jpg";
//	String error="请登录";
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getDelete_type() {
		return delete_type;
	}
	public void setDelete_type(String delete_type) {
		this.delete_type = delete_type;
	}
	public String getDelete_url() {
		return delete_url;
	}
	public void setDelete_url(String delete_url) {
		this.delete_url = delete_url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getThumbnail_url() {
		return thumbnail_url;
	}
	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
