package racinggame;

import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApplicationTest extends NSTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    void 전진_정지() {
        assertRandomTest(() -> {
            run("pobi,woni", "1");
            verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 여러명의_우승자() {
        assertRandomTest(() -> {
            run("pobi,woni", "1");
            verify("pobi : -", "woni : -", "최종 우승자는 pobi,woni 입니다.");
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,javaji");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 이름의_입력값이_없는_경우_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("\n");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 자동차의_입력이_2대_미만인_경우_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 시도횟수가_입력되지_않은_경우_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,woni", "\n");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 시도횟수가_양수가_아닌_경우_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,woni", "-1");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 시도횟수가_범위를_초과하는_경우_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,woni", "12345678999");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 시도횟수_입력에_대한_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,woni", "abc");
            verify(ERROR_MESSAGE);
        });
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
