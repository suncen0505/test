package com.suncen.test;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;















import java.util.concurrent.TimeoutException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

import org.junit.runner.Request;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;


import org.springframework.web.context.request.RequestScope;



import org.springframework.web.servlet.ModelAndView;











//import com.suncen.test.mybatis.inter.IOperation;
import com.suncen.test.mybatis.model.Game;
import com.suncen.test.mybatis.model.GameServer;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/LoginView", method = RequestMethod.GET)
	public String LoginView(Locale locale, Model model) {
		
	return "LoginView";
	}
	@ResponseBody
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public   ModelAndView  Login(HttpServletResponse response,HttpServletRequest request,@RequestParam("UserName") String UserName,@RequestParam("PassWord") String PassWord)
	{
		 ModelAndView modelAndView = new ModelAndView();
	       modelAndView.setViewName( "/home" );
	       List<Game> gamelist=Test.GetGamesList();
	       modelAndView.addObject("gamelist",gamelist);
	       modelAndView.addObject("UserName",Common.encodeStr(UserName));
	       modelAndView.addObject("PassWord",Common.encodeStr(PassWord));
	       //Cookie cookie = new Cookie("UserName", Common.encodeStr(UserName));
	      // cookie = new Cookie("PassWord", Common.encodeStr(PassWord));
	       //response.addCookie(cookie); 
	      // MemcachedClientBuilder builder = new XMemcachedClientBuilder(  
	       //          AddrUtil.getAddresses("localhost:8080")); 
	       // try {
	       //MemcachedClient memcachedClient  = builder.build();
	       //memcachedClient.set ("UserName" , 0, Common.encodeStr(UserName));
	       //memcachedClient.set ("PassWord" , 0, Common.encodeStr(PassWord));
	       //    String UserNames = memcachedClient. get ( "UserName" );
	       //   String PassWords = memcachedClient. get ( "PassWord" );
	       //   memcachedClient.shutdown();
	       //} catch (IOException e) {
			// TODO Auto-generated catch block
	       //e.printStackTrace();
	       //} catch (TimeoutException e) {
			// TODO Auto-generated catch block
	       //e.printStackTrace();
	       //} catch (InterruptedException e) {
			// TODO Auto-generated catch block
	       //e.printStackTrace();
	       //} catch (MemcachedException e) {
			// TODO Auto-generated catch block
	       //e.printStackTrace();
	       //}
	      
	       
	       return modelAndView;		
	}
	
	
	@RequestMapping(value = "/MemchedView", method = RequestMethod.GET)
	public String MemchedView(Locale locale, Model model) {
		
	return "MemchedView";
	}
}




