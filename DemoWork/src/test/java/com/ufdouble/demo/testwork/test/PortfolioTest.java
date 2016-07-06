package com.ufdouble.demo.testwork.test;


import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.ufdouble.demo.testwork.business.Portfolio;
import com.ufdouble.demo.testwork.dao.BookMarket;
import com.ufdouble.demo.testwork.model.Book;

/**
 * ClassName: PortfolioTest  
 * 业务逻辑单元测试
 * @author DOUBLE
 * @version
 */
public class PortfolioTest {

	private Portfolio portfolio;
	private BookMarket marketMock;

	@Before
	public void setUp() {
		portfolio = new Portfolio();
		marketMock = EasyMock.createMock(BookMarket.class);
		portfolio.setBookMarket(marketMock);
	}
	
	/**
	 *  testBuyBook_OneBook_numNotZero:二本书一样的书
	 *  @return_type:void
	 *  @author DOUBLE
	 */
	@Test
	public void testBuyBook_OneBook_numNotZero() {
		EasyMock.expect(marketMock.getPrice("JAVA")).andReturn(42.0);
		EasyMock.replay(marketMock);
		
		Book book = new Book("JAVA", 2);
		portfolio.addBook(book);
		
		assertEquals("84.0",portfolio.getBookTotalPrice());
	}
	/**
	 *  testBuyBook__OneBook_numZero:数量为0的书，现实情况不可能出现，但是代码业务中可能出现
	 *  @return_type:void
	 *  @author DOUBLE
	 */
	@Test
	public void testBuyBook__OneBook_numZero() {
		EasyMock.expect(marketMock.getPrice("JAVA")).andReturn(42.0);
		EasyMock.replay(marketMock);
		
		Book book = new Book("JAVA", 0);
		portfolio.addBook(book);
		
		assertEquals("0.0",portfolio.getBookTotalPrice());
	}
	/**
	 *  testBuyBook_emptyBook:没有添加书的情况
	 *  @return_type:void
	 *  @author DOUBLE
	 */
	@Test
	public void testBuyBook_emptyBook() {
		EasyMock.expect(marketMock.getPrice("JAVA")).andReturn(42.0);
		EasyMock.replay(marketMock);
		
		assertEquals("0.0",portfolio.getBookTotalPrice());
	}
	/**
	 *  testBuyBook_null:添加一本为空的书的情况
	 *  @return_type:void
	 *  @author DOUBLE
	 */
	@Test
	public void testBuyBook_null() {
		EasyMock.expect(marketMock.getPrice("JAVA")).andReturn(42.0);
		EasyMock.replay(marketMock);
		portfolio.addBook(null);
		assertEquals("0.0",portfolio.getBookTotalPrice());
	}
	/**
	 *  testBuyBook_nullAndBook1:添加两种不同的书,其中有一本说为空
	 *  @return_type:void
	 *  @author DOUBLE
	 */
	@Test
	public void testBuyBook_nullAndBook1() {
		EasyMock.expect(marketMock.getPrice("JAVA")).andReturn(42.0);
		EasyMock.replay(marketMock);
		Book book1 = new Book("JAVA", 2);
		portfolio.addBook(null);
		portfolio.addBook(book1);
		assertEquals("84.0",portfolio.getBookTotalPrice());
	}
	/**
	 * 
	 *  testBuyBook_diffTwoBook:添加两本不同的书
	 *  @return_type:void
	 *  @author DOUBLE
	 */
	@Test
	public void testBuyBook_diffTwoBook() {
		EasyMock.expect(marketMock.getPrice("JAVA")).andReturn(42.0);
		EasyMock.expect(marketMock.getPrice("Spring")).andReturn(31.0);
		EasyMock.replay(marketMock);
		
		Book book1 = new Book("JAVA", 2);
		Book book2= new Book("Spring", 1);
		portfolio.addBook(book1);
		portfolio.addBook(book2);
		
		assertEquals("115.0",portfolio.getBookTotalPrice());
	}
	/**
	 *  testBuyBook_diffTwoBookAndDesc:书的排序不同
	 *  @return_type:void
	 *  @author DOUBLE
	 */
	@Test
	public void testBuyBook_diffTwoBookAndDesc() {
		EasyMock.expect(marketMock.getPrice("JAVA")).andReturn(42.0);
		EasyMock.expect(marketMock.getPrice("Spring")).andReturn(31.0);
		EasyMock.replay(marketMock);
		
		Book book1 = new Book("JAVA", 2);
		Book book2= new Book("Spring", 1);
		portfolio.addBook(book2);
		portfolio.addBook(book1);
		
		assertEquals("115.0",portfolio.getBookTotalPrice());
	}
	
}
