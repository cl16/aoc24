package org.helper;

public class XYCoordinates {

    private final int x;
    private final int y;

    public XYCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public XYCoordinates shiftLeft() {
        return new XYCoordinates(this.x - 1, this.y);
    }

    public XYCoordinates shiftRight() {
        return new XYCoordinates(this.x + 1, this.y);
    }

    public XYCoordinates shiftUp() {
        return new XYCoordinates(this.x, this.y + 1);
    }

    public XYCoordinates shiftDown() {
        return new XYCoordinates(this.x, this.y - 1);
    }
}
