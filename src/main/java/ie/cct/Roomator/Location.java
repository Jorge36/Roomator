package ie.cct.Roomator;

public class Location {

    private String name;
    private Double longitude;
    private Double latitude;   
   
    public Location() {
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	// create and initialize a point with given name and
    // (latitude, longitude) specified in degrees
    public Location(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude  = latitude;
        this.longitude = longitude;
    }

    // return distance between this location and that location
    // measured in kilometres 
    public double distanceTo(Location that) {
    	
		if ((this.latitude == that.getLatitude()) && (this.longitude == that.getLongitude())) {
			return 0;
		}
		else {
			double theta = this.longitude - that.getLongitude();
			double dist = Math.sin(Math.toRadians(this.latitude)) * Math.sin(Math.toRadians(that.getLatitude())) + Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(that.getLatitude())) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			dist = dist * 1.609344;
			return (dist);
		}
    	
    }

    // return string representation of this point
    public String toString() {
        return name + " (" + latitude + ", " + longitude + ")";
    }


}
