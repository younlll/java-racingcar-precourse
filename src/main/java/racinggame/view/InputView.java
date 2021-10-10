package racinggame.view;

import nextstep.utils.Console;
import racinggame.commons.Constant;

public class InputView {
    public static String getCarNames(){
        System.out.println(Constant.RACING_CAR_NAME_PROMPT);
        return Console.readLine();
    }

    public static String getMoveCount(){
        System.out.println(Constant.RACING_TIMES_PROMPT);
        return Console.readLine();
    }
}
