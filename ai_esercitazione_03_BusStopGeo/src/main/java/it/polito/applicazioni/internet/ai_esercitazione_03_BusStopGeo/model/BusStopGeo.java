package it.polito.applicazioni.internet.ai_esercitazione_03_BusStopGeo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;


@Entity
public class BusStopGeo {
	
	@Id
	private String id;
	private String name;
	private Geometry position;
	
	public BusStopGeo(BusStop busStop){
		WKTReader pointReader = new WKTReader();
		String textLocation = "POINT("+busStop.getLng()+" "+busStop.getLat()+")";
		try {
			position = pointReader.read(textLocation);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		id = busStop.getId();
		name = busStop.getName();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Geometry getLocation() {
		return position;
	}
	public void setLocation(Geometry position) {
		this.position = position;
	}
	
	
}
