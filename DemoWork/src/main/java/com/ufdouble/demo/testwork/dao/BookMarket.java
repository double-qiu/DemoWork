package com.ufdouble.demo.testwork.dao;

/**
 * ClassName: BookMarket  
 * 外部接口
 * @author DOUBLE
 * @version
 */
public interface BookMarket {
	/**
	 *  getPrice:获取书的价格
	 *  @return_type:Double
	 *  @author DOUBLE
	 *  @param bookName
	 *  @return
	 */
	public Double getPrice(String bookName);
}
