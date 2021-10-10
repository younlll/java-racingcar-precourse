package racinggame.commos;

public class Constant {
    public final static Integer CAR_NAME_LENGTH_LIMIT = 5;
    public final static Integer MOVE_COUNT_MIN = 1;
    public final static Integer MOVE_COUNT_MIN_LIMIT = 0;
    public final static Integer MOVE_COUNT_MAX_LIMIT = 9;
    public final static Integer MOVE_FORWARD_RANGE = 4;

    public final static String RACING_CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final static String RACING_TIMES_PROMPT = "시도할 회수는 몇회인가요?";
    public final static String CAR_NOR_EXIST_ERR_MSG = "경주할 자동차가 입력되지 않았습니다. 다시 입력해주세요.";
    public final static String CAR_NAME_LENGTH_ERR_MSG = "자동차 이름은 5글자 이내 입니다. 다시 입력해주세요.";
    public final static String COUNT_NOT_NUMERIC_ERR_MSG = "시도 횟수는 숫자이며 양수이어야 합니다. 다시 입력해주세요";
    public final static String RESULT_PROMPT = "실행 결과";
    public final static String LINE_BREAK = "\n";
    public final static String COMMA = ",";
}
