record Point(int x, int y){}
class CountSquares {
    private final Map<Point, Integer> pointCountMap;
    private final List<Point> points;
    public CountSquares() {
        pointCountMap = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        Point p = new Point(point[0], point[1]);
        pointCountMap.merge(p, 1, Integer::sum);
        points.add(p);
    }
    
    public int count(int[] po) {
        int result = 0;
        Point point = new Point(po[0], po[1]);
        for (Point p: points) {
            if (Math.abs(point.y() - p.y()) != Math.abs(point.x() - p.x()) 
            || point.x() == p.x() 
            || point.y() == p.y()) {
                continue;
            }
            result += pointCountMap.getOrDefault( new Point(p.x() , point.y()), 0)
                *  pointCountMap.getOrDefault(new Point(point.x(), p.y()), 0);
        }
        return result;
    }
}
