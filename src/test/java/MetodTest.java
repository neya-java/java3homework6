import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MetodTest {
    private static IntMain intMain;

    @BeforeAll
    public static void prepare(){
        intMain = new Main();
    }

    @Test
    public void testMassiveError(){
        Assertions.assertThrows(RuntimeException.class, ()->{
            intMain.massive(new int[] {1,2,3,0,5,6,7,8,9});
        });
    }

    public static Stream<Arguments> data(){
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {5,6,7,8,9}, new int[] {0,1,2,3,4,5,6,7,8,9}));
        out.add(Arguments.arguments(new int[0] , new int[] {0,1,2,3,4,5,6,7,8,4}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testMassive(int [] arrNew, int[] arr) {
        Assertions.assertArrayEquals (arrNew, intMain.massive(arr));
    }

    public static Stream<Arguments> data1(){
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(true, new int[] {1,1,4,1,4,1,4,1,4,1}));
        out.add(Arguments.arguments(false, new int[] {1,1,1,1,1,1,1,1,1}));
        out.add(Arguments.arguments(false, new int[] {4,4,4,4,4,4,4,4,4}));
        out.add(Arguments.arguments(false, new int[] {1,4,3,4,4,4,4,4,4}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("data1")
    public void testMassiveOneFour(boolean b, int [] arr) {
        Assertions.assertEquals(b, intMain.massiveOneFour(arr));
    }



}
