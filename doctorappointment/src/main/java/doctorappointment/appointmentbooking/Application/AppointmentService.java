package doctorappointment.appointmentbooking.Application;

import doctorappointment.appointmentbooking.Domain.Appointment;
import doctorappointment.doctoravailability.Entity.Slot;

import java.util.Date;
import java.util.List;

public interface AppointmentService {
    List<Slot> viewAvailableSlots();
    Appointment bookAppointment(String doctorId,String slotId,String patientId, String patientName);
}
