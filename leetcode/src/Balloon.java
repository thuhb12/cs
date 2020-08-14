import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Balloon {
    public static void main(String[] args) {

    }
    static class Position {
        int start;
        int end;
        public Position(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Result {
        int right;
        Boolean over;
    }
    public int findMinArrowShots(int[][] points) {
        List<Position> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];
            list.add(new Position(start, end));
        }
        Collections.sort(list, new Comparator<Position>() {
            @Override
            public int compare(Position o, Position t1) {
                return o.start - t1.start;
            }
        });
        int count = 0;
        for (int i = 0; i < list.size(); ) {
            Position current = list.get(i);
            int p = current.end;
            int j = i + 1;
            while (j < list.size()) {
                Result result = compare(p, list.get(j));
                if (result.over) {
                    p = result.right;
                    j++;
                } else {
                    i = j;
                    break;
                }
            }
            if (j == list.size()) {
                i = j;
            }
            count++;
        }
        return count;
    }

    private Result compare(int p, Position position) {
        Result result = new Result();
        if (position.start > p) {
            result.over = false;
        } else {
            result.right = Math.min(p, position.end);
            result.over = true;
        }
        return result;
    }
}