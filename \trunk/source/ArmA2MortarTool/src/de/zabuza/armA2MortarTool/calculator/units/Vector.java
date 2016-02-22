package de.zabuza.armA2MortarTool.calculator.units;

/**
 * 3-dim Vector unit for calculation.
 * 
 * @author Zabuza
 * 
 */
public final class Vector {

	/**
	 * Coordinates of the vector.
	 */
	private double x, y, z;

	/**
	 * Creates a new 3-dim Vector.
	 * 
	 * @param thatX
	 *            x-coord
	 * @param thatY
	 *            y-coord
	 * @param thatZ
	 *            z-coord
	 */
	public Vector(final double thatX, final double thatY, final double thatZ) {
		this.setX(thatX);
		this.setY(thatY);
		this.setZ(thatZ);
	}

	/**
	 * Adds all coordinates of the vector with another vector.
	 * 
	 * @param b
	 *            the other vector to add
	 * @return the resulting vector
	 */
	public Vector add(final Vector b) {
		return new Vector(this.getX() + b.getX(), this.getY() + b.getY(),
				this.getZ() + b.getZ());
	}

	/**
	 * Gets the x.
	 * 
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Gets the y.
	 * 
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * Gets the z.
	 * 
	 * @return the z
	 */
	public double getZ() {
		return z;
	}

	/**
	 * Sets the x.
	 * 
	 * @param thatX
	 *            the x to set
	 */
	public void setX(final double thatX) {
		this.x = thatX;
	}

	/**
	 * Sets the y.
	 * 
	 * @param thatY
	 *            the y to set
	 */
	public void setY(final double thatY) {
		this.y = thatY;
	}

	/**
	 * Sets the z.
	 * 
	 * @param thatZ
	 *            the z to set
	 */
	public void setZ(final double thatZ) {
		this.z = thatZ;
	}

	/**
	 * Subtracts all coordinates of the vector with another vector.
	 * 
	 * @param b
	 *            the other vector to subtract
	 * @return the resulting vector
	 */
	public Vector sub(final Vector b) {
		return new Vector(this.getX() - b.getX(), this.getY() - b.getY(),
				this.getZ() - b.getZ());
	}
}
