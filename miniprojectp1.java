class Ride {
    int rideId;
    String pickup;
    String drop;
    double fare;

    Ride(int rideId, String pickup, String drop, double fare) {
        this.rideId = rideId;
        this.pickup = pickup;
        this.drop = drop;
        this.fare = fare;
    }

    void display() {
        System.out.println("Ride ID: " + rideId +
                ", Pickup: " + pickup +
                ", Drop: " + drop +
                ", Fare: " + fare);
    }
}

// Node class
c2lass Node {
    Ride data;
    Node next;

    Node(Ride data) {
        this.data = data;
        this.next = null;
    }
}

// Linked List class
class RideHistory {
    Node head;

    // Add ride at end
    void addRide(Ride r) {
        Node newNode = new Node(r);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Delete last ride
    void deleteLastRide() {
        if (head == null) {
            System.out.println("No rides to delete.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    // Display all rides
    void displayRides() {
        if (head == null) {
            System.out.println("No ride history.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            temp.data.display();
            temp = temp.next;
        }
    }

    // Search by location (pickup or drop)
    void searchRide(String location) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.data.pickup.equalsIgnoreCase(location) ||
                temp.data.drop.equalsIgnoreCase(location)) {

                temp.data.display();
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No rides found for location: " + location);
        }
    }

    // Reverse the linked list
    void reverseHistory() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }
}

// Main class
public class miniprojectp1 {
    public static void main(String[] args) {
        RideHistory history = new RideHistory();

        history.addRide(new Ride(1, "Bangalore", "Mysore", 1200));
        history.addRide(new Ride(2, "Chennai", "Vellore", 800));
        history.addRide(new Ride(3, "Hyderabad", "Warangal", 600));

        System.out.println("All Rides:");
        history.displayRides();

        System.out.println("\nSearch for 'Chennai':");
        history.searchRide("Chennai");

        System.out.println("\nAfter deleting last ride:");
        history.deleteLastRide();
        history.displayRides();

        System.out.println("\nReversed Ride History:");
        history.reverseHistory();
        history.displayRides();
    }
}
