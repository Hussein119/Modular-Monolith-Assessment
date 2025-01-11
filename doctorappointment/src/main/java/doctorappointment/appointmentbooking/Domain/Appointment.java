package doctorappointment.appointmentbooking.Domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Document(collection = "appointments")
public class Appointment {

    @Id
    private String id; // Let MongoDB generate this as ObjectId

    @CreatedDate // Automatically populate this field on creation
    private Date reservedAt;

    private String slotId;
    private String patientName;

    public Appointment() {
    }

    public Appointment(String slotId, String patientName, Date reservedAt) {
        this.slotId = slotId;
        this.patientName = patientName;
        this.reservedAt = reservedAt;
    }

    public String getSlotId() {
        return slotId;
    }

    public String getPatientId() {
        return id;
    }

    public String getPatientName() {
        return patientName;
    }

    public Date getReservedAt() {
        return reservedAt;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

}
