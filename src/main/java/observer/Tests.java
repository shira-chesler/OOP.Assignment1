package observer;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.IOException;
import java.util.logging.FileHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Tests {

    @Test
    void printJVMUtilities(){
        System.out.println(JvmUtilities.jvmInfo());
        ConcreteMember m1 = new ConcreteMember();
        GroupAdmin g = new GroupAdmin();
        System.out.println(JvmUtilities.objectFootprint(g));
        g.append("hello everyone!");
        g.register(m1);
        System.out.println(JvmUtilities.objectFootprint(g));

        System.out.println("member -" + JvmUtilities.objectTotalSize(m1));
        System.out.println("group admin -" + JvmUtilities.objectTotalSize(g));
    }
    @Test
    void testRegister() {
        ConcreteMember m1 = new ConcreteMember();
        GroupAdmin g = new GroupAdmin();
        g.append("hello everyone!");
        g.register(m1);
        assertEquals(true, (g.getMembers().contains(m1)));
    }

    @Test
    void testUnregister() {
        ConcreteMember m1 = new ConcreteMember();
        GroupAdmin g = new GroupAdmin();
        g.append("hello everyone!");
        g.register(m1);
        g.unregister(m1);

        assertEquals(false, (g.getMembers().contains(m1)));
    }

    @Test
    void testInsert() {
        ConcreteMember m1 = new ConcreteMember();
        GroupAdmin g = new GroupAdmin();
        g.append("hello everyone!");
        g.register(m1);
        g.insert(5, " world");
        assertEquals("hello world everyone!", m1.getCopy().toString());
    }

    @Test
    void testInsertOutOfBounds() {
        ConcreteMember m1 = new ConcreteMember();
        GroupAdmin g = new GroupAdmin();
        g.append("hello everyone!");
        g.register(m1);
        g.append("hello");
        assertNull(m1.getCopy().insert(30, " world"));
    }

    @Test
    void testAppend() {
        ConcreteMember m1 = new ConcreteMember();
        GroupAdmin g = new GroupAdmin();
        g.register(m1);

        g.append("\n");
        g.append("hello");
        g.append("\t");
        g.append("world");
        assertEquals("\nhello\tworld", m1.getCopy().toString());
    }

    @Test
    void testDelete() {
        ConcreteMember m1 = new ConcreteMember();
        GroupAdmin g = new GroupAdmin();
        g.register(m1);
        g.append("hello");
        g.delete(-1,67);
        assertEquals("hello", m1.getCopy().toString());
    }

    @Test
    void testUndo() {
        ConcreteMember m1 = new ConcreteMember();
        GroupAdmin g = new GroupAdmin();
        g.register(m1);
        g.undo();
        assertEquals("", m1.getCopy().toString());
    }

    @Test
    void testUpdate() {
        ConcreteMember m1 = new ConcreteMember();
        UndoableStringBuilder str = new UndoableStringBuilder();
        m1.update(str);
        assertEquals(str, m1.getCopy());
    }
}
