import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SongPlayer {
    public static void play(String filename) {
        AudioInputStream audioStream = null;
        SourceDataLine line = null;

        try {
            File wavFile = new File(filename);
            audioStream = AudioSystem.getAudioInputStream(wavFile);
            AudioFormat format = audioStream.getFormat();

            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();

            System.out.println("Playing: " + filename);

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = audioStream.read(buffer, 0, buffer.length)) != -1) {
                line.write(buffer, 0, bytesRead);
            }

            line.drain();
            line.stop();

        } catch (UnsupportedAudioFileException e) {
            System.err.println("Unsupported audio file: " + filename);
        } catch (LineUnavailableException e) {
            System.err.println("Audio line unavailable.");
        } catch (IOException e) {
            System.err.println("I/O error while playing: " + filename);
        } finally {
            try {
                if (line != null) line.close();
                if (audioStream != null) audioStream.close();
            } catch (IOException ignored) {}
        }
    }
    public static void playSegment(String filename, double startSec, double durationSec) {
        AudioInputStream audioStream = null;
        SourceDataLine line = null;

        try {
            File file = new File(filename);
            audioStream = AudioSystem.getAudioInputStream(file);
            AudioFormat format = audioStream.getFormat();

            long startFrame = (long)(startSec * format.getFrameRate());
            long framesToPlay = (long)(durationSec * format.getFrameRate());

            audioStream.skip(startFrame * format.getFrameSize());

            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();

            System.out.println("Playing segment: " + startSec + "s to " + (startSec + durationSec) + "s");

            byte[] buffer = new byte[4096];
            long framesRead = 0;
            int bytesRead;
            while ((bytesRead = audioStream.read(buffer, 0, buffer.length)) != -1 && framesRead < framesToPlay) {
                line.write(buffer, 0, bytesRead);
                framesRead += bytesRead / format.getFrameSize();
            }

            line.drain();
            line.stop();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        } finally {
            try {
                if (line != null) line.close();
                if (audioStream != null) audioStream.close();
            } catch (IOException ignored) {}
        }
    }
}