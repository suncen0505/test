import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import junit.framework.Assert;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.junit.Test;

import com.suncen.test.HomeController;
import com.suncen.test.Memched;
import com.suncen.test.mybatis.model.Game;
import com.suncen.test.mybatis.model.GameServer;


public class JUnitTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testmemchedAdd() throws TimeoutException, InterruptedException, MemcachedException, IOException
	{
		HomeController  homeclass=new HomeController();
		homeclass.addgameinfo();
		Game info=new Game();		
		String name=Memched.getInstance().get("key");
		info.setName(name);
		Assert.assertNotNull(info); 
	}
	
	@Test
	public void testmemchedEdit() throws TimeoutException, InterruptedException, MemcachedException, IOException
	{
		HomeController  homeclass=new HomeController();
		homeclass.updategameinfo();
		Game info=new Game();		
		String name=Memched.getInstance().get("key");
		info.setName(name);
		Assert.assertNotNull(info); 
	}
	@Test
	public void testmemchedGet() throws TimeoutException, InterruptedException, MemcachedException, IOException
	{
		HomeController  homeclass=new HomeController();		
		List<GameServer> list=	homeclass.selectserver(1);	
		Assert.assertNotNull(list); 
	}
}
