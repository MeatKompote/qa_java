import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParametrized {

    private Lion lion;

    private final String sexLionValue;
    private final Boolean expectedHasManeValue;

    public LionTestParametrized(String sexLionValue, Boolean expectedHasManeValue) {
        this.sexLionValue = sexLionValue;
        this.expectedHasManeValue = expectedHasManeValue;
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getKittensData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Mock
    Feline feline;

    @Before
    public void initialize() {
        try {
            lion = new Lion(sexLionValue, feline);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doesHaveManeReturnsCorrectValue() {
        assertEquals("Неверная работа метода doesHaveMane", expectedHasManeValue, lion.doesHaveMane());
    }


}
