package racinggame.model;

import racinggame.commons.Constant;
import racinggame.exception.InputValueException;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(String inputCarNames) {
        isValidCarNames(inputCarNames);

        List<Car> cars = new ArrayList<>();
        String[] carNames = inputCarNames.split(Constant.COMMA);

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    private void isValidCarNames(String inputCarNames) {
        String[] carNames = inputCarNames.split(Constant.COMMA);

        if (carNames.length <= 1 || inputCarNames.isEmpty()) {
            throw new InputValueException(Constant.CAR_NOR_EXIST_ERR_MSG);
        }

        for (String carName : carNames) {
            if (carName.length() > Constant.CAR_NAME_LENGTH_LIMIT) {
                throw new InputValueException(Constant.CAR_NAME_LENGTH_ERR_MSG);
            }
        }
    }
}
