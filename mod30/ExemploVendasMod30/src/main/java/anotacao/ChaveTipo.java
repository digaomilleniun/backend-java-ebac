package anotacao;

import java.lang.annotation.*;

/**
 * @author rodrigo.pires
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ChaveTipo {

    String value();
}
