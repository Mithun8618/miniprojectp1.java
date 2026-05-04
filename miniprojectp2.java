class Subject {
    String name;
    String teacher;
    String room;

    Subject(String name, String teacher, String room) {
        this.name = name;
        this.teacher = teacher;
        this.room = room;
    }
}

public class miniprojectp2 {

    static Subject[] subjects = {
        new Subject("Math", "A", "R1"),
        new Subject("Science", "B", "R2"),
        new Subject("English", "A", "R3"),
        new Subject("History", "C", "R1")
    };

    static String[] slots = {"Slot1", "Slot2", "Slot3", "Slot4"};

    static String[] timetable = new String[subjects.length];

    static boolean isSafe(int current, int slotIndex) {
        for (int i = 0; i < current; i++) {
            if (timetable[i].equals(slots[slotIndex])) {

                if (subjects[i].teacher.equals(subjects[current].teacher)) {
                    return false;
                }

                if (subjects[i].room.equals(subjects[current].room)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean generateTimetable(int index) {
        if (index == subjects.length) {
            return true;
        }

        for (int i = 0; i < slots.length; i++) {
            if (isSafe(index, i)) {
                timetable[index] = slots[i];

                if (generateTimetable(index + 1)) {
                    return true;
                }

                timetable[index] = null;
            }
        }
        return false;
    }

    static void display() {
        System.out.println("Generated Timetable:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i].name + " -> " + timetable[i] +
                    " (Teacher: " + subjects[i].teacher +
                    ", Room: " + subjects[i].room + ")");
        }
    }

    public static void main(String[] args) {

        if (generateTimetable(0)) {
            display();
        } else {
            System.out.println("No valid timetable found.");
        }
    }
}
