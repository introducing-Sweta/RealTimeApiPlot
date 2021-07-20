import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.allsafe.dao.UptimeDowntimeDao;
import com.allsafe.model.WebServiceRequests;

public class FetchRequest implements Runnable{
	
	Integer status=null;
	private UptimeDowntimeDao updn=new UptimeDowntimeDao();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss"); 
		   Date now = new Date();  
		     
		
		 try {
	    	   URL url = new URL("https://allsafe.in");
	           HttpURLConnection con = (HttpURLConnection) url.openConnection();
	           con.setRequestMethod("GET");
	           status = con.getResponseCode();
	           
	           con.disconnect();
	           
	           WebServiceRequests ws=new WebServiceRequests();
	           ws.setRequestStatus(status);
	           ws.setTime(simpleDateFormat.format(now).toString());
	           
	           updn.setConnectionStatus(ws);
	           	           
	    	  
	       }
	       catch(Exception e) {
	    	   e.printStackTrace();
	       }
		
	}

}
