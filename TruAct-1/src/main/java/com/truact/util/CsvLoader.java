package com.truact.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvLoader {

    /**
     * Loads data from a CSV file and returns a list of string arrays.
     * Each array represents a row in the CSV file.
     *
     * @param filePath the path to the CSV file
     * @return a list of string arrays containing the CSV data
     * @throws IOException if an error occurs while reading the file
     */
    public List<String[]> loadCsv(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        }
        return data;
    }
}