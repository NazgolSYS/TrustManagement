package trust.management;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OutputWriter {

    private BufferedWriter bufferedWriter;

    public OutputWriter() {
        try {
            FileWriter writer = new FileWriter("output.csv");
            bufferedWriter = new BufferedWriter(writer);
        } catch (Exception ex) {
            Logger.getLogger(OutputWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeNewLine(double falsePositives, double truePositives) {
        try {
            bufferedWriter.write(falsePositives + "," + truePositives + "\r\n");
            bufferedWriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(OutputWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
