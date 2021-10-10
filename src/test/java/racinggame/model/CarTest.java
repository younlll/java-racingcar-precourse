package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("자동차 생성 테스트")
    @Test
    void create_car() {
        final String name = "pobi";
        final Car car = new Car(name);

        assertThat(car).isNotNull();
        assertThat(car.getCarName()).isEqualTo(name);
    }
}
