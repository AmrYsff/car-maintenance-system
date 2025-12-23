package project;

import java.util.*;

public class CarManager {
    private static CarManager _instance;
    private List<Car> cars;
    
    private CarManager() {
        cars = new ArrayList<>();
    }
    
    public static CarManager getInstance() {
        if (_instance == null) {
            _instance = new CarManager();
        }
        return _instance;
    }
    
    public boolean registerCar(Car car) {
        if (car != null && !cars.contains(car)) {
            cars.add(car);
            return true;
        }
        return false;
    }
    
    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
    public Car getCarByPlateNumber(int plateNumber)
    {
    	for(Car car : cars)
    	{
    		if(car.getPlateNumber() == plateNumber)
    		{
    			return car ;
    		}
    	}
    	System.out.println("Car not found");
    	return null ;
    }
}
