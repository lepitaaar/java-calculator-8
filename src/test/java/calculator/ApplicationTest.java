package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
            run("//;123123\\n1;1231232;1231233");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 값을_계산할_수_있다() {
        assertSimpleTest(() -> {
            run("1,2,3,4");
            assertThat(output()).contains("결과 : 10");
            run("1:2:3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자와_기존_구분자를_같이_사용할_수_있다() {
        assertSimpleTest(() -> {
            run("//;\\n1,2:3;4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 숫자가_공백일시_예외를_반환한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자를_입력할시_예외를_반환한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자를_두개_이상_입력시_예외를_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;\\n//2\\n"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> runException("//;\\n//2\\n//3\\n"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> runException("//;\\n//2\\n//3\\n2;4"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 소수를_입력시_예외를_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1.1,1.2,1.3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
