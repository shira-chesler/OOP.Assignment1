package observer;

public class ConcreteMember implements Member{
    private UndoableStringBuilder myusb;

    /**
     * A ConcreteMember constructor with no params
     */
    public ConcreteMember(){
        this.myusb = new UndoableStringBuilder();
    }

    /**
     * A ConcreteMember constructor with params
     * @param usb value to the current UndoableStringBuilder of the member
     */
    public ConcreteMember(UndoableStringBuilder usb){
        this.myusb = usb;
    }
    /**
     * the function updates the pointer to the members' groups'
     * UndoableStringBuilder using shallow copy
     * @param usb the admin status
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.myusb = usb;
    }
    /**
     * A function to gets the UndoAbleStringBuilder of the member
     * (the shallow copy of its Groups UndoAbleStringBuilder if the ConcreteMember is in one)
     * @return the shallow copy of the admin status
     */
    public UndoableStringBuilder getCopy() {
        return this.myusb;
    }
}
