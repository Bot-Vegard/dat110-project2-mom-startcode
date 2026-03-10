package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		Client client = new Client("sensor", Common.BROKERHOST, Common.BROKERPORT);
        client.connect();

        for (int i = 0; i < COUNT; i++){
            int temperature = sn.read();
            System.out.println("temperature:" + temperature);
            client.publish("temperature", String.valueOf(temperature));
        }

        client.disconnect();
		System.out.println("Temperature device stopping ... ");

	}
}
