package com.taotaoti.common.generic.dao.operator;

/**
 * 排序
 */
public class Order implements Pair{
	
	private String column;
	
	private boolean asc;

	/**
	 * @param column
	 * @param asc
	 */
	public Order(String column, boolean asc) {
		this.column = column;
		this.asc = asc;
	}
	
	public boolean isAsc(){
		return asc;
	}

	/* (non-Javadoc)
	 * @see com.baidu.ub.common.generic.dao.operator.Pair#getColumn()
	 */
	@Override
	public String getColumn() {
		return column;
	}

	/* (non-Javadoc)
	 * @see com.baidu.ub.common.generic.dao.operator.Pair#getValue()
	 */
	@Override
	public Object getValue() {
		return asc;
	}

}
