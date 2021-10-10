package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.exception.InputValueException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @DisplayName("자동차 생성 테스트")
    @Test
    void create_car() {
        final String carNames = "pobi,woni";
        final Cars cars = new Cars(carNames);

        assertThat(cars).isNotNull();
        assertThat(cars.getCars().size()).isEqualTo(2);
    }

    @DisplayName("자동차 2대 미만 입력 예외처리 테스트")
    @Test
    void lower_cars_count_exception(){
        String carNames = "pobi";
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(InputValueException.class)
                .hasMessage("[ERROR] 경주할 자동차는 2대 이상 입력되어야 합니다. 다시 입력해주세요.");
    }

    @DisplayName("자동차 이름 길이가 5를 넘어가는 경우 예외처리 테스트")
    @Test
    void car_name_len_exception(){
        String carNames = "pobiabc, abc";
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(InputValueException.class)
                .hasMessage("[ERROR] 자동차 이름은 5글자 이내 입니다. 다시 입력해주세요.");
    }
}
