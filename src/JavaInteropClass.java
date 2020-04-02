import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;

public class JavaInteropClass {
    public static void main(String[] args) {
        JavaInteropObject.myStaticMethod();

        println(JavaInteropObject.constant);

        println(JavaInteropObject.nonPrimitiveElement);

        println(JavaInteropObject.INSTANCE.nameForJava());

        println(JavaInteropObject.INSTANCE.methodWithOverloads("", 1, true));
    }

    private static void println(Object object) {
        System.out.println(object.toString());
    }
}
