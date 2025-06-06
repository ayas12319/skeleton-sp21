package gh2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

public class changetest {
    private static final String TTFAF;
    public  static String convertMidiToBase64(String filePath) throws IOException {
        // 读取MIDI文件为字节数组
        Path path = Paths.get(filePath);
        byte[] midiBytes = Files.readAllBytes(path);

        // 使用Base64编码器进行编码
        return Base64.getEncoder().encodeToString(midiBytes);
    }

    static {
        try {
            TTFAF = convertMidiToBase64(
                    "C:\\Users\\LENOVO\\Desktop\\压缩文件中间站\\Fly-Me-To-The-Moon.mid");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load MIDI file", e);
        }
    }

    public static void main(String args[]){
        System.out.println(TTFAF);
    }
}
