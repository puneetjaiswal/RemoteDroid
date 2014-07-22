package in.tosc.remotedroid.app;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/**
 * Created by omerjerk on 21/7/14.
 */
public class CodecUtils {

    public static final int WIDTH = 720;
    public static final int HEIGHT = 1280;

    public static final String MIME_TYPE = "video/x-vnd.on2.vp8";

    public static MediaCodecInfo selectCodec(String mimeType) {
        int numCodecs = MediaCodecList.getCodecCount();
        for (int i = 0; i < numCodecs; i++) {
            MediaCodecInfo codecInfo = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfo.isEncoder()) {
                continue;
            }
            String[] types = codecInfo.getSupportedTypes();
            for (int j = 0; j < types.length; j++) {
                if (types[j].equalsIgnoreCase(mimeType)) {
                    return codecInfo;
                }
            }
        }
        return null;
    }
}