package UjMedicalCenter;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

    public class RecordManager {
        public static void saveStudentRecords(ArrayList<Student> students, String filename) {
            try (FileWriter writer = new FileWriter(filename)) {
                for (Student student : students) {
                    writer.write("Student ID: " + student.getID() + "\n");
                    writer.write("Name: " + student.getName() + "\n");
                    writer.write("Phone: " + student.getPhoneNumber() + "\n");
                    writer.write("Branch: " + student.getBranch() + "\n");

                    writer.write("Appointments:\n");
                    for (Appointment appointment : student.getAppointments()) {
                        writer.write("- " + appointment.toString() + "\n");
                    }

                    writer.write("Health Record:\n");
                    for (String note : student.getHealthRecord().getNotes()) {
                        writer.write("- " + note + "\n");
                    }

                    writer.write("--------------------------------------------------\n");
                }
                System.out.println("Records saved to " + filename);
            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }
        }
    }

