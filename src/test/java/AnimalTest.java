import com.example.Animal;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    private Animal animal;
    private String expectedGetFamilyValue = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    private String incorrectAnimalKind = "Неверный тип животного";
    private String expectedExceptionForGetFood = "Неизвестный вид животного, используйте значение Травоядное или Хищник";


    @Before
    public void initialize() {
        animal = new Animal();
    }

    @Test
    public void getFamilyReturnsCorrectValue() {
        assertEquals("Неверная работа метода getFamily", expectedGetFamilyValue , animal.getFamily());
    }

    @Test
    public void checkingExceptionWhenGetFoodReceivesIncorrectAnimalKind() {
        try {
            animal.getFood(incorrectAnimalKind);
        } catch (Exception e) {
            assertEquals(expectedExceptionForGetFood, e.getMessage());
            e.printStackTrace();
        }
    }
}
