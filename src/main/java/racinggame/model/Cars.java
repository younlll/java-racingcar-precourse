package racinggame.model;

import racinggame.commos.Constant;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(String inputCarNames){
        List<Car> cars = new ArrayList<>();
        String[] carNames = inputCarNames.split(Constant.COMMA);

        for(String carName : carNames){
            Car car = new Car(carName);
            cars.add(car);
        }
        this.cars = cars;
    }
}
