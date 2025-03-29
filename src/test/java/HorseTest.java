import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class HorseTest {

    @Test
    public void nullException() {
        IllegalArgumentException e =assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1,1));
        assertEquals("Name cannot be null.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\t\t", "\n\n\n\n\n\n"})
    public void blankNameExeption(String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Horse(name, 1,1));

        assertEquals("Name cannot be blank.",e.getMessage());
    }

    @Test
    public void getName() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Horse horse = new Horse("fdsfge", 1, 1);

        Field name = Horse.class.getDeclaredField("name");
        name.setAccessible(true);
        String nameValue = (String) name.get(horse);
        assertEquals("fdsfge", nameValue);
    }

    @Test
    public void getSpeed() {
        Horse horse = new Horse("fdsfge",356,1);
        assertEquals(356, horse.getSpeed());
    }

    @Test
    public void getDistance() {
        Horse horse = new Horse("fdsfge",1,234);
        assertEquals(234, horse.getDistance());
    }

    @Test
    public void getZeroDistance() {
        Horse horse = new Horse("fdsfge",1);
        assertEquals(5,horse.getDistance());
    }
}


