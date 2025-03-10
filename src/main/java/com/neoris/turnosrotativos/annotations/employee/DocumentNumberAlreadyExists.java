
package com.neoris.turnosrotativos.annotations.employee;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Federico Fernando Sorgi Rosenthal
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DocumentNumberAlreadyExistsValidator.class)
public @interface DocumentNumberAlreadyExists {

    String message() default  "";

    //El metodo groups() devuelve un arreglo de grupos de validacion.
    Class<?>[] groups() default {};

    //El metodo payload() devuelve un arreglo de objetos que pueden contener informacion adicional sobre la restriccion de validacion.
    Class<? extends Payload>[] payload() default {};
}
