public class StudentParticipant extends Participant {
    private String course;
    private int currentSemester;
    
    public StudentParticipant(String id, String fullName, String email, String course, int currentSemester) {
        super(id, fullName, email);
        this.course = course;
        this.currentSemester = currentSemester;
    }
    
    public String getCourse() {
        return course;
    }
    
    public int getCurrentSemester() {
        return currentSemester;
    }
    
    @Override
    public String describeRole() {
        return "Estudante do curso " + course + " no " + currentSemester + "º semestre";
    }
    
    @Override
    public String toString() {
        return "StudentParticipant{" +
                "id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", course='" + course + '\'' +
                ", currentSemester=" + currentSemester +
                '}';
    }
}

