package racinggame.model;

public class Car implements Comparable<Car> {
    private final String carName;
    private int moveDistance;

    public Car(String carName){
        this.carName = carName;
    }

    public int getMoveDistance(){
        return this.moveDistance;
    }

    @Override
    public int compareTo(Car car){
        if(this.getMoveDistance() < car.getMoveDistance()){
            return -1;
        }

        if(this.getMoveDistance() > car.getMoveDistance()){
            return 1;
        }
        return 0;
    }
}
