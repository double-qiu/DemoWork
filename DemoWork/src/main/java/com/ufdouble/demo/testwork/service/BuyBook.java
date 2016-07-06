package com.ufdouble.demo.testwork.service;

import java.util.List;

import com.ufdouble.demo.testwork.dao.BookMarket;
import com.ufdouble.demo.testwork.model.Book;

/**
 * ClassName: buyBook  
 * 业务接口
 * @author DOUBLE
 * @version
 */
public interface BuyBook {
	
	/**
	 *  getBookTotalPrice:获取总价
	 *  @return_type:double
	 *  @author DOUBLE
	 *  @return
	 */
	public double getBookTotalPrice(List<Book> books,BookMarket bookMarket);

}
