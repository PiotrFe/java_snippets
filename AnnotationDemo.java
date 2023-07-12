import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str() default "testing";
    int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description() default "nothing";
}

@Retention(RetentionPolicy.RUNTIME)
@interface Marker{}

@Retention(RetentionPolicy.RUNTIME)
@interface SingleMemberAnno {
    int value(); // this variable name must be value
}


@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RepeatedAnnos.class)
@interface RepeatedAnno {
    String str() default "resting";
    int val() default 9000;
}

@Retention (RetentionPolicy.RUNTIME)
@interface RepeatedAnnos {
    RepeatedAnno[] value();
}

@What(description = "An annotation test class")

class AnnotatedClass {
    int price = 0;
    String name = "";

    @What(description = "An annotation test method")
    @MyAnno(str = "Annotation example", val = 100)
    public void myMethod(int p, String n) {
        price = p;
        name = n;
    }

    @What()
    @Marker()
    @SingleMemberAnno(100)
    public void myOtherMethod() {
    }

    @RepeatedAnno(str = "First annotation", val = -1)
    @RepeatedAnno(str = "Second annotation", val = 100)
    public void myThirdMethod() {

    }
}


public class AnnotationDemo {
    public static void main(String[] args) {
        AnnotatedClass ac = new AnnotatedClass();

        try {
            Class<?> c = ac.getClass();
            Method m = c.getMethod("myMethod", int.class, String.class);
            Method m2 = c.getMethod("myOtherMethod");
            Method m3 = c.getMethod("myThirdMethod");
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());

            Annotation[] classAnnos = c.getAnnotations();
            Annotation[] methodAnnos = m.getAnnotations();
            Annotation[] method2Annos = m2.getAnnotations();
            Annotation repeatedAnno = m3.getAnnotation(RepeatedAnnos.class); // here we have to use container annotation associated with repeatable annotation


            System.out.println("All class annotations:");
            
            for (Annotation a : classAnnos) {
                System.out.println(a);
            }

            System.out.println("");

            System.out.println("All method 1 annotations:");

            for (Annotation a : methodAnnos) {
                System.out.println(a);
            }

            System.out.println("");

            System.out.println("All method 2 annotations:");

            for (Annotation a : method2Annos) {
                System.out.println(a);
            }

            System.out.println("Marked annotation is present: " + m2.isAnnotationPresent(Marker.class));
            System.out.println("Repeatable anno: " + repeatedAnno);


        } catch (NoSuchMethodException e) {
            System.out.println("Method not found");
        }
    }
}