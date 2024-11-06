package io.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadTextFileV1 {
    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println("writeString = " + writeString);

        Path path = Path.of(PATH);

        // 파일에 쓰기
        Files.writeString(path, writeString, UTF_8);

        // 파일에서 읽기
        String readString = Files.readString(path, UTF_8);

        System.out.println("readString = " + readString);

        List<String> strings = Files.readAllLines(path, UTF_8);
        for (String string : strings) {
            System.out.println("string = " + string);
        }
        try(Stream<String> lineStream = Files.lines(path, UTF_8)){
            lineStream.forEach(line -> System.out.println(line));
        }
    }
}
