package de.zabuza.armA2MortarTool.calculator;

import de.zabuza.armA2MortarTool.calculator.units.Vector;

/**
 * The calculator of the ArmA 2 Mortar Tool. Calculates distances and angular
 * for the mortar.
 * 
 * @author Zabuza
 * 
 */
public final class Calculator {

	/**
	 * The half of one full circle in the mil system.
	 */
	private static final int HALF_FULL_MIL = 3200;

	/**
	 * Positions of the mortar, target and spotter.
	 */
	private Vector mortarPos = new Vector(0, 0, 0), targetPos = new Vector(0,
			0, 0), spotterPos = new Vector(0, 0, 0);

	/**
	 * Distances and angular from the spotter to the actual and intended hitted
	 * position.
	 */
	private double actualDirMil = 0, actualDist = 0, intendedDirMil = 0,
			intendedDist = 0;

	/**
	 * Calculated values for the mortar.
	 */
	private int direction = 0, distance = 0, heightDif = 0, corDirection = 0,
			corDistance = 0;

	/**
	 * Calculates the values for the mortar with the given distances and
	 * angular.
	 * Credits for the function goes to brainslush (W)
	 */
	public void calculate() {

		Vector tmDelta = targetPos.sub(mortarPos);
		double hRange = Math.sqrt(Math.pow(tmDelta.getX(), 2)
				+ Math.pow(tmDelta.getY(), 2)) * 10;
		double vRange = tmDelta.getZ();
		double dirRad = Math.atan(tmDelta.getY() / tmDelta.getX());
		
		double dirMil = 0;
		if (tmDelta.getX() < 0) {
			dirMil = ((((3 * Math.PI) / 2) - dirRad) / Math.PI)
					* HALF_FULL_MIL;
		} else {
			dirMil = (((Math.PI / 2) - dirRad) / Math.PI) * HALF_FULL_MIL;
		}
		
		double hDelta = targetPos.getZ() - spotterPos.getZ();
		
		double actualDirectDist = Math.sqrt(Math.pow(actualDist, 2)
				- Math.pow(targetPos.getZ() - spotterPos.getZ(), 2));
		double intendedDirectDist = Math.sqrt(Math.pow(intendedDist, 2)
				- Math.pow(targetPos.getZ() - spotterPos.getZ(), 2));
		double actualDirDeg = (actualDirMil / HALF_FULL_MIL) * Math.PI;
		double intendedDirDeg = (intendedDirMil / HALF_FULL_MIL) * Math.PI;
		
		Vector sActualVec = new Vector(actualDirectDist
				* Math.sin(actualDirDeg) / 1000, actualDirectDist
				* Math.cos(actualDirDeg) / 1000, hDelta);
		Vector sIntendedVec = new Vector(intendedDirectDist
				* Math.sin(intendedDirDeg) / 1000, intendedDirectDist
				* Math.cos(intendedDirDeg) / 1000, hDelta);
		
		Vector actualVec = spotterPos.add(sActualVec).sub(mortarPos);
		Vector intendedVec = spotterPos.add(sIntendedVec).sub(mortarPos);
		
		double actualCorDirRad = Math.atan(actualVec.getY() / actualVec.getX());
		double intendedCorDirRad = Math.atan(intendedVec.getY()
				/ intendedVec.getX());
		
		double actualCorDirMil = 0;
		if (actualVec.getX() < 0) {
			actualCorDirMil = ((((3 * Math.PI) / 2) - actualCorDirRad)
								/ Math.PI) * HALF_FULL_MIL;
		} else {
			actualCorDirMil = (((Math.PI / 2) - actualCorDirRad) / Math.PI)
								* HALF_FULL_MIL;
		}

		double intendedCorDirMil = 0;
		if (intendedVec.getX() < 0) {
			intendedCorDirMil = ((((3 * Math.PI) / 2) - intendedCorDirRad)
								/ Math.PI) * HALF_FULL_MIL;
		} else {
			intendedCorDirMil = (((Math.PI / 2) - intendedCorDirRad) / Math.PI)
								* HALF_FULL_MIL;
		}
		
		double corDirMil = 0;
		if ((intendedCorDirMil - actualCorDirMil) >= HALF_FULL_MIL) {
			corDirMil = HALF_FULL_MIL - (intendedCorDirMil - actualCorDirMil);
		} else {
			corDirMil = intendedCorDirMil - actualCorDirMil;
		}
		
		double corDist = (Math.sqrt(Math.pow(intendedVec.getX(), 2)
				+ Math.pow(intendedVec.getY(), 2)) - Math.sqrt(Math.pow(
				actualVec.getX(), 2) + Math.pow(actualVec.getY(), 2))) * 100;

		direction = (int) Math.round(dirMil);
		distance = (int) Math.round(hRange);
		heightDif = (int) Math.round(vRange);
		corDirection = (int) Math.round(corDirMil);
		corDistance = (int) Math.round(corDist);
	}

	/**
	 * Gets the actualDirMil.
	 * 
	 * @return the actualDirMil
	 */
	public double getActualDirMil() {
		return actualDirMil;
	}

	/**
	 * Gets the actualDist.
	 * 
	 * @return the actualDist
	 */
	public double getActualDist() {
		return actualDist;
	}

	/**
	 * Gets the corDirection.
	 * 
	 * @return the corDirection
	 */
	public int getCorDirection() {
		return corDirection;
	}

	/**
	 * Gets the corDistance.
	 * 
	 * @return the corDistance
	 */
	public int getCorDistance() {
		return corDistance;
	}

	/**
	 * Gets the direction.
	 * 
	 * @return the direction
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * Gets the distance.
	 * 
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * Getts the heightDif.
	 * 
	 * @return the heightDif
	 */
	public int getHeightDif() {
		return heightDif;
	}

	/**
	 * Gets the intendedDirMil.
	 * 
	 * @return the intendedDirMil
	 */
	public double getIntendedDirMil() {
		return intendedDirMil;
	}

	/**
	 * Gets the intendedDist.
	 * 
	 * @return the intendedDist
	 */
	public double getIntendedDist() {
		return intendedDist;
	}

	/**
	 * Gets the mortarPos.
	 * 
	 * @return the mortarPos
	 */
	public Vector getMortarPos() {
		return mortarPos;
	}

	/**
	 * Gets the spotterPos.
	 * 
	 * @return the spotterPos
	 */
	public Vector getSpotterPos() {
		return spotterPos;
	}

	/**
	 * Gets the targetPos.
	 * 
	 * @return the targetPos
	 */
	public Vector getTargetPos() {
		return targetPos;
	}

	/**
	 * Sets the actualDirMil.
	 * 
	 * @param thatActualDirMil
	 *            the actualDirMil to set
	 */
	public void setActualDirMil(final double thatActualDirMil) {
		this.actualDirMil = thatActualDirMil;
	}

	/**
	 * Sets the actualDist.
	 * 
	 * @param thatActualDist
	 *            the actualDist to set
	 */
	public void setActualDist(final double thatActualDist) {
		this.actualDist = thatActualDist;
	}

	/**
	 * Sets the intendedDirMil.
	 * 
	 * @param thatIntendedDirMil
	 *            the intendedDirMil to set
	 */
	public void setIntendedDirMil(final double thatIntendedDirMil) {
		this.intendedDirMil = thatIntendedDirMil;
	}

	/**
	 * Sets the intendedDist.
	 * 
	 * @param thatIntendedDist
	 *            the intendedDist to set
	 */
	public void setIntendedDist(final double thatIntendedDist) {
		this.intendedDist = thatIntendedDist;
	}

	/**
	 * Sets the mortarPos.
	 * 
	 * @param thatMortarPos
	 *            the mortarPos to set
	 */
	public void setMortarPos(final Vector thatMortarPos) {
		this.mortarPos = thatMortarPos;
	}

	/**
	 * Sets the spotterPos.
	 * 
	 * @param thatSpotterPos
	 *            the spotterPos to set
	 */
	public void setSpotterPos(final Vector thatSpotterPos) {
		this.spotterPos = thatSpotterPos;
	}

	/**
	 * Sets the targetPos.
	 * 
	 * @param thatTargetPos
	 *            the targetPos to set
	 */
	public void setTargetPos(final Vector thatTargetPos) {
		this.targetPos = thatTargetPos;
	}
}
