package main.observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender {
    private ArrayList<Member> members;
    private UndoableStringBuilder usb;

    /**
     * A groupAdmin constructor with params
     * @param usb value to the current UndoableStringBuilder of the group
     */
    public GroupAdmin(UndoableStringBuilder usb){
        this.members = new ArrayList<>();
        this.usb = usb;
    }

    /**
     * A groupAdmin constructor with no params
     */
    public GroupAdmin(){
        this.members = new ArrayList<>();
        this.usb = new UndoableStringBuilder();
    }

    /**
     * The function adds a member to the group and updates the member with
     * the undoableStringBuilder of the group.
     * @param obj = a member to add (a new member)
     */
    @Override
    public void register(Member obj) {
        members.add(obj);
        obj.update(this.usb);
    }

    /**
     * The function removes a member from the group
     * @param obj = the string we want to remove
     */
    @Override
    public void unregister(Member obj) {
        members.remove(obj);
    }

    /**
     * a function that runs through all members and updates them
     */
    public void updateAll(){
        if (usb != null) {
            for (int i = 0; i < members.size(); i++) {
                members.get(i).update(this.usb);
            }
        }
    }

    /**
     * Inserts a desirable String at a wanted place of the undoableStringBuilder
     * of the group, by index and updates all members
     * @param offset = index where to insert the desirable String
     * @param obj = the desirable String to insert
     */
    @Override
    public void insert(int offset, String obj) {
        usb.insert(offset, obj);
        this.updateAll();
    }

    /**
     * Appends a given String to the existing undoableStringBuilder of the group
     * and updates all members.
     * @param obj = a string that the user wants to append to the existing String.
     */
    @Override
    public void append(String obj) {
        usb.append(obj);
        this.updateAll();
    }

    /**
     * Deletes a desirable part of the undoableStringBuilder of the group and
     * updates all members.
     * desirable part given by start and end indexes.
     * @param start = The index from which the user wants to start deleting.
     * @param end = The index where the user wants to stop deleting.
     */
    @Override
    public void delete(int start, int end) {
        usb.delete(start, end);
        this.updateAll();
    }

    /**
     *  Undoing the last action that was preformed on the UndoableStringBuilder
     *  of the group and updates all members
     */
    @Override
    public void undo() {
        usb.undo();
        this.updateAll();
    }

    /**
     * A function to get the private members list
     * @return the members list
     */
    public ArrayList<Member> getMembers() {
        return this.members;
    }

    /**
     * creates a string for printing
     * @return String of list of members
     */
    @Override
    public String toString() {
        System.out.println("Group's latest update (UndoableStringBuilder): "+this.usb);
        return members.toString();
    }
}
