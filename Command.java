// COMMAND PATTERN: defines an operation that can be executed.
public interface Command<T> {
    T execute();
}
