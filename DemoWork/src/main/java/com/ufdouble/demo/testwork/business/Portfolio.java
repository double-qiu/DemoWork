package com.ufdouble.demo.testwork.business;

import java.util.ArrayList;
import java.util.List;

import com.ufdouble.demo.testwork.dao.BookMarket;
import com.ufdouble.demo.testwork.model.Book;
import com.ufdouble.demo.testwork.service.BuyBook;
import com.ufdouble.demo.testwork.service.impl.BuyBookImpl;

/**
 * ClassName: Portfolio  
 * 书单类
 * @author DOUBLE
 * @version
 */
public class Portfolio {
	
	private BookMarket bookMarket;
	List<Book> books = new ArrayList<Book>();
	
	/**
	 *  getBookTotalPrice:获取总价的业务方法
	 *  @return_type:String
	 *  @author DOUBLE
	 *  @return
	 */
	public String getBookTotalPrice() {
		BuyBook buyBook = new BuyBookImpl();
		double bookTotalPrice = buyBook.getBookTotalPrice(books, bookMarket);
		return String.valueOf(bookTotalPrice);
	}
	/**
	 *  setBookMarket:mock类注入
	 *  @return_type:void
	 *  @author DOUBLE
	 *  @param bookMarket
	 */
	public void setBookMarket(BookMarket bookMarket) {
		this.bookMarket = bookMarket;
	}
	/**
	 *  addBook:添加书单
	 *  @return_type:void
	 *  @author DOUBLE
	 *  @param book
	 */
	public void addBook(Book book) {
		books.add(book);
	}
}
