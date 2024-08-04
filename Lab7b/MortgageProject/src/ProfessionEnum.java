public enum ProfessionEnum {

    DEVELOPER("Developer"),
    ARCHITECT("Architect"),
    SCRUM_MASTER("Scrum master"),
    TESTER("Tester"),
    SYSTEM_ADMINISTRATOR("System Administrator"),
    TECHNICAL_WRITER("Technical writer"),
    DEPARTMENT_HEAD("Department head"),
    PROFESSOR("Professor");

    private final String value;

    ProfessionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
