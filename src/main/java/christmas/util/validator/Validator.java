package christmas.util.validator;

public abstract class Validator {
    abstract void validate(String input) throws IllegalArgumentException;
}