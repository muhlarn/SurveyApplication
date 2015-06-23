package ac.wits.elen7046.surveyapplication.dao;

import ac.wits.elen7046.surveyapplication.entities.Location;

public interface LocationDAO {
	
	public boolean createLocation(Location location);
	public int getLocationId(Location location);
	public Location getLocationById(int locationId);
}
