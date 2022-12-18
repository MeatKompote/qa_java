import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;
    private String lionSex = "Самец";
    private String lionAnimalKind = "Хищник";
    private String incorrectLionSex = "Неверный пол";
    private List<String> expectedGetFoodList = Arrays.asList("Животные", "Птицы", "Рыба");
    private int expectedGetKittens = 1;
    private String expectedExceptionMeassge = "Используйте допустимые значения пола животного - самей или самка";

    @Mock
    Feline feline;

    @Before
    public void initialize() {
        try {
            lion = new Lion(lionSex, feline);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getKittensReturnsCorrectValue() {
        Mockito.when(feline.getKittens()).thenReturn(expectedGetKittens);
        assertEquals("Неверная работа метода getKittens", expectedGetKittens, lion.getKittens());
    }

    @Test
    public void getFoodManeReturnsCorrectValue() {
        try {
            Mockito.when(feline.getFood(lionAnimalKind)).thenReturn(expectedGetFoodList);
            assertEquals("Неверная работа метода getFood", expectedGetFoodList, lion.getFood());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkingExceptionWhenCreatingLionWithIncorrectSex() {
        try {
            Lion incorrectSexLion = new Lion(incorrectLionSex, feline);
        } catch (Exception e) {
            assertEquals(expectedExceptionMeassge, e.getMessage());
            e.printStackTrace();
        }
    }


}
