package com.mereking.meretool.common;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
// http://www.tuicool.com/articles/7rMziy
public class BaseTest {
	protected MockHttpServletRequest request;
	protected MockHttpServletResponse response;
	
	@Before
	public void setUp() {
		request = new MockHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
		response = new MockHttpServletResponse();
	}
	
	/**
	 * 默认测试案例
	 */
	@Test
	public void test(){
		Assert.assertEquals("", "");
	}

}
