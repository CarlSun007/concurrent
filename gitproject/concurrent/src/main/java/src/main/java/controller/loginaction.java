package src.main.java.controller;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class loginaction {
    
	String reponse1,reponse2,time1,time2,URL;
	boolean first=true;
	public static String URL1;
	
	bingfafengzhuang t0=new bingfafengzhuang();  
	bingfafengzhuang t1=new bingfafengzhuang();  
	
    @RequestMapping("click.do")
    public void click(String URL1,ModelMap model) throws ClientProtocolException, IOException{
    	
    	   System.out.println(URL1 +" 登录成功");
       
    }  
    @RequestMapping("post.do")
    public String post(String PostURL,String writer,ModelMap model) throws ClientProtocolException, IOException{
    	 t0.setposturl(PostURL);
         t1.setposturl(PostURL);
    	   System.out.println(PostURL +" 登录成功"+writer);
    	   return "ok";
       
    }    
    
    @RequestMapping("param.do")
    public String param(String Param,String ParamValue,ModelMap model) throws ClientProtocolException, IOException{
     	t0.addparam(Param, ParamValue);
    	t1.addparam(Param, ParamValue);
    	   System.out.println(Param +" 登录成功"+ParamValue);
    	   return "ok";
       
    }   
    @RequestMapping("paramdone.do")
    public String paramdone(String PostURL,String Param,String ParamValue,ModelMap model) throws ClientProtocolException, IOException{
     	t0.addparam(Param, ParamValue);
    	t1.addparam(Param, ParamValue);
    	
 	   System.out.println(Param +" 登录成功1"+ParamValue+PostURL);

    	 t0.setposturl(PostURL);
         t1.setposturl(PostURL);
         
         System.out.println(t0.getparam() +" 登录成功2"+t0.getposturl());

         
    	 t0.posturl(t0.getposturl());
         t1.posturl(t1.getposturl());
         
         t0.clearparam(t0.getparam());
         t1.clearparam(t1.getparam());
         
    	   System.out.println(Param +" 登录成功3"+ParamValue+PostURL);
    	   return "ok";
       
    }  
    
    @SuppressWarnings("deprecation")
	@RequestMapping("bing.do")
    public String bing(String Param,String ParamValue,String BingURL,ModelMap model) throws ClientProtocolException, IOException, InterruptedException{
     
    	
    	t0.addparam(Param, ParamValue);
    	t0.addparam("", "");
    	t1.addparam(Param, ParamValue);
    	t1.addparam("", "");
    	
    	
    	
    	 t0.setposturl(BingURL);
         t1.setposturl(BingURL);
         
    	 System.out.println(t0.getparam() +" 登录成功2"+t0.getposturl()+t0.getsleep());
    	 
    	 if (first){
    	
     	
     	  t1.start();
          t0.start();
          first=false;
          Thread.sleep(1000);
          reponse1=t0.getresponseBody();
          reponse2=t1.getresponseBody();
          time1=t0.gettime();
          time2=t1.gettime();
        	
    	 }
    	 else {
    		 bingfafengzhuang t3=new bingfafengzhuang();  
    			bingfafengzhuang t4=new bingfafengzhuang();  
    			t3.httpclient=t0.httpclient;
    			t4.httpclient=t1.httpclient;
    			t3.nvps=t0.nvps;
    			t4.nvps=t1.nvps;
    			t3.setposturl(t0.getposturl());
    			t4.setposturl(t1.getposturl());
    			  t3.start();
    	          t4.start();
    	          Thread.sleep(1000);
    	          reponse1=t3.getresponseBody();
    	            reponse2=t4.getresponseBody();
    	            time1=t3.gettime();
    	            time2=t4.gettime();
    	 }
    	 
    	 //Thread.sleep(1000);
    	 
        
            
        	model.addAttribute("greeting", "thread 1 time "+time1+" reponse "+reponse1);
        	model.addAttribute("greeting1", "thread 2 time "+time2+" reponse "+reponse2);
            
        	 System.out.println(Param +" 登录成功"+ParamValue);
        	 
        	 System.out.println(t0.getparam() +" 登录成功2"+t0.getposturl()+t0.getsleep());
             
        	  t0.clearparam(t0.getparam());
              t1.clearparam(t1.getparam());
        	 
             
        	 return "loginSuccess";//逻辑视图名       跳转页面默认为转发
    	  
    	//   return "ok";
       
    }    
    
}