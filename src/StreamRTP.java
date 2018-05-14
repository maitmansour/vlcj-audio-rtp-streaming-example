/**
 * 
 * RTP Streaming using VLCJ
 * @author Mohamed AIT MANSOUR
 *
 */
public class StreamRTP {

    public static void main(String[] args) {
        System.out.println("Fisrt Class");

    }

    /**
     * 
     * @param serverAddress
     * @param serverPort
     * @return  mediaOptions for rtp stream wih vlc
     */
    private static String formatRtpStream(String serverAddress, int serverPort) {
        StringBuilder sb = new StringBuilder(60);
        sb.append(":sout=#rtp{dst=");
        sb.append(serverAddress);
        sb.append(",port=");
        sb.append(serverPort);
        sb.append(",mux=ts}");
        return sb.toString();
    }

}