package module4;

import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PGraphics;

/** Implements a visual marker for ocean earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 *
 */
public class OceanQuakeMarker extends EarthquakeMarker {
	
	public OceanQuakeMarker(PointFeature quake) {
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = false;
	}
	

	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		// Drawing a centered square for Ocean earthquakes
		// DO NOT set the fill color.  That will be set in the EarthquakeMarker
		// class to indicate the depth of the earthquake.
		// Simply draw a centered square.
		
		// HINT: Notice the radius variable in the EarthquakeMarker class
		// and how it is set in the EarthquakeMarker constructor
		
		// TODO: Implement this method

		float mag = getMagnitude();
		String age = (String) getProperty("age");
		int k=0;

		if(mag<=4){
			pg.rect(x, y, 7, 7);
			x+=3;
			y+=3;
			k=5;
		}
		else if(mag>4 && mag<=4.9){
			pg.rect(x, y, 10, 10);
			x+=5;
			y+=5;
			k=7;
		}
		else if(mag>=5){
			pg.rect(x, y, 15, 15);
			x+=7;
			y+=7;
			k=10;
		}

		if(age.equals("Past Day") && k!=0) {
			pg.line(x - k, y - k, x + k, y + k);
			pg.line(x - k, y + k, x + k, y - k);
		}
		
	}
}
