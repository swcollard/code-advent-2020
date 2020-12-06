package code.advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DayOne {

    private List<Integer> readFile() {
        try {
            InputStream inputStream = getClass()
                    .getClassLoader().getResourceAsStream("day1.input");
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            List<Integer> lines = new ArrayList<>();
            for (String line; (line = reader.readLine()) != null; ) {
                lines.add(Integer.parseInt(line));
            }
            return lines;
        } catch (IOException e) {
            return List.of();
        }
    }

    public int getProduct() {
        List<Integer> nums = readFile();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue;
                if (nums.get(i) + nums.get(j) == 2020) {
                    return nums.get(i) * nums.get(j);
                }
            }
        }
        return 0;
    }

    public int getProductOfThree() {
        List<Integer> nums = readFile();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                for (int k = 0; k < nums.size(); k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    if (nums.get(i) + nums.get(j) + nums.get(k) == 2020) {
                        return nums.get(i) * nums.get(j) * nums.get(k);
                    }
                }
            }
        }
        return 0;
    }
}
