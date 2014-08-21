package com.suncen.test;

import java.io.IOException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;

public class Memched {
	private static MemcachedClient client = null; 
	    private Memched() {  
	       // Exists only to defeat instantiation.  
	    }  
	   
	    public static MemcachedClient getInstance() throws IOException {  
	       if (client == null) {  
	    	   client = new XMemcachedClient("192.168.6.195",10001);
	       }  
	       return client;  
	    }  
}
