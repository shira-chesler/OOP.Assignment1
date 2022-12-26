package observer;

/*
Use the class you've implemented in previous assignment
 */
/**
 * A StringBuilder class with the option to undo actions
 * @version 2 10 Nov 2022
 * @author Ofri Leifer and Shira Chesler
 */

public class UndoableStringBuilder{

    private java.lang.StringBuilder internal;
    private java.util.Stack<String> save_prev;

    /**
     * Constructor - builds an UndoableStringBuilder object
     */
    public UndoableStringBuilder(){
        this.internal = new java.lang.StringBuilder();
        this.save_prev = new java.util.Stack<>();
    }

    /**
     * Appends a given String to the existing String.
     * @param str = a string that the user wants to append to the existing String.
     * @return UndoableStringBuilder that contains all the operations 'till now
     */
    public UndoableStringBuilder append(String str){
        save_prev.push(internal.toString());
        internal.append(str);
        return this;
    }

    /**
     * Deletes a desirable part of the String,
     * desirable part given by start and end indexes
     * @param start = The index from which the user wants to start deleting.
     * @param end = The index where the user wants to stop deleting.
     * @return UndoableStringBuilder that contains all the operations 'till now
     */
    public UndoableStringBuilder delete(int start, int end){
        try{
            save_prev.push(internal.toString());
            internal.delete(start, end);
            return this;
        }
        catch (StringIndexOutOfBoundsException ex){
            save_prev.pop();
            System.err.println("start index is negative, greater than length(), or greater than end.");
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Inserts a desirable Sting at a wanted place, by index
     * @param offset = index where to insert the desirable String
     * @param str = the desirable String to insert
     * @return UndoableStringBuilder that contains all the operations 'till now
     */
    public UndoableStringBuilder insert(int offset, String str){
        try{
            save_prev.push(internal.toString());
            internal.insert(offset, str);
            return this;
        }
        catch(StringIndexOutOfBoundsException ex){
            save_prev.pop();
            System.err.println("The offset int is invalid");
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Replaces a desirable part of the string with another, given string
     * @param start = index from where to start replacing
     * @param end = index where to stop replacing
     * @param str = with what String to replace the desirable part
     * @return UndoableStringBuilder that contains all the operations 'till now
     */
    public UndoableStringBuilder replace(int start, int end, String str){
        try{
            save_prev.push(internal.toString());
            internal.replace(start, end, str);
            return this;
        }
        catch (StringIndexOutOfBoundsException ex){
            save_prev.pop();
            System.err.println("start index is negative, greater than length(), or greater than end.");
            ex.printStackTrace();
        }
        catch (NullPointerException nex){
            save_prev.pop();
            System.err.println("a pointer to null has been given");
            nex.printStackTrace();
        }
        return null;
    }

    /**
     * Reversing the String, from end to start
     * @return UndoableStringBuilder that contains all the operations 'till now
     */
    public UndoableStringBuilder reverse(){
        save_prev.push(internal.toString());
        internal.reverse();
        return this;
    }

    /**
     *  Undoing the last action that was preformed on the String
     */
    public void undo(){
        if (!save_prev.empty()) {
            this.internal = new java.lang.StringBuilder(save_prev.pop());
        }
    }

    /**
     * Makes a String represent of the object
     * @return String representation
     */
    @Override
    public String toString(){
        return internal.toString();
    }


}

