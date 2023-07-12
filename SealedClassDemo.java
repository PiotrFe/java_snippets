

sealed class MySealedClass permits Alpha, Beta {}

// classes extending a sealed class must be either final, sealed or non-sealed
final class Alpha extends MySealedClass implements MySealedIF {
    public void myMethod() {}
}
sealed class Beta extends MySealedClass implements MySealedIF permits Gamma {
    public void myMethod() {}
}
non-sealed class Gamma extends Beta {}

// sealed interfaces are also possible
sealed interface MySealedIF permits Alpha, Beta {
    void myMethod();
}


public class SealedClassDemo {
    
}
