package racinggame.view;

import racinggame.commos.Constant;
import racinggame.model.Car;
import racinggame.model.Cars;

import java.util.List;

public class OutputView {
    public static void printIntermediateStatus(Cars cars){
        for(Car car : cars.getCars()){
            System.out.println(String.format(Constant.STATUS_PRINT_FORMAT, car.getCarName(), dashDistance(car.getMoveDistance())));
        }
        System.out.print(Constant.LINE_BREAK);
    }

    private static String dashDistance(int moveDistance){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < moveDistance; i++){
            stringBuilder.append(Constant.MOVE_DISTANCE_MARK);
        }

        return stringBuilder.toString();
    }

    public static void printWinnerCarName(List<Car> cars){
        System.out.println(String.format(Constant.FINAL_WINNER_PRINT_FORMAT, winnerCarNameList(cars)));
    }

    private static String winnerCarNameList(List<Car> cars){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < cars.size(); i++){
            stringBuilder.append(cars.get(i).getCarName());
            if(i < cars.size() - 1){
                stringBuilder.append(Constant.COMMA);
            }
        }

        return stringBuilder.toString();
    }
}
