package com.satellite.position.springbootdemo.model;

public class SatellitePosition {

	@Override
	public String toString() {
		return "SatellitePosition [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	double latitude;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	double longitude;

}
