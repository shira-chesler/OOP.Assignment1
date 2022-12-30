package main.observer;

public class ConcreteMember implements Member{
    private static int id_count=0;
    private int id;
    private String name;
    private UndoableStringBuilder myusb;

    /**
     * A ConcreteMember constructor with no params
     */
    public ConcreteMember(){
        id_count++;
        this.id = id_count;
        this.name = "anonymous";
        this.myusb = new UndoableStringBuilder();
    }

    /**
     * A ConcreteMember constructor with name param
     * @param name for the member
     */
    public ConcreteMember(String name){
        id_count++;
        this.id = id_count;
        this.name = name;
        this.myusb = new UndoableStringBuilder();
    }

    /**
     * A ConcreteMember constructor with name and UndoableStringBuilder params
     * @param usb value to the current UndoableStringBuilder of the member
     * @param name for the member
     */
    public ConcreteMember(UndoableStringBuilder usb, String name){
        id_count++;
        this.id = id_count;
        this.name = name;
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
     * @return the shallow copy of the admin update.
     */
    public UndoableStringBuilder getCopy() {
        return this.myusb;
    }

    /**
     * creates a string for printing.
     * @return String of members' features.
     */
    @Override
    public String toString(){
        return "name: "+this.name+", id: "+this.id+", group's latest update (UndoableStringBuilder): "+this.getCopy().toString();
    }
}
