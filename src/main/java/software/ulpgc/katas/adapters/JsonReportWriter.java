package software.ulpgc.katas.adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import software.ulpgc.katas.domain.model.Report;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class JsonReportWriter {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void write(Report report, OutputStream output) throws IOException {
        Writer writer = new OutputStreamWriter(output, StandardCharsets.UTF_8);
        gson.toJson(report, writer);
        writer.flush();
    }
}