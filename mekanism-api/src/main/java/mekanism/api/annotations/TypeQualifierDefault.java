package mekanism.api.annotations;

/*
    Taken from javax
    https://github.com/amaembo/jsr-305/blob/master/ri/src/main/java/javax/annotation/meta/TypeQualifierDefault.java
*/

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This qualifier is applied to an annotation to denote that the annotation
 * defines a default type qualifier that is visible within the scope of the
 * element it is applied to.
 */

@Documented
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeQualifierDefault {
    ElementType[] value() default {};
}
