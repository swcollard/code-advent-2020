package code.advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DayThree {

    private List<List<Character>> readFile() {
        try {
            InputStream inputStream = getClass()
                    .getClassLoader().getResourceAsStream("day3.input");
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            List<List<Character>> array = new ArrayList<>();
            for (String line; (line = reader.readLine()) != null; ) {
                array.add(line.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
            }
            return array;
        } catch (IOException e) {
            return List.of();
        }
    }

    public int treesHit() {
        int treesHit = 0;
        List<List<Character>> grid = readFile();
        int rows = grid.size();
        int columns = grid.isEmpty() ? 0 : grid.get(0).size();
        int x = 0;
        int y = 0;
        while (++y < rows) {
            x+=3;
            if (grid.get(y).get(x % columns).equals('#')) {
                treesHit++;
            }
        }
        return treesHit;
    }

    public long treesHit(int yJump, int xJump) {
        long treesHit = 0;
        List<List<Character>> grid = readFile();
        int rows = grid.size();
        int columns = grid.isEmpty() ? 0 : grid.get(0).size();
        int x = 0;
        for (int y = yJump; y < rows; y+=yJump) {
            x+=xJump;
            if (grid.get(y).get(x % columns).equals('#')) {
                treesHit++;
            }
        }
        return treesHit;
    }
}
