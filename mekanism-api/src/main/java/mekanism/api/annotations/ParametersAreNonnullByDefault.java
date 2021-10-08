package mekanism.api.annotations;

/*
    Taken from javax
    https://github.com/amaembo/jsr-305/blob/master/ri/src/main/java/javax/annotation/ParametersAreNonnullByDefault.java
*/

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation can be applied to a package, class or method to indicate that
 * the method parameters in that element are nonnull by default unless there is:
 * <ul>
 * <li>An explicit nullness annotation
 * <li>The method overrides a method in a superclass (in which case the
 * annotation of the corresponding parameter in the superclass applies)
 * <li>There is a default parameter annotation (like {@link ParametersAreNullableByDefault})
 * applied to a more tightly nested element.
 * </ul>
 *
 * @see org.jetbrains.annotations.NotNull
 */
@Documented
@NotNull
@TypeQualifierDefault(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParametersAreNonnullByDefault {
}