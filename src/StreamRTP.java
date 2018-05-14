import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayerEventAdapter;
import uk.co.caprica.vlcj.player.list.MediaListPlayerMode;

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
    
    public StreamRTP() throws Exception {
        boolean found = new NativeDiscovery().discover();
        if (found) {
        	System.out.println(LibVlc.INSTANCE.libvlc_get_version());
            factory = new MediaPlayerFactory();
            mediaListPlayer = factory.newMediaListPlayer();
            mediaListPlayer.addMediaListPlayerEventListener(new MediaListPlayerEventAdapter() {
                @Override
                public void nextItem(MediaListPlayer mediaListPlayer, libvlc_media_t item, String itemMrl) {
                    System.out.println("Playing next item: " + itemMrl + " (" + item + ")");
                }
            });
            playList = factory.newMediaList();
		}else {
			throw new Exception("Error During construction, please check NativeDiscovery");
		}
    }
    
    public static void main(String[] args) {
    	try {
			StreamRTP rtp = new StreamRTP();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

    /**
     * Start streaming of music by adding music to the playList
     * 
     * @param dir
     * @param address
     * @param port
     * @param musique
     * @throws Exception
     */
    private static void start(String address, int port, String music) throws Exception {
        mediaListPlayer = factory.newMediaListPlayer();
        String mediaOptions = formatRtpStream(address, port);
        playList.addMedia("music/" + music, mediaOptions);
        // Attach the play-list to the media list player
        mediaListPlayer.setMediaList(playList);
        mediaListPlayer.setMode(MediaListPlayerMode.LOOP);
        // Finally, start the media player
        mediaListPlayer.play();
        System.out.println("Streaming started at rtp://" + address + ":" + port);

    }

}