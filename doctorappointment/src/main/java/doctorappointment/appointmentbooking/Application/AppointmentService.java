package doctorappointment.appointmentbooking.Application;

import doctorappointment.appointmentbooking.Domain.Appointment;
import doctorappointment.doctoravailability.Entity.Slot;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {
    List<Slot> viewAvailableSlots();
    Appointment bookAppointment(String slotId, String patientName);
}
