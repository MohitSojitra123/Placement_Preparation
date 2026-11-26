public class BoxingDemo {

    public static void main(String[] args) {

        // ==========================================
        // 1. Primitive Data Type
        // ==========================================

        int a = 10;

        System.out.println("Primitive value = " + a);


        // ==========================================
        // 2. BOXING
        // ==========================================
        // Manually converting int into Integer object
        // using Integer.valueOf()

        Integer b = Integer.valueOf(a);

        System.out.println("After Boxing = " + b);


        // ==========================================
        // 3. AUTOBOXING
        // ==========================================
        // Java automatically converts int into Integer.
        // We don't need to use Integer.valueOf().

        int c = 20;

        Integer d = c;

        System.out.println("After Autoboxing = " + d);


        // ==========================================
        // 4. UNBOXING
        // ==========================================
        // Converting Integer object back into int
        // manually using intValue()

        Integer e = Integer.valueOf(30);

        int f = e.intValue();

        System.out.println("After Unboxing = " + f);


        // ==========================================
        // 5. AUTO-UNBOXING
        // ==========================================
        // Java automatically converts Integer into int.

        Integer g = 40;

        int h = g;

        System.out.println("After Auto-Unboxing = " + h);
    }
}