package classes
        public class Professor {
    String firstName;
    String lastName;
    @Override
            public String toString(){
        return "Professor{" + "firstName=" + ", lastName=" + lastName + '}';
    }
    public Professor(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
            public String getFullName() {
                return firstName + " " + lastName;
            }

        }


        package classes
public class Student {
    String firstName;
    String lastName;
    int groupNumber;
    public Student(String firstName, String lastName, int groupnumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.groupNumber = groupNumber;
    }
    @Override
    public String toString(){
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", groupNumber=" + groupNumber + '}';
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public int getGroupNumber() {
            return groupNumber;
        }
        public void setGroupNumber(int groupNumber) {
            this.groupNumber = groupNumber;
        }
    public String getFullName() {
        return firstName + " " + lastName;
    }
}


package classes;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.ArrayList;
        import java.util.List;
public class CourseManager {
    Course[] courses;
    public CourseManager() {
        courses = new Course[0];
    }
    public void addCourse(Course course) {
        int newLength = courses.length + 1;
        Course[] aux = new Course[newLength];
        System.arraycopy(courses, 0, aux, 0, courses.length);
        aux[newLength - 1] = course;
        this.courses = aux;
    }
    public void displayCoursesToConsole() {
        for (Course c : courses) {
            System.out.println(c);
        }
    }
    public void enrollStudent(String courseName, Student student) {
        for (Course course : courses) {
            if (course.getName().equals(courseName)) {
                course.enrollStudent(student);
                System.out.println(student.getName() + " has been enrolled in " + courseName);
                return;
            }
        }
        System.out.println("Course '" + courseName + "' does not exist.");
    }
    public List<Student> listStudentsInCourse(String courseName) {
        List<Student> enrolledStudents = new ArrayList<>();
        for (Course course : courses) {
            if (course.getName().equals(courseName)) {
                enrolledStudents = course.getEnrolledStudents();
                return enrolledStudents;
            }
        }
        System.out.println("Course '" + courseName + "' does not exist.");
        return enrolledStudents;
    }
    public double calculateAverageGradeForCourse(String courseName) {
        double totalGrade = 0.0;
        int studentCount = 0;
        for (Course course : courses) {
            if (course.getName().equals(courseName)) {
                List<Student> students = course.getEnrolledStudents();
                for (Student student : students) {
                    totalGrade += student.getGradeForCourse(courseName);
                    studentCount++;
                }
                if (studentCount > 0) {
                    return totalGrade / studentCount;
                }
            }
        }
        System.out.println("Course '" + courseName + "' does not exist.");
        return 0.0;
    }
    public double calculateAverageGradeGivenByProfessor(String professorName) {
        double totalGrade = 0.0;
        int courseCount = 0;
        for (Course course : courses) {
            if (course.getProfessor().equals(professorName)) {
                List<Student> students = course.getEnrolledStudents();
                for (Student student : students) {
                    totalGrade += student.getGradeForCourse(course.getName());
                }
                courseCount++;
            }
        }
        if (courseCount > 0) {
            return totalGrade / courseCount;
        }
        System.out.println("No courses taught by professor '" + professorName + "' found.");
        return 0.0;
    }
}

