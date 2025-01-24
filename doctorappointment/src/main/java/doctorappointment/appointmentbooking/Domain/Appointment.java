package doctorappointment.appointmentbooking.Domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "appointments")
public class Appointment {

    @Id
    private String id;

    @CreatedDate
    private Date CreatedAt;

    private String slotId;
    private String patientName;
    private Date reservedAt;
    private boolean isCompleted;

    public Appointment() {
    }

    public Appointment(String slotId, String patientName, Date reservedAt, boolean isCompleted) {
        this.slotId = slotId;
        this.patientName = patientName;
        this.reservedAt = reservedAt;
        this.isCompleted = isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public void cancel() {
        this.isCompleted = false;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public String getSlotId() {
        return slotId;
    }

    public String getPatientName() {
        return patientName;
    }

    public Date getReservedAt() {
        return reservedAt;
    }

    public boolean getStatus() {
        return isCompleted;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setReservedAt(Date reservedAt) {
        this.reservedAt = reservedAt;
    }

    public void setStatus(boolean status) {
        this.isCompleted = status;
    }
}
