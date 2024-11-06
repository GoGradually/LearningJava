package io.text;

import java.io.*;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV4 {
    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println("writeString = " + writeString);

        // 파일에 쓰기
        FileWriter fileWriter = new FileWriter(FILE_NAME, UTF_8);
        BufferedWriter bw = new BufferedWriter(fileWriter, BUFFER_SIZE);
        bw.write(writeString);
        bw.close();

        // 파일에서 읽기
        FileReader fileReader = new FileReader(FILE_NAME, UTF_8);
        BufferedReader br = new BufferedReader(fileReader, BUFFER_SIZE);
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null){
            builder.append(line).append('\n');
        }
        br.close();

        System.out.println("builder = " + builder.toString());
    }
}
