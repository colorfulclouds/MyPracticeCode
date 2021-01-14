package com.hehe.RecursiveAndDynamic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PathIn2Arr {
    Set<List<Integer>> res = new HashSet<>();

    public Set<List<Integer>> path(boolean[][] map, int x, int y) {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == true)
                    count++;
            }
        }
        dfs(map, x, y, count);
        return res;
    }

    private boolean dfs(boolean[][] map, int x, int y, int count) {
        if (x < 0 || y < 0 || x >= map.length || y >= map[0].length
                || map[x][y] == false) {
            return false;
        }
        if (res.size() == count)
            return true;
        List<Integer> path = new LinkedList<>();
        path.add(x);
        path.add(y);
        if (res.contains(path))
            return false;
        res.add(path);
        if (dfs(map, x - 1, y, count)
                || dfs(map, x + 1, y, count)
                || dfs(map, x, y - 1, count)
                || dfs(map, x, y + 1, count))
            return true;
        else {
            res.clear();
            return false;
        }
    }
}
