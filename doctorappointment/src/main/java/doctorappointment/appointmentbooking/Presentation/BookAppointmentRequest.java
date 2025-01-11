package doctorappointment.appointmentbooking.Presentation;

public class BookAppointmentRequest {

    private String slotId;
    private String patientName;

    // Getters and Setters
    public String getSlotId() {
        return slotId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
