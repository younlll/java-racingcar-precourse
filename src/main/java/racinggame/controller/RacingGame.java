package racinggame.controller;

import racinggame.exception.InputValueException;
import racinggame.model.Cars;
import racinggame.view.InputView;

public class RacingGame {
    private Cars cars;
    private Integer userInputCount;
    public RacingGame(){

    }

    public void startRacing(){
        try{
            cars = inputRacingCars();
            userInputCount = Integer.parseInt(inputRacingTimes());
        }catch (InputValueException e){

        }
    }

    private Cars inputRacingCars(){
        String inputCarNames = InputView.getCarNames();
        return new Cars(inputCarNames);
    }
    private String inputRacingTimes(){
        return InputView.getMoveCount();
    }
}
