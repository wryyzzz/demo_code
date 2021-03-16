import java.util.*;

public class Prim {
    public static void main(String[] args) {
        Integer[][] gragh = {
                {0, 10, null, null, null, 11, null, null, null},
                {10, 0, 18, null, null, null, 16, null, 12},
                {null, null, 0, 22, null, null, null, null, 8},
                {null, null, 22, 0, 20, null, null, 16, 21},
                {null, null, null, 20, 0, 26, null, 7, null},
                {11, null, null, null, 26, 0, 17, null, null},
                {null, 16, null, null, null, 17, 0, 19, null},
                {null, null, null, 16, 7, null, 19, 0, null},
                {null, 12, 8, 21, null, null, null, null, 0}
        };
        kruskal(gragh);

    }


    private static void kruskal(Integer[][] gragh) {
        Set<Edge> edges = new HashSet<>();
        for (int i = 0; i < gragh.length; i++) {
            for (int j = 0; j < gragh[i].length; j++) {
                if (i != j && gragh[i][j] != null) {
                    edges.add(new Edge(i, j, gragh[i][j]));
                }
            }
        }

        List<Edge> result = new ArrayList<>();
        Set<Integer> vexs = new HashSet<>();
        edges.stream().sorted(Comparator.comparing(Edge::getWeight))
                .peek(System.out::println)
                .forEach(edge -> {
                    if (!result.isEmpty()) {
                        if (!vexs.contains(edge.getBegin()) || !vexs.contains(edge.getEnd())) {
                            vexs.add(edge.getEnd());
                            vexs.add(edge.getBegin());
                            result.add(edge);
                        }
                    } else {
                        vexs.add(edge.getEnd());
                        vexs.add(edge.getBegin());
                        result.add(edge);
                    }
                });
        System.out.println(result);
    }


    static class Edge {
        private Integer begin;
        private Integer end;
        private Integer weight;

        public Edge(Integer begin, Integer end, Integer weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }

        public Integer getBegin() {
            return begin;
        }

        public void setBegin(Integer begin) {
            this.begin = begin;
        }

        public Integer getEnd() {
            return end;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "begin=" + begin +
                    ", end=" + end +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return (Objects.equals(begin, edge.begin) &&
                    Objects.equals(end, edge.end) &&
                    Objects.equals(weight, edge.weight)) || (Objects.equals(end, edge.begin) &&
                    Objects.equals(begin, edge.end) &&
                    Objects.equals(weight, edge.weight));
        }

        @Override
        public int hashCode() {
            return begin + end + weight;
        }


    }


}
