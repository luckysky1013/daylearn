package com.data.jpa.base;

import java.io.Serializable;

/**
 * @author liujian
 * @date 2018/6/5
 */
public class BaseEntity implements Serializable{

	protected int offset=1;

	protected int limit=10;

	protected String sidx="id";

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
}
