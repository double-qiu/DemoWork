/**  
 * Project Name:TestWork  
 * File Name:package-info.java  
 * Package Name:com.ufdouble.demo.testwork.service.impl  
 * Date:2016年7月6日下午2:22:46  
 * Copyright (c) 2016, FengYunTec All Rights Reserved.  
 *  
 */
/**  
 * ClassName: package-info  
 * (TODO:简述该类作用)
 * @author DOUBLE
 * @version   
 */
package com.ufdouble.demo.testwork.service.impl;

import java.util.List;

import com.ufdouble.demo.testwork.dao.BookMarket;
import com.ufdouble.demo.testwork.model.Book;
import com.ufdouble.demo.testwork.service.BuyBook;
/**
 * ClassName: BuyBookImpl  
 * 接口业务实现
 * @author DOUBLE
 * @version
 */
public class BuyBookImpl implements BuyBook {

	@Override
	public double getBookTotalPrice(List<Book> books,BookMarket bookMarket) {
		Double result = 0.0;
		if (books == null || books.size() == 0) 
			return  result;
		for (Book book : books) {
			if(book == null)  continue;
			result += (bookMarket.getPrice(book.getName()) * book.getNumber());
		}
		return result;
	}
	
} 