import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;

/**
 * 
 * RTP Streaming using VLCJ
 * @author Mohamed AIT MANSOUR
 *
 */
public class StreamRTP {
    static MediaPlayerFactory factory;
    static MediaListPlayer mediaListPlayer;
    static MediaList playList;
    String lienstream;
    int stream = 0;
    
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