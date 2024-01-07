package dslModel;

import antlr4.dslModel.FsmlInterpreter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import antlr4.dslModel.CreateAPI;

public class FsmlTest {

    @ParameterizedTest
    @MethodSource("first")
    public void firstTest(String[] input, Boolean accept) {
        assertEquals(accept, FsmlInterpreter.run(CreateAPI.first, input));
    }

    public static Stream<Arguments> first() {
        return Stream.of(
                Arguments.of(new String[] {"Iltam"}, true),
                Arguments.of(new String[] {"Iltam", "Iltam"}, true),
                Arguments.of(new String[] {"Iltam", "Iltam", "Sumra", "Sumra", "Sumra", "Sumra", "Sumra", "Sumra"}, true),
                Arguments.of(new String[] {"Sumra"}, false),
                Arguments.of(new String[] {"Sumra", "Sumra"}, false),
                Arguments.of(new String[] {"Sumra", "Sumra", "Iltam"}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("second")
    public void secondTest(String[] input, Boolean accept) {
        assertEquals(accept, FsmlInterpreter.run(CreateAPI.second, input));
    }

    public static Stream<Arguments> second() {
        return Stream.of(
                Arguments.of(new String[] {"Code"}, false),
                Arguments.of(new String[] {"Key", "Code"}, false),
                Arguments.of(new String[] {"Key", "Code", "Key"}, false),
                Arguments.of(new String[] {"Key", "Code", "Hammer"}, true)
        );
    }
    @ParameterizedTest
    @MethodSource("third")
    public void thirdTest(String[] input, Boolean accept) {
        assertEquals(accept, FsmlInterpreter.run(CreateAPI.third, input));
    }
    public static Stream<Arguments> third() {
        return Stream.of(
                Arguments.of(new String[] {"yellowCar"}, false),
                Arguments.of(new String[] {"greenCar", "yellowCar"}, false),
                Arguments.of(new String[] {"greenCar", "yellowCar", "greenCar"}, false),
                Arguments.of(new String[] {"greenCar", "yellowCar", "redCar"}, true)
        );
    }
}
