package programmers.dfsbfs;

import java.util.*;

public class Problem7 {
    private class Solution {
        private int[][] DIRECTION = {
                {0, 1}, // 상
                {0, -1}, // 하
                {-1, 0}, // 좌
                {1, 0} // 우
        };

        public int solution(int[][] game_board, int[][] table) {
            // 게임 보드 내부 빈 공간
            List<List<Point>> emptySpaces = extractedBlocks(game_board, 0);

            // 블럭 테이블 내부 블럭들
            List<List<Point>> pieces = extractedBlocks(table, 1);

            // 블럭의 모든 회전 블럭들
            List<List<Point>> rotatedPieces = new ArrayList<>();
            for (List<Point> piece : pieces) {
                rotatedPieces.addAll(getAllRotatedPieces(piece)); // 모든 회전된 조각 추가
            }

            // 중복된 퍼즐 제거
            ArrayList<List<Point>> uniquePieces = new ArrayList<>();
            for (List<Point> piece : rotatedPieces) {
                if (!uniquePieces.contains(piece)) {
                    uniquePieces.add(piece);
                }
            }

            int totalFilled = 0;
            boolean[] used = new boolean[uniquePieces.size()];

            for (List<Point> space : emptySpaces) {
                List<Point> normalizedSpace = normalize(space);

                for (int i = 0; i < uniquePieces.size(); i++) {
                    if (!used[i] && isMatch(normalizedSpace, uniquePieces.get(i))) {
                        used[i] = true;
                        totalFilled += uniquePieces.get(i).size();
                        break;
                    }
                }
            }

            return totalFilled;
        }

        private boolean isMatch(List<Point> space, List<Point> piece) {
            if (space.size() != piece.size()) {
                return false;
            }
            for (int i = 0; i < space.size(); i++) {
                Point s = space.get(i);
                Point p = piece.get(i);
                if (s.x != p.x || s.y != p.y) {
                    return false;
                }
            }
            return true;
        }

        private List<Point> normalize(List<Point> piece) {
            List<Point> normalized = new ArrayList<>();
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;

            for (Point p : piece) {
                minX = Math.min(minX, p.x);
                minY = Math.min(minY, p.y);
            }

            for (Point p : piece) {
                normalized.add(new Point(p.x - minX, p.y - minY));
            }

            normalized.sort(Comparator.comparingInt((Point o) -> o.x).thenComparingInt(o -> o.y));

            return normalized;
        }

        private List<List<Point>> getAllRotatedPieces(List<Point> piece) { // 수정
            List<List<Point>> rotations = new ArrayList<>();
            List<Point> current = new ArrayList<>(piece);

            for (int i = 0; i < 4; i++) {
                current = rotate(current);
                rotations.add(normalize(current));
            }

            return rotations;
        }


        private List<Point> rotate(List<Point> piece) {
            List<Point> rotated = new ArrayList<>();
            for (Point p : piece) {
                // (x, y) -> (-y, x) : 90도 회전
                rotated.add(new Point(-p.y, p.x));
            }
            return rotated;
        }

        private List<List<Point>> extractedBlocks(int[][] board, int target) {
            int row = board.length;
            int col = board[0].length;
            List<List<Point>> blocks = new ArrayList<>();
            boolean[][] visited = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == target && !visited[i][j]) {
                        List<Point> block = new ArrayList<>();
                        Queue<Point> queue = new LinkedList<>();
                        queue.add(new Point(i, j));
                        visited[i][j] = true;

                        while (!queue.isEmpty()) {
                            Point currP = queue.poll();
                            block.add(currP);

                            for (int[] dir : DIRECTION) {
                                int nx = currP.x + dir[0];
                                int ny = currP.y + dir[1];
                                if(nx >= 0 && nx < row && ny >= 0 && ny < col
                                    && board[nx][ny] == target && !visited[nx][ny]){
                                    queue.offer(new Point(nx, ny));
                                    visited[nx][ny] = true;
                                }
                            }
                        }

                        blocks.add(block);
                    }
                }
            }

            return blocks;
        }

        private class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Point)) return false;
                Point point = (Point) o;
                return this.x == point.x && this.y == point.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
    }
    public static void main(String[] args) {
        Problem7 prom = new Problem7();
        Solution sol = prom.new Solution();

        // 테스트 케이스 1
        int[][] game_board1 = {
                {1,1,0,0,1,0},
                {0,0,1,0,1,0},
                {0,1,1,0,0,1},
                {1,1,0,1,1,1},
                {1,0,0,0,1,0},
                {0,1,1,1,0,0}
        };
        int[][] table1 = {
                {1,0,0,1,1,0},
                {1,0,1,0,1,0},
                {0,1,1,0,1,1},
                {0,0,1,1,0,0},
                {1,1,0,1,1,0},
                {0,1,0,0,0,0}
        };
        int result1 = sol.solution(game_board1, table1);
        System.out.println(result1); // 기대 출력: 14
    }
}
