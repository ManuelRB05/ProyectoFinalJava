package app;

import model.Classes;
import model.Student;
import model.Teacher;
import model.TeacherFullTime;
import model.TeacherPartTime;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;

        ArrayList<Teacher> teachersList = new ArrayList<>();
        ArrayList<Student> studentsList = new ArrayList<>();
        ArrayList<Classes> classesList = new ArrayList<>();

        /* Profesores inicializados */

        Teacher teacher1 = new TeacherFullTime("Jorge Diaz", 3500000.0, 3);
        Teacher teacher2 = new TeacherFullTime("Francisco Rodriguez", 3000000.0, 4);
        Teacher teacher3 = new TeacherPartTime("Pablo Gomez", 5000000.0, 8);
        Teacher teacher4 = new TeacherPartTime("Lucia Perez", 4000000.0, 4);
        teachersList.add(teacher1);
        teachersList.add(teacher2);
        teachersList.add(teacher3);
        teachersList.add(teacher4);

        /* Estudiantes inicializados */

        Student student1 = new Student("Catalina Cuida", 20);
        Student student2 = new Student("Alejandra Rincon", 18);
        Student student3 = new Student("Julian Hernandez", 19);
        Student student4 = new Student("Alberto Gonzalez", 21);
        Student student5 = new Student("Santiago Vargas", 17);
        Student student6 = new Student("Roberto Diaz", 20);

        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);
        studentsList.add(student5);
        studentsList.add(student6);

        /* Clases inicializadas y añadir estudiantes */

        Classes class1 = new Classes("Quimica general", 203, teacher1);
        Classes class2 = new Classes("POO", 504, teacher3);
        Classes class3 = new Classes("IA", 202, teacher2);
        Classes class4 = new Classes("Ingles", 607, teacher4);

        classesList.add(class1);
        classesList.add(class2);
        classesList.add(class3);
        classesList.add(class4);

        class1.addStudent(student1);
        class1.addStudent(student3);

        class2.addStudent(student2);
        class2.addStudent(student4);

        class3.addStudent(student5);
        class4.addStudent(student6);

        Scanner sc = new Scanner(System.in);

        while (!exit) {
            System.out.println("\n--------- Sistema Universitario, seleccione una opcion ---------\n" +
                    "1. Listar profesores\n" +
                    "2. Listar clases\n" +
                    "3. Crear estudiante y añadirlo a clase\n" +
                    "4. Crear una nueva clase y añadir estudiantes y profesor\n" +
                    "5. Buscar clases de estudiante\n" +
                    "6. Salir\n");

            System.out.println("Seleccione una opcion: ");
            int option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
                for (int i = 0; i < teachersList.size(); i++) {
                    System.out.println(i + 1 + ". " + "Nombre: " + teachersList.get(i).getName() + ", " +
                            "salario calculado: " + String.format(new Locale("es", "ES"), "%,.0f", teachersList.get(i).calculateSalary()));
                }
            } else if (option == 2) {
                for (int i = 0; i < classesList.size(); i++) {
                    System.out.println(i + 1 + ". " + "Clase: " + classesList.get(i).getName() + ", salon: " + classesList.get(i).getClassroom());
                }
                System.out.println("\n--------- Seleccione una clase para ver su infomracion: ---------\n");
                int classSelected = sc.nextInt();
                if (classSelected >= 1 && classSelected <= classesList.size()) {
                    System.out.println("Profesor: " + classesList.get(classSelected - 1).getTeacher().toString() + ". Estudiantes: " + classesList.get(classSelected - 1).getStudents().toString());
                } else {
                    System.out.println("Esa clase no existe");
                }
            } else if (option == 3) {
                System.out.println("Ingrese el nombre del estudiante: ");
                String studentName = sc.nextLine();
                System.out.println("Ingrese la edad del estudiante: ");
                Integer studentAge = sc.nextInt();
                System.out.println("Ingrese el numero de la clase para el estudiante: ");
                Integer studentClass = sc.nextInt();

                Student newStudent = new Student(studentName, studentAge);
                if (studentClass >= 1 && studentClass <= classesList.size()) {
                    classesList.get(studentClass - 1).addStudent(newStudent);
                    studentsList.add(newStudent);
                } else {
                    System.out.println("La clase que selecciono no existe");
                }
            } else if (option == 4) {
                System.out.println("Ingrese el nombre de la clase: ");
                String className = sc.nextLine();
                System.out.println("Ingrese el numero del salon para la clase: ");
                Integer classClassroom = sc.nextInt();
                System.out.println("Ingrese el numero en lista del profesor para esta clase: ");
                Integer classTeacher = sc.nextInt();

                if (classTeacher >= 1 && classTeacher <= teachersList.size()) {
                    Classes newClass = new Classes(className, classClassroom, teachersList.get(classTeacher - 1));
                    classesList.add(newClass);

                    for (int i = 0; i < studentsList.size(); i++) {
                        System.out.println("ID: " + studentsList.get(i).getId() + ". Nombre: " + studentsList.get(i).toString());
                    }

                    System.out.println("\nIngrese el ID del estudiante para añadirlo a la clase: ");
                    Integer classStudent = sc.nextInt();

                    Student foundStudent = null;
                    for (int i = 0; i < studentsList.size(); i++) {
                        if (studentsList.get(i).getId().equals(classStudent)) {
                            foundStudent = studentsList.get(i);
                            break;
                        }
                    }
                    if (foundStudent != null) {
                        newClass.addStudent(foundStudent);
                    } else {
                        System.out.println("No existe un estudiante en la lista con ese ID");
                    }
                } else {
                    System.out.println("El profesor ingresado no existe");
                }
            } else if (option == 5) {
                for (int i = 0; i < studentsList.size(); i++) {
                    System.out.println("ID: " + studentsList.get(i).getId() + ". Nombre: " + studentsList.get(i).toString());
                }
                System.out.println("Escriba el ID del estudiante para buscar las clases a las que pertenece: \n");
                Integer searchIdStudent = sc.nextInt();

                for (int i = 0; i < classesList.size(); i++) {
                    for (int j = 0; j < classesList.get(i).getStudents().size(); j++) {
                        if (classesList.get(i).getStudents().get(j).getId().equals(searchIdStudent)) {
                            System.out.println("Numero de clase: " + i + 1 + ". Clase: " + classesList.get(i).getName() + ", salon: " + classesList.get(i).getClassroom());
                            break;
                        }
                    }
                }
            } else if (option == 6) {
                exit = true;
            }
            else {
                System.out.println("Opcion no disponible");
            }
        }
    }
}