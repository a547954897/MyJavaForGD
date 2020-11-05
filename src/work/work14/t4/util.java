package work.work14.t4;


import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;


public class util {
	//获取网络json数据
	 public static String getJsonString(String urlPath) throws Exception {  
	        URL url = new URL(urlPath);  
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
	        connection.connect();  
	        InputStream inputStream = connection.getInputStream();  

	        Reader reader = new InputStreamReader(inputStream, "UTF-8");  
	        BufferedReader bufferedReader = new BufferedReader(reader);  
	        String str = null;  
	        StringBuffer sb = new StringBuffer();  
	        while ((str = bufferedReader.readLine()) != null) {  
	            sb.append(str);  
	        }  
	        reader.close();  
	        connection.disconnect();  
	        return sb.toString();  
	    }
	 //解析网络json数据
       public static Root resolveRoot(String strPar) throws Exception{  
			 return new Gson().fromJson(strPar,Root.class);			 
		   }
}
