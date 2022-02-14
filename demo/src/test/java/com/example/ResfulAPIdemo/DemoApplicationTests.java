package com.example.ResfulAPIdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void sensorTest() {
		WeatherInfoController instanceofcontrollerrun = new WeatherInfoController();

		Sensor actual = instanceofcontrollerrun.sensor("Ireland", "Dublin");

		Sensor expected = new Sensor(1, "Ireland", "Dublin");

		assertEquals(actual.toString(), expected.toString());
	}

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
