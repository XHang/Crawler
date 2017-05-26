package com.Crawler.crawlertool;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
/**
 * 功能：在登陆之后，向服务器发一段请求文本，然后接受响应，并把它打印出来
 * @author Administrator
 *
 */
public class SimulationLogin {
	/**
	 * 发请求-
	 * @param url  请求的url地址
	 * @param 请求的内容
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static void initiateRequest(String url,String data) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault(); 
		login(httpclient);
		System.out.println("登陆成功！");
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(data, "utf-8"));
		CloseableHttpResponse  response=httpclient.execute(httpPost);
		System.out.println("接受的数据为："+inputStreamConversionString(response.getEntity().getContent(),"utf-8"));
		httpclient.close();
	}
	/**
	 * 登陆：注意登陆用的httpClient和执行登陆之后操作的httlClient必须是同一个对象
	 * @param httpclient
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	private static void login(CloseableHttpClient httpclient) throws ClientProtocolException, IOException{
		HttpPost post=new HttpPost("用于校验登陆的url地址");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("校验的字段1", "值"));
        params.add(new BasicNameValuePair("校验的字段2", "值"));
		post.setEntity(new UrlEncodedFormEntity(params));
		httpclient.execute(post);
		post.releaseConnection();
	}
	/**
	    * 将字节流转换成字符串
	    * @param in 需要转换的字节流
	    * @param characterSet字符编码
	    * @return 转换完毕的字符串
	 * @throws ClientProtocolException 
	    * @throws IOException
	    */
	   public static String inputStreamConversionString(InputStream in,String characterSet) throws IOException{
		   BufferedReader read = new BufferedReader(new InputStreamReader(in,characterSet));
		   StringBuilder sb = new StringBuilder();
		   String line = "";
		   if((line = read.readLine())  !=  null){
			   sb.append(line);
		   }
		   return sb.toString();
	}
	   /**
	    * 用于测试的主函数
	    * @param args
	    * @throws ClientProtocolException
	    * @throws IOException
	    */
	   public static void main(String[] args) throws ClientProtocolException, IOException {
		   String data="";			//请在此处填充请求数据
		   String url="";				//请在此处填充请求的url地址
		   initiateRequest(url,data);
	}

}
