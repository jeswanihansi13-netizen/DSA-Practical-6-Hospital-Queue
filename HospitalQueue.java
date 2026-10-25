
import java.util.Scanner;

class Patient {
    int id;
    String name;
    String problem;
    Patient next;

    Patient(int id, String name, String problem) {
        this.id = id;
        this.name = name;
        this.problem = problem;
        this.next = null;
    }
}

public class HospitalQueue {
    Patient front = null;
    Patient rear = null;
    Scanner sc = new Scanner(System.in);

    // Add a patient
    void enqueue() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Patient Problem: ");
        String problem = sc.nextLine();

        Patient newPatient = new Patient(id, name, problem);

        if (rear == null) {
            front = rear = newPatient;
        } else {
            rear.next = newPatient;
            rear = newPatient;
        }

        System.out.println("Patient added successfully!");
    }

    // Process the first patient
    void dequeue() {
        if (front == null) {
            System.out.println("No patients in the queue.");
            return;
        }

        System.out.println("\nProcessing Patient:");
        System.out.println("ID: " + front.id);
        System.out.println("Name: " + front.name);
        System.out.println("Problem: " + front.problem);

        front = front.next;

        if (front == null) {
            rear = null;
        }

        System.out.println("Patient processed successfully!");
    }

    // Display all patients
    void display() {
        if (front == null) {
            System.out.println("No patients waiting.");
            return;
        }

        Patient temp = front;

        System.out.println("\n--- Hospital Patient Queue ---");

        while (temp != null) {
            System.out.println("ID: " + temp.id
                    + " | Name: " + temp.name
                    + " | Problem: " + temp.problem);

            temp = temp.next;
        }
    }

    // View the next patient
    void peek() {
        if (front == null) {
            System.out.println("No patients in the queue.");
            return;
        }

        System.out.println("Next Patient: " + front.name);
        System.out.println("Patient ID: " + front.id);
        System.out.println("Problem: " + front.problem);
    }

    public static void main(String[] args) {
        HospitalQueue q = new HospitalQueue();
        int choice;

        do {
            System.out.println("\n===== Hospital Patient Management =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Process Patient");
            System.out.println("3. Display Waiting Patients");
            System.out.println("4. View Next Patient");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = q.sc.nextInt();

            switch (choice) {
                case 1:
                    q.enqueue();
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    q.peek();
                    break;
                case 5:
                    System.out.println("Exiting Hospital Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        q.sc.close();
    }
}
