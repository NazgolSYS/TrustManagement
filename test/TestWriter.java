
import trust.management.OutputWriter;


public class TestWriter {
        public static void main(String[] args) {
        OutputWriter outputWriter = new OutputWriter();
        for (int i = 0; i < 10; i++) {
            outputWriter.writeNewLine(i, i * i);
        }
    }
}
