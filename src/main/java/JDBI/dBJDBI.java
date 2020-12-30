package JDBI;

import org.jdbi.v3.core.Jdbi;

public class dBJDBI {

    private final String connectionString;
    private final Jdbi jdbi;
    public dBJDBI( String connectionString) {
        this.connectionString = connectionString;
        jdbi =Jdbi.create(connectionString);
    }


//    public List<Student> getStudentsByName(String studentName) {
//        ArrayList<Student> studenten ;
//        studenten = (ArrayList<Student>) jdbi.withHandle(handle -> handle.createQuery("SELECT * FROM student WHERE naam = :naam")
//                .bind("naam", studentName)
//                .mapToBean(Student.class)
//                .list());
//        return studenten;
//    }
//
//
//    public void saveNewStudent(Student student) {
//        String sql = "INSERT INTO student(naam, voornaam, studnr, goedbezig) " +
//                "VALUES ('" + student.getNaam() + "', '" + student.getVoornaam() + "', " + student.getStudentnr() + ", " +
//                student.isGoedbezig() + ")";
//        System.out.println(sql);
//        jdbi.useHandle(handle -> {
//            handle.execute(sql);
//        });
//    }
//
//
//    public void updateStudent(Student student) {
//        String sql =" update student set voornaam = "+ "'"+student.getVoornaam()+"'" +
//                ", naam = " + " '" + student.getNaam() + "'"+ ",  goedbezig =" +student.isGoedbezig() + " where student.studnr =" + student.getStudentnr();
//
//        System.out.println(sql);
//        jdbi.useHandle(handle -> {
//            handle.execute(sql);
//        });
//    }








}
