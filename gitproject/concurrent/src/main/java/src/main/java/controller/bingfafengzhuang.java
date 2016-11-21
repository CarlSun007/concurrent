package src.main.java.controller;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class bingfafengzhuang extends Thread{  
	
	private int a;
	boolean sleep=true;
	private String geturl1,geturl2,posturl;
	private String responseBody,time;
	CloseableHttpResponse responseBody1;
	static CookieStore cookieStore = null;
	
	
	
	
	
	 PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
	
	 
	 CloseableHttpClient httpclient=HttpClients.custom().setConnectionManager(cm).setConnectionManagerShared(true).setDefaultCookieStore(cookieStore).build();
	
	List <NameValuePair> nvps = new ArrayList <NameValuePair>();
	public void setgeturl1(String str){
		this.geturl1=str;
	}
	
	public void setgeturl2(String str){
		this.geturl2=str;
	}
	
	public void setposturl(String str){
		this.posturl=str;
	}
	
	
	public void setsleep(boolean str){
		this.sleep=str;
	}
	
	public boolean getsleep(){
		return this.sleep;
	}
	public String getresponseBody(){
		return this.responseBody;
	}
	
	public String gettime(){
		return this.time;
	}
	
	
	public String getposturl(){
		return this.posturl;
	}
	
	public String getgeturl(){
		return this.geturl1;
	}
	
	public List <NameValuePair> getparam(){
		return this.nvps;
	}
	
	public bingfafengzhuang (){
		
	}
	
	public void init() throws ClientProtocolException, IOException {
	//	a = abc;
		System.out.println(a);
		
    	geturl(geturl1);
    	geturl(geturl2);
    
    

	}
	
	//get
	 public void geturl(String str){
	    	
		  HttpGet httpGet = new HttpGet(str);
	   
		  CloseableHttpResponse response = null;
			try {
				response = httpclient.execute(httpGet);
				System.out.println(response.toString());

	    	    System.out.println(response.getStatusLine());
	    	    System.out.println(setCookie(response));
	    	    
	    	    HttpEntity entity = response.getEntity();
	    	    // do something useful with the response body
	    	    // and ensure it is fully consumed
	    
	    	 
	    	    EntityUtils.consume(entity);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	// The underlying HTTP connection is still held by the response object
	    	// to allow the response content to be streamed directly from the network socket.
	    	// In order to ensure correct deallocation of system resources
	    	// the user MUST call CloseableHttpResponse#close() from a finally clause.
	    	// Please note that if response content is not fully consumed the underlying
	    	// connection cannot be safely re-used and will be shut down and discarded
	    	// by the connection manager. 
	    	 
	    	    try {
					response.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
       }
	  
	  //post
	 public void posturl(String str) throws IOException{
		  HttpPost httpPost = new HttpPost(str);
		
		  httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		  
		  ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

              public String handleResponse(
                      final HttpResponse response) throws ClientProtocolException, IOException {
                  int status = response.getStatusLine().getStatusCode();
                  if (status >= 200 && status < 300) {
                      HttpEntity entity = response.getEntity();
                      return entity != null ? EntityUtils.toString(entity) : null;
                  } else {
                      throw new ClientProtocolException("Unexpected response status: " + status);
                  }
              }

          };
          
         
			
			try {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("hhmmssSSS");
				String strdata = sdf.format(date);
				//System.currentTimeMillis()
				time=strdata;
			
			
				responseBody = httpclient.execute(httpPost, responseHandler);
				System.out.println("----------------------------------------");
				System.out.println(strdata);
	               System.out.println(responseBody);
	              
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			httpclient.close();
  }
	  
	  
	  
     
	//		
	
	
  
	  
	  //postparam
	  public void addparam(String str1,String str2){
		  nvps.add(new BasicNameValuePair(str1, str2));
		  
		  
		  }
	  public void clearparam(List <NameValuePair> nvps1){
		  nvps1.clear();
		  
		  
		  }
	  
	
	  
    @Override  
    public void run() {  
    	
    	
    		
    	try {
			posturl(posturl);
			//clearparam(this.nvps);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	
        
    }  
    
    public static Map<String,String> cookieMap = new HashMap<String, String>(64);
    
    public static String setCookie(HttpResponse httpResponse)
    {
        System.out.println("----setCookieStore");
        Header headers[] = httpResponse.getHeaders("Set-Cookie");
        if (headers == null || headers.length==0)
        {
            System.out.println("----there are no cookies");
            return null;
        }
        String cookie = "";
        for (int i = 0; i < headers.length; i++) {
            cookie += headers[i].getValue();
            if(i != headers.length-1)
            {
                cookie += ";";
            }
        }
 
        String cookies[] = cookie.split(";");
        for (String c : cookies)
        {
            c = c.trim();
            if(cookieMap.containsKey(c.split("=")[0]))
            {
                cookieMap.remove(c.split("=")[0]);
            }
            cookieMap.put(c.split("=")[0], c.split("=").length == 1 ? "":(c.split("=").length ==2?c.split("=")[1]:c.split("=",2)[1]));
        }
        System.out.println("----setCookieStore success");
        String cookiesTmp = "";
        for (String key :cookieMap.keySet())
        {
            cookiesTmp +=key+"="+cookieMap.get(key)+";";
        }
 
        return cookiesTmp.substring(0,cookiesTmp.length()-2);
    }

  
	
   
	  
    
}  