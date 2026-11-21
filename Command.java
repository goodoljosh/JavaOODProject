
/**
 * Creates command interface for later use in other classes.
 *
 * @author Josh Findley
 * @version 11/14/2026
 */
public interface Command {
    //Command initializes simple methods to be called upon later
    void execute();
    void undo();
}