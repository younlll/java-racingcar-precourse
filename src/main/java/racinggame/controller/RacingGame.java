package racinggame.controller;

import racinggame.commos.Constant;
import racinggame.exception.InputValueException;
import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.view.InputView;

public class RacingGame {
    private Cars cars;
    private Integer userInputCount;
    public RacingGame(){

    }

    public void startRacing(){
        cars = inputRacingCars();
        userInputCount = inputRacingTimes();

        System.out.println(Constant.LINE_BREAK + Constant.RESULT_PROMPT);

        for(int count = 0; count < userInputCount; count++){
            movingCars();
        }
    }

    private Cars inputRacingCars(){
        while(true) {
            try{
                String inputCarNames = InputView.getCarNames();
                isValidCarNames(inputCarNames);
                return new Cars(inputCarNames);
            }catch(InputValueException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer inputRacingTimes(){
        while(true){
            try{
                return Integer.parseInt(isValidCount(InputView.getMoveCount()));
            }catch(InputValueException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void isValidCarNames(String inputCarNames){
        String[] carNames = inputCarNames.split(Constant.COMMA);

        if(carNames.length <= 0 || inputCarNames.isEmpty()){
            throw new InputValueException(Constant.CAR_NOR_EXIST_ERR_MSG);
        }

        for(String carName : carNames){
            if(carName.trim().length() > Constant.CAR_NAME_LENGTH_LIMIT){
                throw new InputValueException(Constant.CAR_NAME_LENGTH_ERR_MSG);
            }
        }
    }

    private String isValidCount(String userInputCount){
        if(!userInputCount.matches("[+-]?\\d*(\\.\\d+)?")){
            throw new InputValueException(Constant.COUNT_NOT_NUMERIC_ERR_MSG);
        }else if(Integer.parseInt(userInputCount) < Constant.MOVE_COUNT_MIN){
            throw new InputValueException(Constant.COUNT_NOT_NUMERIC_ERR_MSG);
        }

        return userInputCount;
    }

    private void movingCars(){
        for(Car car : cars.getCars()){
            car.movingCar();
        }
    }
}
