package racinggame.model;

import nextstep.utils.Randoms;
import racinggame.commons.Constant;

public class Car implements Comparable<Car> {
    private final String carName;
    private int moveDistance = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getMoveDistance() {
        return this.moveDistance;
    }

    public void movingCar() {
        int randomMoveCnt = Randoms.pickNumberInRange(Constant.MOVE_COUNT_MIN_LIMIT, Constant.MOVE_COUNT_MAX_LIMIT);
        if (randomMoveCnt >= Constant.MOVE_FORWARD_RANGE) {
            this.moveDistance += 1;
        }
    }

    @Override
    public int compareTo(Car car) {
        if (this.getMoveDistance() < car.getMoveDistance()) {
            return -1;
        }

        if (this.getMoveDistance() > car.getMoveDistance()) {
            return 1;
        }
        return 0;
    }
}
