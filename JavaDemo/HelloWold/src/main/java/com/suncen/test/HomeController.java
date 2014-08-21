package com.suncen.test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.exception.MemcachedException;


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



//import com.suncen.test.mybatis.inter.IOperation;
import com.suncen.test.mybatis.model.Game;
import com.suncen.test.mybatis.model.GameServer;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	List<Game> gamelist=Test.GetGamesList();
	model.addAttribute("gamelist",gamelist);
		return "home";
	}

	@ResponseBody
	@RequestMapping(value = "/selectserver", method = RequestMethod.GET)
	public   List<GameServer> selectserver(@RequestParam("gameId") int gameId)
	{
		List<GameServer> list=Test.GetserverList(gameId);
		return list;
		
	}
	
	/**
	 * @RequestParam("gamename") String gamename
	 * @throws IOException 
	 * @throws MemcachedException 
	 * @throws InterruptedException 
	 * @throws TimeoutException 
	 * **/
	
	@ResponseBody
	@RequestMapping(value = "/addgameinfo", method = RequestMethod.GET)
	public   void addgameinfo() throws TimeoutException, InterruptedException, MemcachedException, IOException
	{
		String gamename="测试你好";
		int code=85;
		Test.AddGameInfo(code,gamename);	
		Memched.getInstance().set("key",3600,gamename);
	}
	
	/**
	 * @RequestParam("gamename") String gamename
	 * @throws IOException 
	 * @throws MemcachedException 
	 * @throws InterruptedException 
	 * @throws TimeoutException 
	 * **/
	
	@ResponseBody
	@RequestMapping(value = "/updategameinfo", method = RequestMethod.GET)
	public   void updategameinfo() throws TimeoutException, InterruptedException, MemcachedException, IOException
	{
		String gamename="测试你好";
		int code=1;
		Test.UpdateGameInfo(code,gamename);		
		 Object getSomeObject = Memched.getInstance().get("key");
		 Memched.getInstance().delete("key");
		 Memched.getInstance().set("key",3600,gamename);
	}
	
	
	
}



