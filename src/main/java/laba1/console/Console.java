package laba1.console;

import laba1.model.Doctor;
import laba1.model.Employee;
import laba1.model.Patient;
import laba1.model.Room;
import laba1.service.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Console {
    private Scanner scanner = new Scanner(System.in);
    private DoctorService doctorService = new DoctorService();
    private EmployeeService employeeService = new EmployeeService();
    private PatientService patientService = new PatientService();
    private RoomService roomService = new RoomService();
    private PdfWrite pdfWrite = new PdfWrite();

    private void addActions() throws Exception {
        Integer item = 12;
        while (item != 5) {
            addInfo();
            item = scanner.nextInt();
            switch (item) {
                case 1: {
                    addRoom();
                    break;
                }
                case 2: {
                    addPatient();
                    break;
                }
                case 3: {
                    addDoctor();
                    break;
                }
                case 4: {
                    addEmployee();
                    break;
                }
                case 5: {
                    run();
                    break;
                }
                default: {
                    item = 5;
                }
            }
        }
    }

    private void findActions() throws Exception {
        Integer item = 12;
        while (item != 5) {
            findInfo();
            item = scanner.nextInt();
            switch (item) {
                case 1: {
                    findRoom();
                    break;
                }
                case 2: {
                    findPatient();
                    break;
                }
                case 3: {
                    findDoctor();
                    break;
                }
                case 4: {
                    findEmployee();
                    break;
                }
                case 5: {
                    run();
                    break;
                }
                default: {
                    item = 5;
                }
            }
        }
    }

    private void deleteActions() throws Exception {
        Integer item = 12;
        while (item != 5) {
            deleteInfo();
            item = scanner.nextInt();
            switch (item) {
                case 1: {
                    deleteRoom();
                    break;
                }
                case 2: {
                    deletePatient();
                    break;
                }
                case 3: {
                    deleteDoctor();
                    break;
                }
                case 4: {
                    deleteEmployee();
                    break;
                }
                case 5: {
                    run();
                    break;
                }
                default: {
                    item = 5;
                }
            }
        }
    }

    private void updateActions() throws Exception {
        Integer item = 12;
        while (item != 5) {
            updateInfo();
            item = scanner.nextInt();
            switch (item) {
                case 1: {
                    updateRoom();
                    break;
                }
                case 2: {
                    updatePatient();
                    break;
                }
                case 3: {
                    updateDoctor();
                    break;
                }
                case 4: {
                    updateEmployee();
                    break;
                }
                case 5: {
                    run();
                    break;
                }
                default: {
                    item = 5;
                }
            }
        }
    }

    public void run() throws Exception {
        Integer item = 9;
        while (item != 8) {
            info();
            item = scanner.nextInt();
            switch (item) {
                case 1: {
                    addActions();
                    break;
                }
                case 2: {
                    findActions();
                    break;
                }
                case 3: {
                    updateActions();
                    break;
                }
                case 4: {
                    deleteActions();
                    break;
                }
                case 5: {
                    viewAll();
                    break;
                }
                case 6: {
                    viewFreeRooms();
                    break;
                }
                case 7: {
                    saveInfo();
                    break;
                }
                default: {
                    item = 8;
                }
            }
        }


    }

    private void saveInfo() throws SQLException {
        scanner.nextLine();
        System.out.println("Please, enter a filename");
        String fileName = scanner.nextLine();
        List<String> allElements = new ArrayList<>();

        allElements.add(doctorService.getAll().stream().map(Doctor::toString)
                .collect(Collectors.joining(", ")));
        allElements.add(employeeService.getAll().stream().map(Employee::toString)
                .collect(Collectors.joining(", ")));
        allElements.add(patientService.getAll().stream().map(Patient::toString)
                .collect(Collectors.joining(", ")));
        allElements.add(roomService.getAll().stream().map(Room::toString)
                .collect(Collectors.joining(", ")));
        pdfWrite.write(fileName, allElements);
    }

    private void addInfo() {
        System.out.println("        1.Add room");
        System.out.println("        2.Add patient");
        System.out.println("        3.Add doctor");
        System.out.println("        4.Add employee");
        System.out.println("        5.Menu");
    }

    private void findInfo() {
        System.out.println("        1.Find room");
        System.out.println("        2.Find patient");
        System.out.println("        3.Find doctor");
        System.out.println("        4.Find employee");
        System.out.println("        5.Menu");
    }

    private void deleteInfo() {
        System.out.println("        1.Delete room");
        System.out.println("        2.Delete patient");
        System.out.println("        3.Delete doctor");
        System.out.println("        4.Delete employee");
        System.out.println("        5.Menu");
    }

    private void updateInfo() {
        System.out.println("        1.Update room");
        System.out.println("        2.Update patient");
        System.out.println("        3.Update doctor");
        System.out.println("        4.Update employee");
        System.out.println("        5.Menu");
    }

    private void info() {
        System.out.println("        Menu");
        System.out.println("        1.Add ...");
        System.out.println("        2.Find ....");
        System.out.println("        3.Update ...");
        System.out.println("        4.Delete ....");
        System.out.println("        5.View all");
        System.out.println("        6.View free rooms");
        System.out.println("        7.Save info");
        System.out.println("        8.Exit");
    }

    private Room addRoom() throws Exception {
        scanner.nextLine();
        System.out.println("Enter room name: ");
        String name = scanner.nextLine();
        System.out.println("Enter rooms size: ");
        Integer size = scanner.nextInt();
        System.out.println("Enter rooms free places: ");
        Integer freePlaces = scanner.nextInt();
        Room room = new Room();
        room.setName(name);
        room.setSize(size);
        room.setFreePlaces(freePlaces);
        return roomService.add(room);
    }

    private Employee addEmployee() throws Exception {
        scanner.nextLine();
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.println("Enter employee position: ");
        String position = scanner.nextLine();
        System.out.println("Enter employee mobile phone: ");
        String mobilePhone = scanner.nextLine();
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPosition(position);
        employee.setMobilePhone(mobilePhone);
        return employeeService.add(employee);
    }

    private Patient addPatient() throws Exception {
        scanner.nextLine();
        System.out.println("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.println("Enter patient diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.println("Enter room name: ");
        String roomName = scanner.nextLine();
        System.out.println("Enter doctor name: ");
        String doctorName = scanner.nextLine();
        Patient patient = new Patient();
        patient.setDiagnosis(diagnosis);
        patient.setName(name);
        Room room = roomService.getByName(roomName);
        Doctor doctor = doctorService.getByName(doctorName);
        if (doctor == null || room == null) {
            System.out.println("room or doctor don't exists");
            return null;
        }
        patient.setRoomId(roomService.getByName(roomName).getId());
        patient.setDoctorId(doctorService.getByName(doctorName).getId());
        return patientService.add(patient);
    }

    private Doctor addDoctor() throws Exception {
        scanner.nextLine();
        System.out.println("Enter doctor name: ");
        String name = scanner.nextLine();
        Doctor doctor = new Doctor();
        doctor.setName(name);
        return doctorService.add(doctor);
    }

    private boolean printAndExistsCheck(Object object) {
        if (object == null) {
            System.out.println("Element don't exists");
            return false;
        } else {
            System.out.println(object.toString());
            return true;
        }
    }

    private void findPatient() throws Exception {
        scanner.nextLine();
        System.out.println("Enter patient name: ");
        String name = scanner.nextLine();
        printAndExistsCheck(patientService.getByName(name));
    }

    private void findRoom() throws Exception {
        scanner.nextLine();
        System.out.println("Enter room name: ");
        String name = scanner.nextLine();
        printAndExistsCheck(roomService.getByName(name));
    }

    private void findDoctor() throws Exception {
        scanner.nextLine();
        System.out.println("Enter doctor name: ");
        String name = scanner.nextLine();
        printAndExistsCheck(doctorService.getByName(name));
    }

    private void findEmployee() throws Exception {
        scanner.nextLine();
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();
        printAndExistsCheck(employeeService.getByName(name));
    }


    private void deletePatient() throws Exception {
        scanner.nextLine();
        System.out.println("Enter patient name for deleting: ");
        String name = scanner.nextLine();
        if (patientService.getByName(name) != null) {
            patientService.delete(patientService.getByName(name).getId());
        } else {
            System.out.println("Patient don't exists");
        }
    }

    private void deleteRoom() throws Exception {
        scanner.nextLine();
        System.out.println("Enter room name for deleting: ");
        String name = scanner.nextLine();
        if (roomService.getByName(name) != null) {
            roomService.delete(roomService.getByName(name).getId());
        } else {
            System.out.println("Room don't exists");
        }
    }

    private void deleteEmployee() throws Exception {
        scanner.nextLine();
        System.out.println("Enter employee name for deleting: ");
        String name = scanner.nextLine();
        if (employeeService.getByName(name) != null) {
            employeeService.delete(employeeService.getByName(name).getId());
        } else {
            System.out.println("Employee don't exists");
        }
    }

    private void deleteDoctor() throws Exception {
        scanner.nextLine();
        System.out.println("Enter doctor name for deleting: ");
        String name = scanner.nextLine();
        if (doctorService.getByName(name) != null) {
            doctorService.delete(doctorService.getByName(name).getId());
        } else {
            System.out.println("Doctor don't exists");
        }
    }

    private void updatePatient() throws Exception {
        scanner.nextLine();
        System.out.println("Enter patient name: ");
        String name = scanner.nextLine();
        Patient patient = patientService.getByName(name);
        if (printAndExistsCheck(patient)) {
            System.out.println("Enter new params:");
            System.out.println("Enter patient name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter patient diagnosis: ");
            String diagnosis = scanner.nextLine();
            System.out.println("Enter room name: ");
            String roomName = scanner.nextLine();
            System.out.println("Enter doctor name: ");
            String doctorName = scanner.nextLine();
            patient.setDiagnosis(diagnosis);
            patient.setName(newName);
            Room room = roomService.getByName(roomName);
            Doctor doctor = doctorService.getByName(doctorName);
            if (doctor == null || room == null) {
                System.out.println("room or doctor don't exists");
                return;
            }
            patient.setRoomId(room.getId());
            patient.setDoctorId(doctor.getId());
            patientService.update(patient);
        }
    }

    private void updateRoom() throws Exception {
        scanner.nextLine();
        System.out.println("Enter room name: ");
        String name = scanner.nextLine();
        Room room = roomService.getByName(name);
        if (printAndExistsCheck(room)) {
            System.out.println("Enter new params:");
            System.out.println("Enter room name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter rooms size: ");
            Integer size = scanner.nextInt();
            System.out.println("Enter rooms free places: ");
            Integer freePlaces = scanner.nextInt();
            room.setName(newName);
            room.setSize(size);
            room.setFreePlaces(freePlaces);
            roomService.update(room);
        }
    }

    private void updateEmployee() throws Exception {
        scanner.nextLine();
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();
        Employee employee = employeeService.getByName(name);
        if (printAndExistsCheck(employee)) {
            System.out.println("Enter new params:");
            System.out.println("Enter employee name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter employee position: ");
            String position = scanner.nextLine();
            System.out.println("Enter employee mobile phone: ");
            String mobilePhone = scanner.nextLine();
            employee.setName(newName);
            employee.setPosition(position);
            employee.setMobilePhone(mobilePhone);
            employeeService.update(employee);
        }
    }

    private void updateDoctor() throws Exception {
        scanner.nextLine();
        System.out.println("Enter doctor name: ");
        String name = scanner.nextLine();
        Doctor doctor = doctorService.getByName(name);
        if (printAndExistsCheck(doctor)) {
            System.out.println("Enter new params:");
            System.out.println("Enter doctor name: ");
            String newName = scanner.nextLine();
            doctor.setName(newName);
            doctorService.update(doctor);
        }
    }

    private void viewFreeRooms() throws SQLException {
        roomService.getFreeRooms().forEach(room -> {
            System.out.println(room.toString());
        });
    }

    private void viewAll() throws SQLException {
        List<Doctor> doctors = doctorService.getAll();
        List<Employee> employees = employeeService.getAll();
        List<Patient> patients = patientService.getAll();
        List<Room> rooms = roomService.getAll();

        System.out.println(":::::::::::DOCTORS::::::::::");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.toString());
        }
        System.out.println("******************************");
        System.out.println(":::::::::::EMPLOYEES:::::::::::::");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
        System.out.println("******************************");
        System.out.println("::::::::::::::::PATIENTS::::::::::::::::");
        for (Patient patient : patients) {
            System.out.println(patient.toString());
        }
        System.out.println("**************************");
        System.out.println(":::::::::::::::::ROOMS::::::::::::::");
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
        System.out.println("***********************");
    }
}

