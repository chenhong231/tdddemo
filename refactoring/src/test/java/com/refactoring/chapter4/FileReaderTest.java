package com.refactoring.chapter4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderTest {

    private FileReader fileReader;

    @BeforeEach
    public void setUp() {
        try {
            fileReader = new FileReader("classpath:data.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("unable to open test file");
        }
    }

    @Test
    public void test() {

    }
}
