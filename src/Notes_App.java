import java.io.*;
import java.util.Scanner;

public class Notes_App {

    // Write a note to the chosen file
    public static void writeNote(String fileName, String note) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(note + "\n");
            System.out.println("Note saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the note.");
            e.printStackTrace();
        }
    }

    // Read all notes from the chosen file
    public static void readNotes(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\n--- Notes from " + fileName + " ---");
            boolean hasNotes = false;
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
                hasNotes = true;
            }
            if (!hasNotes) {
                System.out.println("(No notes found)");
            }
            System.out.println("------------------\n");
        } catch (IOException e) {
            System.out.println("No notes found or error while reading " + fileName);
        }
    }

    // Delete all notes (clear the chosen file)
    public static void deleteNotes(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(""); // overwrite with empty content
            System.out.println("All notes deleted successfully from " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while deleting notes.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Notes App ===");
            System.out.println("1. Add a note");
            System.out.println("2. View notes");
            System.out.println("3. Delete all notes");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter file name to save note: ");
                    String writeFile = scanner.nextLine();
                    System.out.print("Enter your note: ");
                    String note = scanner.nextLine();
                    writeNote(writeFile, note);
                    break;
                case 2:
                    System.out.print("Enter file name to read notes: ");
                    String readFile = scanner.nextLine();
                    readNotes(readFile);
                    break;
                case 3:
                    System.out.print("Enter file name to delete all notes: ");
                    String deleteFile = scanner.nextLine();
                    deleteNotes(deleteFile);
                    break;
                case 4:
                    System.out.println("Exiting Notes App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

