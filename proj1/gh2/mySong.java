package gh2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

public class mySong {
    private static  String mySong = "";
    public  static String convertMidiToBase64(String filePath) throws IOException {
        // 读取MIDI文件为字节数组
        Path path = Paths.get(filePath);
        byte[] midiBytes = Files.readAllBytes(path);

        // 使用Base64编码器进行编码
        return Base64.getEncoder().encodeToString(midiBytes);
    }

    static {
        try {
            mySong = convertMidiToBase64(
                    "C:\\Users\\LENOVO\\Downloads\\47016.mid");
        } catch (Exception e) {
            throw new RuntimeException("Failed to load MIDI file", e);
        }
    }

    public static void main(String[] args) {
        try {
            byte[]  midiBytes = Base64.getDecoder().decode(mySong);
            InputStream source = new ByteArrayInputStream(midiBytes);
            //source = new GZIPInputStream(source);
            GuitarPlayer player = new GuitarPlayer(source);
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

