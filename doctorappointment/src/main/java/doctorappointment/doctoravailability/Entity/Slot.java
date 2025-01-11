package doctorappointment.doctoravailability.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collection = "slots")
public class Slot {
    @Id
    private String id; // Let MongoDB generate this as ObjectId

    @CreatedDate // Automatically populate this field on creation
    private Date time;

    private String doctorName;
    private boolean isReserved;
    private double cost;

    public Slot(String doctorName, boolean isReserved, double cost) {
        this.doctorName = doctorName;
        this.isReserved = isReserved;
        this.cost = cost;
    }

    public Date getTime() {
        return time;
    }

    public String getDoctorId() {
        return id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}