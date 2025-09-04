package leetcode.java.yellocoder;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.*;

class Employee {
    private final int id;
    private final String name;
    private final double salary;
    private final StreamsApiInterviewSolutions.Gender gender;

    Employee(int id, String name, double salary, StreamsApiInterviewSolutions.Gender gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public StreamsApiInterviewSolutions.Gender getGender() { return gender; }
    @Override public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + ", gender=" + gender + "}";
    }
}

class Person {
    private final String firstName;
    private final int age;
    Person(String firstName, int age) { this.firstName = firstName; this.age = age; }
    public String getFirstName() { return firstName; }
    public int getAge() { return age; }
    @Override public String toString() { return firstName + "(" + age + ")"; }
}



public class StreamsApiInterviewSolutions {

    // ===== Mock domain types =====
    enum Gender { MALE, FEMALE }


    enum TxType { CREDIT, DEBIT, TRANSFER, REFUND }
    static class Transaction {
        private final String id;
        private final TxType type;
        private final double amount;
        Transaction(String id, TxType type, double amount) {
            this.id = id; this.type = type; this.amount = amount;
        }
        public String getId() { return id; }
        public TxType getType() { return type; }
        public double getAmount() { return amount; }
        @Override public String toString() { return "Tx{id='" + id + "', type=" + type + ", amount=" + amount + "}"; }
    }

    // ===== Mock data =====
    private static final List<Employee> EMPLOYEES = List.of(
            new Employee(1, "Alice", 120_000, Gender.FEMALE),
            new Employee(2, "Bob", 90_000, Gender.MALE),
            new Employee(3, "Carol", 140_000, Gender.FEMALE),
            new Employee(4, "David", 110_000, Gender.MALE),
            new Employee(5, "Eve", 175_000, Gender.FEMALE),
            new Employee(6, "Frank", 175_000, Gender.MALE),
            new Employee(7, "Grace", 95_000, Gender.FEMALE)
    );

    private static final List<Integer> INTS = List.of(1,2,3,4,5,6,7,8,9,10,10,2,3,42,15,1);
    private static final List<String> STRINGS = List.of("apple", "banana", "pear", "kiwi", "plum", "apricot", "fig", "date", null, "avocado");
    private static final List<List<Integer>> LIST_OF_LISTS = List.of(List.of(1,2), List.of(3,4,5), List.of(6,7,7,8));
    private static final List<Transaction> TXS = List.of(
            new Transaction("T1", TxType.CREDIT, 120.0),
            new Transaction("T2", TxType.DEBIT, 50.0),
            new Transaction("T3", TxType.TRANSFER, 950.0),
            new Transaction("T4", TxType.REFUND, 20.0),
            new Transaction("T5", TxType.CREDIT, 1000.0),
            new Transaction("T6", TxType.DEBIT, 75.0),
            new Transaction("T7", TxType.CREDIT, 45.0)
    );
    private static final List<Person> PEOPLE = List.of(
            new Person("John", 34),
            new Person("Ravi", 28),
            new Person("Meera", 52),
            new Person("Wei", 52),
            new Person("Sara", 41)
    );
    private static final int[] ARRAY = { 9, 4, 6, 7, 2, 11, 9, 12, 4, 18, 17, 20 };

    // ===== Q1. How many male and female employees are there? =====
    static Map<Gender, Long> q1_countByGender(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    }

    // ===== Q2. Sum of even and odd numbers in a list =====
    static Map<String, Integer> q2_sumEvenOdd(List<Integer> nums) {
        int sumEven = nums.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        int sumOdd  = nums.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
        return Map.of("even", sumEven, "odd", sumOdd);
    }

    // ===== Q3. Find duplicate elements in an integers list =====
    static Set<Integer> q3_findDuplicates(List<Integer> nums) {
        Set<Integer> seen = new HashSet<>();
        return nums.stream()
                .filter(n -> !seen.add(n))
                .collect(Collectors.toSet());
    }

    // ===== Q4. Remove all occurrences of a given character =====
    static String q4_removeChar(String s, char c) {
        if (s == null) return null;
        return s.chars()
                .filter(ch -> ch != c)
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
    }

    // ===== Q5. Find special characters in a string (non-alphanumeric, non-space) =====
    static Set<Character> q5_specialChars(String s) {
        if (s == null) return Set.of();
        return s.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    // ===== Q6. Numbers starting with 1 from an integer list =====
    static List<Integer> q6_startsWith1(List<Integer> nums) {
        return nums.stream()
                .filter(n -> String.valueOf(n).startsWith("1"))
                .collect(Collectors.toList());
    }

    // ===== Q7. Employee with highest salary =====
    static Optional<Employee> q7_highestPaid(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
    }

    // ===== Q8. Concatenate list of strings into single CSV string =====
    static String q8_joinComma(List<String> items) {
        return items.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", "));
    }

    // ===== Q9. First non-repeating character in a string =====
    static Optional<Character> q9_firstNonRepeatingChar(String s) {
        if (s == null || s.isEmpty()) return Optional.empty();
        Map<Integer, Long> freq = s.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        return freq.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> (char) e.getKey().intValue())
                .findFirst();
    }

    // ===== Q10. Frequency of characters in a string =====
    static Map<Character, Long> q10_charFrequency(String s) {
        if (s == null) return Map.of();
        return s.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // ===== Q11. Group list of strings by length =====
    static Map<Integer, List<String>> q11_groupByLength(List<String> items) {
        return items.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(String::length));
    }

    // ===== Q12. Count occurrences of each char in a string (same as Q10) =====
    static Map<Character, Long> q12_charOccurrences(String s) {
        return q10_charFrequency(s);
    }

    // ===== Q13. Filter numbers > 10 and find their average =====
    static OptionalDouble q13_avgGreaterThan10(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n > 10)
                .mapToInt(Integer::intValue)
                .average();
    }

    // ===== Q14. Strings to map: string -> length =====
    static Map<String, Integer> q14_stringToLengthMap(List<String> items) {
        return items.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Function.identity(), String::length, (a, b) -> a, LinkedHashMap::new));
    }

    // ===== Q15. Flatten list of lists of integers =====
    static List<Integer> q15_flatten(List<List<Integer>> lol) {
        return lol.stream().flatMap(List::stream).collect(Collectors.toList());
    }

    // ===== Q16. Filter transactions by type and collect to a set =====
    static Set<Transaction> q16_filterTxType(List<Transaction> txs, TxType type) {
        return txs.stream()
                .filter(t -> t.getType() == type)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    // ===== Q17. First name of the oldest person =====
    static Optional<String> q17_oldestFirstName(List<Person> people) {
        return people.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .map(Person::getFirstName);
    }

    // ===== Q18. Skip first 5 elements in a list and return the rest =====
    static <T> List<T> q18_skipFirst5(List<T> list) {
        return list.stream().skip(5).collect(Collectors.toList());
    }

    // ===== Q19. Collect all unique words from a list of sentences =====
    static Set<String> q19_uniqueWords(List<String> sentences) {
        return sentences.stream()
                .filter(Objects::nonNull)
                .flatMap(s -> Arrays.stream(s.split("\\W+")))
                .map(String::trim)
                .filter(t -> !t.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    // ===== Q20. Filter out null values from list of strings =====
    static List<String> q20_filterNulls(List<String> items) {
        return items.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    // ===== Q21. Partition integers into even and odd =====
    static Map<Boolean, List<Integer>> q21_partitionEvenOdd(List<Integer> nums) {
        return nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }

    // ===== Q22. Infinite randoms; return first 10 =====
    static List<Integer> q22_first10Randoms() {
        return Stream.generate(() -> ThreadLocalRandom.current().nextInt(0, 1000))
                .limit(10)
                .collect(Collectors.toList());
    }

    // ===== Q23. Sum of squares of integers =====
    static int q23_sumOfSquares(List<Integer> nums) {
        return nums.stream().mapToInt(n -> n * n).sum();
    }

    // ===== Q24. List of strings -> list of their lengths =====
    static List<Integer> q24_lengths(List<String> items) {
        return items.stream()
                .filter(Objects::nonNull)
                .map(String::length)
                .collect(Collectors.toList());
    }

    // ===== Q25. Product of all elements (use long to reduce overflow risk) =====
    static long q25_product(List<Integer> nums) {
        return nums.stream().mapToLong(Integer::longValue).reduce(1L, (a, b) -> a * b);
    }

    // ===== Q26. Merge two lists of integers and remove duplicates =====
    static List<Integer> q26_mergeDistinct(List<Integer> a, List<Integer> b) {
        return Stream.concat(a.stream(), b.stream())
                .distinct()
                .collect(Collectors.toList());
    }

    // ===== Q27. Any string starts with prefix? =====
    static boolean q27_anyStartsWith(List<String> items, String prefix) {
        return items.stream()
                .filter(Objects::nonNull)
                .anyMatch(s -> s.startsWith(prefix));
    }

    // ===== Q28. Top three highest paid employees =====
    static List<Employee> q28_top3Paid(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()
                        .thenComparing(Employee::getName))
                .limit(3)
                .collect(Collectors.toList());
    }

    // ===== Q29. Second highest number in an array =====
    static OptionalInt q29_secondHighest(int[] arr) {
        return Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .mapToInt(Integer::intValue)
                .findFirst();
    }

    // ===== Q30. Sort a map by its values using streams =====
    static <K, V extends Comparable<? super V>> LinkedHashMap<K, V> q30_sortMapByValues(Map<K, V> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (a, b) -> a, LinkedHashMap::new));
    }

    // ===== Q31. Employee with 2nd highest salary =====
    static Optional<Employee> q31_secondHighestPaid(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()
                        .thenComparing(Employee::getName))
                .skip(1)
                .findFirst();
    }

    // ===== Q32. Employee with 3rd highest salary =====
    static Optional<Employee> q32_thirdHighestPaid(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()
                        .thenComparing(Employee::getName))
                .skip(2)
                .findFirst();
    }

    // ===== Q33. Remove consecutive duplicates from a list of integers =====
    static List<Integer> q33_removeConsecutiveDuplicates(List<Integer> nums) {
        if (nums.isEmpty()) return List.of();
        return IntStream.range(0, nums.size())
                .filter(i -> i == 0 || !Objects.equals(nums.get(i), nums.get(i - 1)))
                .mapToObj(nums::get)
                .collect(Collectors.toList());
    }

    // ===== Q34. Merge two arrays, sort them, and find distinct elements =====
    static int[] q34_mergeSortDistinct(int[] a, int[] b) {
        return IntStream.concat(Arrays.stream(a), Arrays.stream(b))
                .distinct()
                .sorted()
                .toArray();
    }

    // ===== Q35. Palindrome check via Streams (no explicit reverse) =====
    static boolean q35_isPalindrome(String s) {
        if (s == null) return false;
        String t = s; // keep original; or normalize if needed
        int n = t.length();
        return IntStream.range(0, n / 2)
                .allMatch(i -> t.charAt(i) == t.charAt(n - 1 - i));
    }

    // ===== Demo runner =====
    public static void main(String[] args) {
        System.out.println("Q1  Count by Gender: " + q1_countByGender(EMPLOYEES));
       // System.out.println("Q2  Sum Even/Odd: " + q2_sumEvenOdd(INTS));
       // System.out.println("Q3  Duplicates: " + q3_findDuplicates(INTS));
       // System.out.println("Q4  Remove 'a' from 'Java-Streams!': " + q4_removeChar("Java-Streams!", 'a'));
      //  System.out.println("Q5  Special chars in 'A@#b 12_$% c!': " + q5_specialChars("A@#b 12_$% c!"));
       // System.out.println("Q6  Starts with 1: " + q6_startsWith1(INTS));
      //  System.out.println("Q7  Highest paid: " + q7_highestPaid(EMPLOYEES).orElse(null));
      //  System.out.println("Q8  Join CSV: " + q8_joinComma(STRINGS));
      //  System.out.println("Q9  First non-repeating in 'swiss': " + q9_firstNonRepeatingChar("swiss").orElse(null));
     //   System.out.println("Q10 Char freq of 'banana': " + q10_charFrequency("banana"));
     //   System.out.println("Q11 Group by length: " + q11_groupByLength(STRINGS));
    //System.out.println("Q12 Char occurrences of 'Mississippi': " + q12_charOccurrences("Mississippi"));
        // System.out.println("Q13 Avg >10: " + q13_avgGreaterThan10(INTS).orElse(Double.NaN));
     //   System.out.println("Q14 Map str->len: " + q14_stringToLengthMap(STRINGS));
    //    System.out.println("Q15 Flatten: " + q15_flatten(LIST_OF_LISTS));
  //      System.out.println("Q16 CREDIT txs set: " + q16_filterTxType(TXS, TxType.CREDIT));
    //    System.out.println("Q17 Oldest first name: " + q17_oldestFirstName(PEOPLE).orElse(null));
    //    System.out.println("Q18 Skip first 5: " + q18_skipFirst5(INTS));
     //   System.out.println("Q19 Unique words: " + q19_uniqueWords(List.of(
    //            "Java streams rock!", "Streams process collections", "Java 8 introduced streams"
     //   )));
     //   System.out.println("Q20 Filter nulls: " + q20_filterNulls(STRINGS));
      //  System.out.println("Q21 Partition even/odd: " + q21_partitionEvenOdd(INTS));
      //  System.out.println("Q22 First 10 randoms: " + q22_first10Randoms());
    //    System.out.println("Q23 Sum of squares: " + q23_sumOfSquares(List.of(1,2,3,4,5)));
     //   System.out.println("Q24 Lengths: " + q24_lengths(STRINGS));
     //   System.out.println("Q25 Product: " + q25_product(List.of(1,2,3,4)));
   //     System.out.println("Q26 Merge distinct: " + q26_mergeDistinct(List.of(1,2,3,3,5), List.of(3,4,5,6)));
    //    System.out.println("Q27 Any starts with 'ap': " + q27_anyStartsWith(STRINGS, "ap"));
    //    System.out.println("Q28 Top 3 paid: " + q28_top3Paid(EMPLOYEES));
     //   System.out.println("Q29 2nd highest in array: " + (q29_secondHighest(ARRAY).isPresent() ? q29_secondHighest(ARRAY).getAsInt() : null));
    //    System.out.println("Q30 Sort map by values: " + q30_sortMapByValues(Map.of("b", 2, "a", 1, "c", 3)));
    //    System.out.println("Q31 2nd highest paid: " + q31_secondHighestPaid(EMPLOYEES).orElse(null));
    //    System.out.println("Q32 3rd highest paid: " + q32_thirdHighestPaid(EMPLOYEES).orElse(null));
     //   System.out.println("Q33 Remove consecutive dups [1,1,2,2,2,3,1,1]: " +
   //             q33_removeConsecutiveDuplicates(List.of(1,1,2,2,2,3,1,1)));
    //    System.out.println("Q34 Merge/sort/distinct arrays: " +
     //           Arrays.toString(q34_mergeSortDistinct(new int[]{5,1,3,3}, new int[]{2,3,4,4,5,6})));
      //  System.out.println("Q35 Palindrome 'madam': " + q35_isPalindrome("madam") +
      //          ", 'hello': " + q35_isPalindrome("hello"));
    }
}
