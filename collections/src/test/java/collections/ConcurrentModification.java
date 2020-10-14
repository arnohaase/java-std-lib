package collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static collections.Event.*;

enum Event {Activate, Start, Preempt, Resume, End, Terminate};

public class ConcurrentModification {

    List<Event> myList = new ArrayList<>();

    @Test
    public void testProcessEvents() {
        addEvent(Activate);
        addEvent(Start);
        addEvent(Preempt);
        addEvent(Resume);
        addEvent(Preempt);
        addEvent(Resume);
        addEvent(End);

        for (Event e : myList) {
            processEvent(e);
        }
    }

    public void addEvent(Event event) {
        myList.add(event);
    }

    private void processEvent(Event event) {
        switch (event) {
            case End -> scheduleCleanup();
            default -> execute(event);
        }
    }

    private void execute(Event event) {
        // do stuff
    }

    private void scheduleCleanup() {
        addEvent(Terminate);
    }
}
