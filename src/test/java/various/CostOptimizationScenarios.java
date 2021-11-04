package various;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class CostOptimizationScenarios {

    @Test
    void optimize_two_tests() {
        // Given
        HashMap<String, Integer> testTimes = new HashMap<String, Integer>();
        testTimes.put("test0", 3);
        testTimes.put("test1", 1);
        testTimes.put("test2", 2);

        // When
        Map<Integer, List<CostOptimizer.TestCase>> optimized = CostOptimizer.optimize(testTimes);

        // Then
        then(optimized).hasSize(1);
    }

    @Test
    void optimize_many_tests() {
        // Given
        HashMap<String, Integer> testTimes = new HashMap<String, Integer>();
        testTimes.put("test0", 1);
        testTimes.put("test1", 22);
        testTimes.put("test10", 4);
        testTimes.put("test11", 56);
        testTimes.put("test12", 7);
        testTimes.put("test13", 26);
        testTimes.put("test14", 48);
        testTimes.put("test15", 35);
        testTimes.put("test16", 50);
        testTimes.put("test17", 8);
        testTimes.put("test18", 52);
        testTimes.put("test19", 45);
        testTimes.put("test2", 43);
        testTimes.put("test20", 12);
        testTimes.put("test21", 38);
        testTimes.put("test22", 2);
        testTimes.put("test23", 15);
        testTimes.put("test24", 8);
        testTimes.put("test25", 49);
        testTimes.put("test26", 55);
        testTimes.put("test27", 12);
        testTimes.put("test28", 49);
        testTimes.put("test29", 30);
        testTimes.put("test3", 40);
        testTimes.put("test30", 25);
        testTimes.put("test31", 47);
        testTimes.put("test32", 36);
        testTimes.put("test33", 37);
        testTimes.put("test34", 4);
        testTimes.put("test35", 19);
        testTimes.put("test36", 47);
        testTimes.put("test37", 57);
        testTimes.put("test38", 6);
        testTimes.put("test39", 41);
        testTimes.put("test4", 7);
        testTimes.put("test40", 33);
        testTimes.put("test41", 30);
        testTimes.put("test42", 59);
        testTimes.put("test43", 5);
        testTimes.put("test44", 6);
        testTimes.put("test45", 56);
        testTimes.put("test46", 22);
        testTimes.put("test47", 42);
        testTimes.put("test48", 30);
        testTimes.put("test49", 14);
        testTimes.put("test5", 3);
        testTimes.put("test50", 41);
        testTimes.put("test51", 15);
        testTimes.put("test52", 1);
        testTimes.put("test53", 3);
        testTimes.put("test54", 51);
        testTimes.put("test55", 7);
        testTimes.put("test56", 8);
        testTimes.put("test57", 33);
        testTimes.put("test58", 0);
        testTimes.put("test59", 54);
        testTimes.put("test6", 49);
        testTimes.put("test60", 8);
        testTimes.put("test61", 20);
        testTimes.put("test62", 35);
        testTimes.put("test63", 46);
        testTimes.put("test64", 32);
        testTimes.put("test65", 32);
        testTimes.put("test66", 16);
        testTimes.put("test67", 6);
        testTimes.put("test68", 47);
        testTimes.put("test69", 42);
        testTimes.put("test7", 52);
        testTimes.put("test70", 54);
        testTimes.put("test71", 41);
        testTimes.put("test72", 50);
        testTimes.put("test73", 35);
        testTimes.put("test74", 57);
        testTimes.put("test75", 56);
        testTimes.put("test76", 25);
        testTimes.put("test77", 22);
        testTimes.put("test78", 48);
        testTimes.put("test79", 15);
        testTimes.put("test8", 48);
        testTimes.put("test80", 24);
        testTimes.put("test81", 42);
        testTimes.put("test82", 28);
        testTimes.put("test83", 32);
        testTimes.put("test84", 37);
        testTimes.put("test85", 4);
        testTimes.put("test86", 5);
        testTimes.put("test87", 13);
        testTimes.put("test88", 25);
        testTimes.put("test89", 50);
        testTimes.put("test9", 49);
        testTimes.put("test90", 41);
        testTimes.put("test91", 10);
        testTimes.put("test92", 5);
        testTimes.put("test93", 50);
        testTimes.put("test94", 49);
        testTimes.put("test95", 34);
        testTimes.put("test96", 10);
        testTimes.put("test97", 48);
        testTimes.put("test98", 26);
        testTimes.put("test99", 54);

        // When
        Map<Integer, List<CostOptimizer.TestCase>> optimized = CostOptimizer.optimize(testTimes);

        int testCasesCount = 0;
        for (int i = 0; i < optimized.keySet().size(); i++) {

            System.out.println("Test Case group ID = " + i);
            List<CostOptimizer.TestCase> testCases = optimized.get(i);
            for (int j = 0; j < testCases.size(); j++) {
                testCasesCount++;
                CostOptimizer.TestCase testCase = testCases.get(j);
                System.out.println("    testCase = " + testCase);
            }

        }

        System.out.println("testCasesCount = " + testCasesCount);

        // Then
        then(testCasesCount).isEqualTo(100);
    }
}
