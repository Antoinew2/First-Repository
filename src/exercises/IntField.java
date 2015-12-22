package exercises;

/*
 * File: IntField.java
 *
 * Description:  This version of IntField has both an upper and lower bound
 *  associated with it. The user must type a number within these bounds
 *  into the field. A programmer defined exception, IntOutOfRangeException, is
 *  thrown if the bound is exceeded.
 * Note that upperBound and lowerBound are set initially to MAX and MIN possible
 *  values respectively. This allows the field to accept any numeric input if
 *  its first constructor is used.
 *
 *  Assignment: See ColorPicker.java
 */

import javax.swing.*;
import javax.swing.event.*;

public class IntField extends JTextField {
    private int upperBound = Integer.MAX_VALUE;
    private int lowerBound = Integer.MIN_VALUE;

    /**
     * IntField() constructor merely invokes its superclass
     *  constructor, in this way inheriting all the properties
     *  of a JTextField.
     */
    public IntField (int size) {
        super(size);
    }

    /**
     * This IntField() constructor sets the field's two bounds.
     */
    public IntField(int size, int min, int max) {
        super(size);
        upperBound = max;
        lowerBound = min;
    }

    /**
     * getInt() converts the field's text to an int and returns it.
     *  This version also checks that the field's bounds are not exceeded
     *  and raises an exception if one or the other is. The method also makes clear that
     *  a NumberFormatException could be thrown. This would happen if the
     *  user types a value that is not a valid integer.
     * @return an int representing the integer typed into the text field
     */
    public int getInt() throws NumberFormatException, IntOutOfRangeException {
        int num = Integer.parseInt(getText());
        if (num > upperBound)
            throw new IntOutOfRangeException(upperBound);
        else if (num < lowerBound)
            throw new IntOutOfRangeException(lowerBound);
        return num;
    } // getInt()

} // IntField