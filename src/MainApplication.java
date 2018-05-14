/**
 * 
 * RTP Streaming using VLCJ - Main APP
 * @author Mohamed AIT MANSOUR
 *
 */
public class MainApplication {
	   /**
	    * Main execution
	    * @param args
	    */
	    public static void main(String[] args) {
	    	try {
	    		System.out.println("Begin Streaming APP");
				StreamRTP rtp = new StreamRTP();
				//rtp.start("YOUR_LOCAL_IP_HERE", PORT, "sample.mp3");
				rtp.start("10.20.11.142", 5000, "sample.mp3");
	    		System.out.println("End Streaming APP");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
}
