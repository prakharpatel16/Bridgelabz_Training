public class Patient {
    // ---------- STATIC ----------
    private static String hospitalName;
    private static int totalPatients = 0;

    // ---------- INSTANCE VARIABLES ----------
    private final String patientID; // Final → unique identifier (immutable)
    private String name;
    private int age;
    private String ailment;

    // ---------- CONSTRUCTOR (using 'this') ----------
    public Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++; // increment patient count whenever new object is created
    }

    // ---------- STATIC METHODS ----------
    public static void setHospitalName(String name) {
        hospitalName = name;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    // ---------- INSTANCE METHOD ----------
    public void displayPatientDetails() {
        // Using 'instanceof' before processing
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        } else {
            System.err.println("❌ Invalid object: Not an instance of Patient");
        }
    }

    // ---------- GETTERS ----------
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAilment() {
        return ailment;
    }

    public String getPatientID() {
        return patientID;
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {
        // Set hospital name (shared for all patients)
        Patient.setHospitalName("City Hospital");

        // Create patient objects
        Patient patient1 = new Patient("Lathika", 30, "Flu", "P001");
        Patient patient2 = new Patient("Lidiya", 45, "Fracture", "P002");

        // Display total patients
        System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());

        // Display details
        patient1.displayPatientDetails();
        System.out.println();
        patient2.displayPatientDetails();
    }
}
