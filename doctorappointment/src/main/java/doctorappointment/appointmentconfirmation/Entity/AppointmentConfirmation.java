package doctorappointment.appointmentconfirmation.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class AppointmentConfirmation {

    @Id
    private String id; // Let MongoDB generate this as ObjectId

    @CreatedDate // Automatically populate this field on creation
    private Date time;

    private String patientName;
    private String doctorName;
    private Date appointmentTime;

    public AppointmentConfirmation() {
    }

    public AppointmentConfirmation(String patientName, String doctorName, Date appointmentTime) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentTime = appointmentTime;
    }

    public String getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
