package various;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class CostOptimizer {

    private static final int MAX_MINUTES_PER_INSTANCE = 60;

    public static Map<Integer, List<TestCase>> optimize(final HashMap<String, Integer> testTimes) {

        List<TestCase> testCases = new ArrayList<>();

        testTimes
            .keySet()
            .forEach(testName -> testCases.add(new TestCase(testName, testTimes.get(testName))));

        testCases
            .sort(Comparator.comparing(o -> o.testTime));

        Map<Integer, List<TestCase>> optimized = new HashMap<>();

        int testGroupTime = 0;
        int key = 0;
        for (int i = 0; i < testCases.size(); i++) {
            TestCase testCase = testCases.get(i);
            testGroupTime += testCase.testTime;

            if (testGroupTime <= MAX_MINUTES_PER_INSTANCE) {
                optimized.computeIfAbsent(key, k -> new ArrayList<>());
                optimized.get(key).add(testCase);
            }

            if (testGroupTime > MAX_MINUTES_PER_INSTANCE) {
                i--;
                key++;
                testGroupTime = 0;
            }
        }

        return optimized;
    }

    static class TestCase {

        private final String testName;
        private final Integer testTime;

        TestCase(final String testName, final Integer testTime) {
            this.testName = testName;
            this.testTime = testTime;
        }

        @Override
        public String toString() {
            return "testName='" + testName + ", testTime=" + testTime;
        }
    }
}
