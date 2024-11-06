package io.text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV3 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println("writeString = " + writeString);

        // 파일에 쓰기
        FileWriter fileWriter = new FileWriter(FILE_NAME, UTF_8);
        fileWriter.write(writeString);
        fileWriter.close();

        // 파일에서 읽기
        FileReader fileReader = new FileReader(FILE_NAME, UTF_8);
        StringBuilder builder = new StringBuilder();
        int ch;
        while ((ch = fileReader.read()) != -1){
            builder.append((char) ch);
        }
        fileReader.close();

        System.out.println("builder = " + builder.toString());
    }
}
