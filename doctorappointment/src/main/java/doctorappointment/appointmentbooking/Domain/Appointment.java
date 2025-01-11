package doctorappointment.appointmentbooking.Domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "appointments")
public class Appointment {

    @Id
    private String id; // Let MongoDB generate this as ObjectId

    @CreatedDate // Automatically populate this field on creation
    private Date CreatedAt;

    private String slotId;
    private String patientName;
    private Date reservedAt;

    public Appointment() {
    }

    public Appointment(String slotId, String patientName, Date reservedAt) {
        this.slotId = slotId;
        this.patientName = patientName;
        this.reservedAt = reservedAt;
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

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setReservedAt(Date reservedAt) {
        this.reservedAt = reservedAt;
    }
}
