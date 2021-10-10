package racinggame.controller;

import racinggame.commons.Constant;
import racinggame.exception.InputValueException;
import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            OutputView.printIntermediateStatus(cars);
        }

        OutputView.printWinnerCarName(winnerSelection());
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
            }catch (NumberFormatException e){
                System.out.println(String.format(Constant.ERROR_PRINT_FORMAT, Constant.NUMBER_RANGE_OVER_ERR_MSG));
            }catch(InputValueException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void isValidCarNames(String inputCarNames){
        String[] carNames = inputCarNames.split(Constant.COMMA);

        if(carNames.length <= 1 || inputCarNames.isEmpty()){
            throw new InputValueException(Constant.CAR_NOR_EXIST_ERR_MSG);
        }

        for(String carName : carNames){
            if(carName.length() > Constant.CAR_NAME_LENGTH_LIMIT){
                throw new InputValueException(Constant.CAR_NAME_LENGTH_ERR_MSG);
            }
        }
    }

    private String isValidCount(String userInputCount){
        if(!userInputCount.matches("[+-]?\\d*(\\.\\d+)?")){
            throw new InputValueException(Constant.COUNT_NOT_NUMERIC_ERR_MSG);
        }
        if(Integer.parseInt(userInputCount) < Constant.MOVE_COUNT_MIN){
            throw new InputValueException(Constant.COUNT_NOT_NUMERIC_ERR_MSG);
        }
        return userInputCount;
    }

    private void movingCars(){
        for(Car car : cars.getCars()){
            car.movingCar();
        }
    }

    private List<Car> winnerSelection(){
        int maxDistance = Collections.max(cars.getCars()).getMoveDistance();
        List<Car> winner = new ArrayList<>();

        for(Car car : cars.getCars()){
            if(car.getMoveDistance() == maxDistance){
                winner.add(car);
            }
        }

        return winner;
    }
}
