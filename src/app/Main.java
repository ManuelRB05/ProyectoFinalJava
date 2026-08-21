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

        /* Clases inicializadas */

        Classes class1 = new Classes("Quimica general", 203, teacher1);
        Classes class2 = new Classes("POO", 203, teacher3);
        Classes class3 = new Classes("IA", 203, teacher2);
        Classes class4 = new Classes("Ingles", 203, teacher4);

        classesList.add(class1);
        classesList.add(class2);
        classesList.add(class3);
        classesList.add(class4);

        Scanner sc = new Scanner(System.in);

        while (!exit){
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

            if (option == 1){
                for (int i = 0; i < teachersList.size(); i++){
                    System.out.println(i + 1 + ". " + "Nombre: " + teachersList.get(i).getName() + ", " +
                            "salario calculado: " + String.format(new Locale("es","ES"), "%,.0f", teachersList.get(i).calculateSalary()));
                }
            }
            else if (option == 2){
                for (int i = 0; i < classesList.size(); i++){
                    System.out.println(i + 1 + ". " + "Clase: " + classesList.get(i).getName() + ", salon: " + classesList.get(i).getClassroom());
                }
            }
        }
        
    }
}