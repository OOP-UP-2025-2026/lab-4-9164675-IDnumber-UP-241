package ua.opnu;

public class Point3D extends Point {
    private int z;

    public Point3D() {
        super();
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0; // Вимога: z повинна бути виставлена в 0
    }

    public double distance(Point3D p) {
        double dx = getX() - p.getX();
        double dy = getY() - p.getY();
        double dz = this.z - p.getZ();

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distance(Point p) {
        double dx = getX() - p.getX();
        double dy = getY() - p.getY();
        double dz = this.z - 0;

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distanceFromOrigin() {
        double dx = getX();
        double dy = getY();
        double dz = this.z;

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public int getZ() {
        return this.z;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + this.z + ")";
    }
}