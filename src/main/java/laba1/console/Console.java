package laba1.console;

import com.itextpdf.text.pdf.PdfWriter;
import laba1.model.Doctor;
import laba1.model.Employee;
import laba1.model.Patient;
import laba1.model.Room;
import laba1.service.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Console {
    private Scanner scanner = new Scanner(System.in);
    private DoctorService doctorService = new DoctorService();
    private EmployeeService employeeService = new EmployeeService();
    private PatientService patientService = new PatientService();
    private RoomService roomService = new RoomService();
    private PdfWriter pdfWrite = new PdfWriter();

    public void run() throws Exception {
        Integer item = 9;
        while (item != 20) {
            info();
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
                    findRoom();
                    break;
                }
                case 6: {
                    findPatient();
                    break;
                }
                case 7: {
                    findDoctor();
                    break;
                }
                case 8: {
                    findEmployee();
                    break;
                }
                case 9: {
                    updateRoom();
                    break;
                }
                case 10: {
                    updatePatient();
                    break;
                }
                case 11: {
                    updateDoctor();
                    break;
                }
                case 12: {
                    updateEmployee();
                    break;
                }
                case 13: {
                    deleteRoom();
                    break;
                }
                case 14: {
                    deletePatient();
                    break;
                }
                case 15: {
                    deleteDoctor();
                    break;
                }
                case 16: {
                    deleteEmployee();
                    break;
                }
                case 17: {
                    viewAll();
                    break;
                }
                case 18: {
                    viewFreeRooms();
                    break;
                }
                case 19: {
                    saveInfo();
                    break;
                }
                default: {
                    item = 20;
                }
            }
        }


    }

    private void saveInfo() {
        System.out.println("Please, enter a filename");
        String fileName = scanner.nextLine();;
        pdfWrite.write(fileName, roomVOList);
    }

    private void info() {
        System.out.println("1.Add room");
        System.out.println("2.Add patient");
        System.out.println("3.Add doctor");
        System.out.println("4.Add employee");
        System.out.println("5.Find room");
        System.out.println("6.Find patient");
        System.out.println("7.Find doctor");
        System.out.println("8.Find employee");
        System.out.println("9.Update room");
        System.out.println("10.Update patient");
        System.out.println("11.Update doctor");
        System.out.println("12.Update employee");
        System.out.println("13.Delete room");
        System.out.println("14.Delete patient");
        System.out.println("15.Delete doctor");
        System.out.println("16.Delete employee");
        System.out.println("17.View all");
        System.out.println("18.View free rooms");
        System.out.println("19.Exit");
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

    private void findPatient() throws Exception {
        scanner.nextLine();
        System.out.println("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.println(patientService.getByName(name).toString());
    }

    private void findRoom() throws Exception {
        scanner.nextLine();
        System.out.println("Enter room name: ");
        String name = scanner.nextLine();
        System.out.println(roomService.getByName(name).toString());
    }

    private void findDoctor() throws Exception {
        scanner.nextLine();
        System.out.println("Enter doctor name: ");
        String name = scanner.nextLine();
        System.out.println(doctorService.getByName(name).toString());
    }

    private void findEmployee() throws Exception {
        scanner.nextLine();
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.println(employeeService.getByName(name).toString());
    }


    private void deletePatient() throws Exception {
        scanner.nextLine();
        System.out.println("Enter patient name for deleting: ");
        String name = scanner.nextLine();
        if(patientService.getByName(name)!= null) {
            patientService.delete(patientService.getByName(name).getId());
        }else {
            System.out.println("Patient don't exists");
        }
    }

    private void deleteRoom() throws Exception {
        scanner.nextLine();
        System.out.println("Enter room name for deleting: ");
        String name = scanner.nextLine();
        if(roomService.getByName(name)!= null) {
            roomService.delete(roomService.getByName(name).getId());
        }else {
            System.out.println("Room don't exists");
        }
    }

    private void deleteEmployee() throws Exception {
        scanner.nextLine();
        System.out.println("Enter employee name for deleting: ");
        String name = scanner.nextLine();
        if(employeeService.getByName(name)!= null) {
            employeeService.delete(employeeService.getByName(name).getId());
        }else {
            System.out.println("Employee don't exists");
        }
    }

    private void deleteDoctor() throws Exception {
        scanner.nextLine();
        System.out.println("Enter doctor name for deleting: ");
        String name = scanner.nextLine();
        if(doctorService.getByName(name)!= null) {
            doctorService.delete(doctorService.getByName(name).getId());
        }else {
            System.out.println("Doctor don't exists");
        }
    }

    private void updatePatient() throws Exception {
        scanner.nextLine();
        System.out.println("Enter patient name: ");
        String name = scanner.nextLine();
        Patient patient = patientService.getByName(name);
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
        patient.setRoomId(roomService.getByName(roomName).getId());
        patient.setDoctorId(doctorService.getByName(doctorName).getId());
        patientService.update(patient);
    }

    private void updateRoom() throws Exception {
        scanner.nextLine();
        System.out.println("Enter room name: ");
        String name = scanner.nextLine();
        Room room = roomService.getByName(name);
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

    private void updateEmployee() throws Exception {
        scanner.nextLine();
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();
        Employee employee = employeeService.getByName(name);
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

    private void updateDoctor() throws Exception {
        scanner.nextLine();
        System.out.println("Enter doctor name: ");
        String name = scanner.nextLine();
        Doctor doctor = doctorService.getByName(name);
        System.out.println("Enter new params:");
        System.out.println("Enter doctor name: ");
        String newName = scanner.nextLine();
        doctor.setName(newName);
        doctorService.update(doctor);
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

        System.out.println("_____DOCTORS____");
        for(Doctor doctor : doctors){
            System.out.println(doctor.toString());
        }
        System.out.println("________________");
        System.out.println("_____EMPLOYEES____");
        for(Employee employee : employees){
            System.out.println(employee.toString());
        }
        System.out.println("________________");
        System.out.println("_____PATIENTS____");
        for(Patient patient : patients){
            System.out.println(patient.toString());
        }
        System.out.println("________________");
        System.out.println("_____ROOMS____");
        for(Room room : rooms){
            System.out.println(room.toString());
        }
        System.out.println("________________");
    }
}

