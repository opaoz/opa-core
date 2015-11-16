package ru.opa.pack.entity;

import java.awt.geom.Point2D;

public class Point {
	private double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getEdge(Point a) {
		return Point2D.distance(x, y, a.getX(), a.getY());
	}

	public double getAngle(Point a, Point b) {
		double x1 = x - a.x, x2 = b.x - a.x;
		double y1 = y - a.y, y2 = b.y - a.y;

		double d1 = Math.sqrt(x1 * x1 + y1 * y1);
		double d2 = Math.sqrt(x2 * x2 + y2 * y2);

		return Math.acos((x1 * x2 + y1 * y2) / (d1 * d2)) / Math.PI * 180;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
