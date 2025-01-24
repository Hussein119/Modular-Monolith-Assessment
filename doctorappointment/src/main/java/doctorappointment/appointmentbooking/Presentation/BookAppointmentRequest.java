package doctorappointment.appointmentbooking.Presentation;

public class BookAppointmentRequest {

    private String doctorId;
    private String slotId;
    private String patientName;
    private String patientId;

    public String getDoctorId() {
        return doctorId;
    }

    public String getSlotId() {
        return slotId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
