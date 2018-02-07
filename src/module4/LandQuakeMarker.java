package module4;

import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PGraphics;

/** Implements a visual marker for land earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 *
 */
public class LandQuakeMarker extends EarthquakeMarker {
	
	
	public LandQuakeMarker(PointFeature quake) {
		
		// calling EarthquakeMarker constructor
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = true;
	}


	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		// Draw a centered circle for land quakes
		// DO NOT set the fill color here.  That will be set in the EarthquakeMarker
		// class to indicate the depth of the earthquake.
		// Simply draw a centered circle.
		
		// HINT: Notice the radius variable in the EarthquakeMarker class
		// and how it is set in the EarthquakeMarker constructor
		
		// TODO: Implement this method

		float mag = getMagnitude();
		String age = (String) getProperty("age");
		int k=0;

		if(mag<=4){
			pg.ellipse(x, y, 7, 7);
			k=4;
		}
		else if(mag>4 && mag<=4.9){
			pg.ellipse(x, y, 10, 10);
			k=6;
		}
		else if(mag>=5){
			pg.ellipse(x, y, 15, 15);
			k=8;
		}

		if(age.equals("Past Day") && k!=0) {
			pg.line(x - k, y - k, x + k, y + k);
			pg.line(x - k, y + k, x + k, y - k);
		}
		
	}


	// Get the country the earthquake is in
	public String getCountry() {
		return (String) getProperty("country");
	}



		
}