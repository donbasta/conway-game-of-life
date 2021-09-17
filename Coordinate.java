public class Coordinate {
    public int a;
    public int b;
    public Coordinate() {}
    public Coordinate(int _a, int _b) {
        this.a = _a;
        this.b = _b;
    }
    public Coordinate add(Coordinate c) {
        Coordinate ret = new Coordinate();
        ret.a = this.a + c.a;
        ret.b = this.b + c.b;
        return ret;
    }
    public boolean equals(Coordinate c) {
        return (this.a == c.a) && (this.b == c.b);
    }
    public void print() {
        System.out.printf("(%d, %d),", this.a, this.b);
    }
}