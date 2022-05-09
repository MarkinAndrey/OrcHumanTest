import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class OrcHumanTest {

    @Test
    void printFieldTest() {

        String expected = "H h -    O o _ ";
        StringBuilder actual = new StringBuilder();
        Human[] HUMANS = {
                new Human("Чел-", 100, 20),
                new Human("Чел-", 49, 20),
                new Human("Чел-", 0, 20)};
        Orc[] ORC = {
                new Orc("Орк-", 180, 30),
                new Orc("Орк-", 89, 30),
                new Orc("Орк-", 0, 30)};

        String result = String.valueOf(OrcHuman.printField(HUMANS, ORC));

        Assertions.assertEquals(expected, result);

    }

    @Test
    void checkFinishTest_HUM() {
        Human[] HUMANS = {
                new Human("Чел-", 100, 20),
                new Human("Чел-", 0, 20)};
        Orc[] ORC = {
                new Orc("Орк-", 0, 30),
                new Orc("Орк-", 0, 30)};

        boolean result = OrcHuman.checkFinish(HUMANS, ORC);

        assertTrue(result);
    }

    @Test
    void checkFinishTest_ORC() {
        Human[] HUMANS = {
                new Human("Чел-", 0, 20),
                new Human("Чел-", 0, 20)};
        Orc[] ORC = {
                new Orc("Орк-", 180, 30),
                new Orc("Орк-", 89, 30)};

        boolean result = OrcHuman.checkFinish(HUMANS, ORC);

        assertTrue(result);
    }

    @Test
    void checkFinishTest() {
        Human[] HUMANS = {
                new Human("Чел-", 10, 20),
                new Human("Чел-", 0, 20)};
        Orc[] ORC = {
                new Orc("Орк-", 180, 30),
                new Orc("Орк-", 89, 30)};

        boolean result = OrcHuman.checkFinish(HUMANS, ORC);

        assertFalse(result);
    }

    @Test
    void selectOrcTest() {
        Orc expected = new Orc("Чел-1", 10, 20);
        Orc[] ORCS = {
                new Orc("Орк-1", 10, 20),
                new Orc("Орк-2", 15, 20),
                new Orc("Орк-3", 0, 20),
                new Orc("Орк-4", 60, 20),
                new Orc("Орк-5", 80, 20),
                new Orc("Орк-6", 100, 20)};

        Assertions.assertEquals(expected.getClass() ,OrcHuman.selectOrc(ORCS).getClass());
    }

    @Test
    void selectHumanTest() {

        Human expected = new Human("Чел-1", 10, 20);
        Human[] HUMANS = {
                new Human("Чел-1", 10, 20),
                new Human("Чел-2", 15, 20),
                new Human("Чел-3", 0, 20),
                new Human("Чел-4", 60, 20),
                new Human("Чел-5", 80, 20),
                new Human("Чел-6", 100, 20)};

        Assertions.assertEquals(expected.getClass() ,OrcHuman.selectHuman(HUMANS).getClass());
    }
}