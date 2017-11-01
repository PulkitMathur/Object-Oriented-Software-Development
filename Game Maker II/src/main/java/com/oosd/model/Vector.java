package com.oosd.model;

public class Vector{
	
	private double x;
	private double y;
	private double angle;
	
	/**
	 * Creates a new Vector from an angle. The length of this vector will be 1.
	 * @param angle The angle.
	 */
	public Vector(double angle) {
		this.y = Math.cos(angle);
		this.x = Math.sin(angle);
		this.angle = angle;
	}
	
	
	public Vector set(double x, double y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	/**
	 * Normalizes this Vector (giving it a length of 1.0).
	 * @return This vector for chaining.
	 */
	public Vector normalize() {
		double length = getLengthSquared();
		if(length != 0.0f && length != 1.0f) {
			length = Math.sqrt(length);
			this.x /= length;
			this.y /= length;
		}
		return this;
	}
	
	/**
	 * Gets the squared length of this Vector.
	 * @return The squared length.
	 */
	public double getLengthSquared() {
		return (x * x + y * y);
	}

	/**
	 * Gets the squared distance to another Vector.
	 * @param vec The other vector.
	 * @return The squared distance.
	 */
	

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
	
}