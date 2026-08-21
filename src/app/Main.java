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

        Teacher teacher1 = new TeacherFullTime("Jorge Diaz", 3500000.0, 3);
        Teacher teacher2 = new TeacherFullTime("Francisco Rodriguez", 3000000.0, 4);
        Teacher teacher3 = new TeacherPartTime("Pablo Gomez", 5000000.0, 8);
        Teacher teacher4 = new TeacherPartTime("Lucia Perez", 4000000.0, 4);
        teachersList.add(teacher1);
        teachersList.add(teacher2);
        teachersList.add(teacher3);
        teachersList.add(teacher4);


        Scanner sc = new Scanner(System.in);

        while (!exit){
            System.out.println("\n--------- Restaurante, seleccione una opcion ---------\n" +
                    "1. Listar profesores\n" +
                    "2. Listar clases\n" +
                    "3. Crear estudiante y añadirlo a clase\n" +
                    "4. Crear una nueva clase y añadir estudiantes y profesor\n" +
                    "5. Buscar clases de estudiante" +
                    "6. Salir");

            System.out.println("Seleccione una opcion: ");
            int option = sc.nextInt();
            sc.nextLine();

            if (option == 1){
                for (int i = 0; i < teachersList.size(); i++){
                    System.out.println(i + 1 + ". " + "Nombre: " + teachersList.get(i).getName() + ", " +
                            "salario calculado: " + String.format(new Locale("es","ES"), "%,.0f", teachersList.get(i).calculateSalary()));
                }
            }
        }
        
    }
}