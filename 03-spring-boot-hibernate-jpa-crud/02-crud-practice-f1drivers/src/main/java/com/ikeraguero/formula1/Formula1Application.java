package com.ikeraguero.formula1;

import com.ikeraguero.formula1.dao.DriverDAO;
import com.ikeraguero.formula1.entity.Driver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Formula1Application {

	public static void main(String[] args) {
		SpringApplication.run(Formula1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(DriverDAO driverDAO) {
		return runner -> {
			///createDriver(driverDAO);
			//createMultipleDrivers(driverDAO);
			//readDriver(driverDAO);
			//queryForDrivers(driverDAO);
			//queryForAllDrivers(driverDAO);
			//updateDriver(driverDAO);
			//deleteDriver(driverDAO);
			deleteAllDriver(driverDAO);
		};
	}

	private void deleteAllDriver(DriverDAO driverDAO) {
		System.out.println("Rows affected on delete: " + driverDAO.deleteAll());
	}

	private void deleteDriver(DriverDAO driverDAO) {
		int driverId = 4;
		driverDAO.delete(4);
	}

	private void updateDriver(DriverDAO driverDAO) {
		int driverId = 5;
		Driver theDriver = driverDAO.findById(5);
		theDriver.setLastName("Verstappen");

		driverDAO.update(theDriver);
	}

	private void queryForAllDrivers(DriverDAO driverDAO) {
		List<Driver> driverList = driverDAO.findAll();

		for(Driver driver : driverList) {
			System.out.println(driver);
		}
	}

	private void queryForDrivers(DriverDAO driverDAO) {
		List<Driver> driverList = driverDAO.findByLastName("Gasly");

		for(Driver driver : driverList) {
			System.out.println(driver);
		}
	}

	private void readDriver(DriverDAO driverDAO) {
		Driver theDriver = new Driver("Lando", "Norris", 4);
		driverDAO.save(theDriver);

		int driverId = theDriver.getId();
		Driver myDriver = driverDAO.findById(driverId);

		System.out.println("Added driver: " + myDriver);
	}

	private void createMultipleDrivers(DriverDAO driverDAO) {
		Driver theDriver1 = new Driver("Lewis", "Hamilton", 44);
		Driver theDriver2 = new Driver("Fernando", "Alonso", 14);
		Driver theDriver3 = new Driver("Pierre", "Gasly", 10);

		driverDAO.save(theDriver1);
		driverDAO.save(theDriver2);
		driverDAO.save(theDriver3);
	}

	private void createDriver(DriverDAO driverDAO) {
		System.out.println("Creating driver");
		Driver theDriver = new Driver("Max", "Verstappen", 1);

		System.out.println("Saving driver");
		driverDAO.save(theDriver);
	}


}
