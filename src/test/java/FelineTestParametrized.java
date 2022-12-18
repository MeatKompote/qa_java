import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTestParametrized {

    private Feline feline;

    private final int initialNumberOfKittensParametrized;
    private final int expectedNumberOfKittensParametrized;

    public FelineTestParametrized(int initialNumberOfKittensParametrized, int expectedNumberOfKittensParametrized) {
        this.initialNumberOfKittensParametrized = initialNumberOfKittensParametrized;
        this.expectedNumberOfKittensParametrized = expectedNumberOfKittensParametrized;
    }


    @Parameterized.Parameters
    public static Object[][] getKittensData() {
        return new Object[][] {
                {-10, -10},
                {0, 0},
                {1, 1},
                {100, 100},
        };
    }

    @Before
    public void initialize() {
        feline = new Feline();
    }

    @Test
    public void getKittensReturnsCorrectValueWithInitialNumberOfKittens() {
        assertEquals("Неверная работа метода getKittens", expectedNumberOfKittensParametrized, feline.getKittens(initialNumberOfKittensParametrized));
    }
}
