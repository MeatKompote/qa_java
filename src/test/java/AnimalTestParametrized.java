import com.example.Animal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalTestParametrized {

    private Animal animal;

    private final String animalKind;
    private final List<String> expectedGetFoodList;

    public AnimalTestParametrized(String animalKind, List<String> expectedGetFoodList) {
        this.animalKind = animalKind;
        this.expectedGetFoodList = expectedGetFoodList;
    }

    @Parameterized.Parameters
    public static Object[][] getFoodData() {
        List<String> listOfFoodForHerbivores = Arrays.asList("Трава", "Различные растения");
        List<String> listOfFoodForPredator = Arrays.asList("Животные", "Птицы", "Рыба");
        return new Object[][] {
                {"Травоядное", listOfFoodForHerbivores},
                {"Хищник", listOfFoodForPredator}
        };
    }

    @Before
    public void initialize() {
        animal = new Animal();
    }

    @Test
    public void getFoodReturnsCorrectValue() {
        try {
            assertArrayEquals("Неправильная работа метода getFood", expectedGetFoodList.toArray(), animal.getFood(animalKind).toArray());
        } catch (Exception e) {
            assertEquals("Свлились в эксепшн", 1 ,0);
            e.printStackTrace();
        }
    }
}
