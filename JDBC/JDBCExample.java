import packages.Student;

public class JDBCExample {
    public static void main(String[] args) {
        Student student = new Student();
        student.connectionEstablish();
        // student.createTable();
        // student.insertData();
        // student.readData();
        // student.updateData();
        student.deleteData();
        student.readData();
    }
}
