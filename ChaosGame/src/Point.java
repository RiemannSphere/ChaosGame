
public class Point <X,Y> {
    private final X x;
    private final Y y;

    public Point(Point<X,Y> point){
        this.x = point.getX();
        this.y = point.getY();
    }

    public Point(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    public Point getPoint(){
        return new Point(this);
    }
}
