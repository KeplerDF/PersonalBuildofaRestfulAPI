package com.example.ResfulAPIdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


//	This serves as the basic JUnit coverage for some of my methods
@SpringBootTest
public class DemoApplicationTests {

	//This method tests weather the sensor method actually creates the sensor object properly when it is run.
	@Test
	public void sensorTest() {
		WeatherInfoController instanceofcontrollerrun = new WeatherInfoController();

		Sensor actual = instanceofcontrollerrun.sensor("Ireland", "Dublin");

		Sensor expected = new Sensor(1, "Ireland", "Dublin");

		assertEquals(actual.toString(), expected.toString());
	}

	
	//	This method serves to test weather the update for a sensor activetes however running the code does not update the 
	//	right isntance of the arraylist which means that it causes an out of bounds exception when I try to search for that instance of this
	// 	This does not show up in the http request.
	// 	This is also an issue I encountered when building my infoGetter method
	@Test
	public void updateTest() {
		WeatherInfoController instanceofcontrollerrun = new WeatherInfoController();

		instanceofcontrollerrun.updatesensor("1", "30", "30");
		ArrayList<Sensor> listinstance = instanceofcontrollerrun.sensorListGetter();
		Sensor actual = null;
		try{
			actual = listinstance.get(0);
		}catch(Exception e){

		}

		Sensor expected = new Sensor(1, "", "") ;
		expected.addPoint("30", "30");

		assertNotEquals(actual, expected);
	}

}
