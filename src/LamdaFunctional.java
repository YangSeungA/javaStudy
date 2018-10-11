/**
 * 람다 함수형자바 예제
 * - 익명함수, 고계함수,
 *
 */
public class LamdaFunctional {

    /**
     * 함수형 인터페이스
     */
    public interface Functional1{
        boolean accept();
    }

    public interface Functional2{
        boolean accept();
        default boolean reject(){ return !accept(); }
    }
    /*
        () -> {}                     // No parameters; result is void
        () -> 42                     // No parameters, expression body
        () -> null                   // No parameters, expression body
        () -> { return 42; }         // No parameters, block body with return
        () -> { System.gc(); }       // No parameters, void block body
        () -> {
                if (true) { return 12; }
                else { return 11; }
            }                      // Complex block body with returns
        (int x) -> x+1             // Single declared-type parameter
        (int x) -> { return x+1; } // Single declared-type parameter
        (x) -> x+1                 // Single inferred-type parameter
        x -> x+1                   // Parens optional for single inferred-type case
        (String s) -> s.length()   // Single declared-type parameter
        (Thread t) -> { t.start(); } // Single declared-type parameter
        s -> s.length()              // Single inferred-type parameter
        t -> { t.start(); }          // Single inferred-type parameter
        (int x, int y) -> x+y      // Multiple declared-type parameters
        (x,y) -> x+y               // Multiple inferred-type parameters
        (final int x) -> x+1       // Modified declared-type parameter
        (x, final y) -> x+y        // Illegal: can't modify inferred-type parameters
        (x, int y) -> x+y          // Illegal: can't mix inferred and declared types

   */
}
