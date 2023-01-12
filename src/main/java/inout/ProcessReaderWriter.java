package inout;

import fpinjava.Result;
import tuple.Tuple;

import java.io.*;

public class ProcessReaderWriter implements InputOutput {
    private final AbstractWriter abstractWriter;
    private final AbstractReader abstractReader;

    private ProcessReaderWriter(AbstractReader abstractReader, AbstractWriter abstractWriter) {
        this.abstractWriter = abstractWriter;
        this.abstractReader = abstractReader;
    }

    public static InputOutput processReaderWriter(Process process) {
        return new ProcessReaderWriter(new AbstractReader(new BufferedReader(new InputStreamReader(process.getInputStream()))), new AbstractWriter(new PrintWriter(new OutputStreamWriter(process.getOutputStream()))));
    }


    @Override
    public Result<Tuple<String, Input>> readLine() {
        return abstractReader.readLine();
    }

    @Override
    public void shutdownInput() throws IOException {
        abstractReader.shutdownInput();
    }

    @Override
    public void print(String s) {
        abstractWriter.print(s);
    }

    @Override
    public void shutdownOutput() throws IOException {
        abstractWriter.shutdownOutput();
    }
}
