import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;
    private List<String> expectedGetFoodList = Arrays.asList("Животные", "Птицы", "Рыба");
    private String expectedGetSound = "Мяу";

    @Before
    public void initialize() {
        cat = new Cat(feline);
    }

    @Mock
    Feline feline;

    @Test
    public void getSoundReturnsCorrectValue() {
        assertEquals("Неверная работа метода getSound", expectedGetSound , cat.getSound() );
    }

    @Test
    public void getFoodReturnsCorrectValue() {
        try {
            Mockito.when(feline.eatMeat()).thenReturn(expectedGetFoodList);
            assertEquals("Неверная работа метода getFood", expectedGetFoodList, cat.getFood());
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
            e.printStackTrace();
        }

    }

}
