import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private Feline feline;
    private List<String> expectedGetFoodList = Arrays.asList("Животные", "Птицы", "Рыба");
    private String expectedGetFamily = "Кошачьи";
    private int expectedGetKittens = 1;

    @Before
    public void initialize() {
        feline = new Feline();
    }

    @Test
    public void eatMeatReturnsCorrectValue() {
        try {
            assertEquals("Неверная работа метода eatMeat", expectedGetFoodList , feline.eatMeat() );
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
            e.printStackTrace();
        }
    }

    @Test
    public void getFamilyReturnsCorrectValue() {
        assertEquals("Неверная работа метода getFamily", expectedGetFamily, feline.getFamily());
    }

    @Test
    public void getKittensReturnsCorrectValue() {
        assertEquals("Неверная работа метода getKittens", expectedGetKittens, feline.getKittens());
    }
}
