package doctorappointment.appointmentbooking.Application;


import doctorappointment.appointmentbooking.Domain.Appointment;
import doctorappointment.doctoravailability.Entity.Slot;
import doctorappointment.appointmentbooking.Infrastructure.AppointmentRepository;
import doctorappointment.doctoravailability.Repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Slot> viewAvailableSlots() {
        return slotRepository.findByIsReservedFalse();
    }

    @Override
    public Appointment bookAppointment(String slotId, String patientName) {
        // Check if the slot is available
        Slot slot = slotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        if (slot.isReserved()) {
            throw new RuntimeException("Slot is already reserved");
        }

        // Mark the slot as reserved
        slot.setReserved(true);
        slotRepository.save(slot);

        // Create and save the appointment
        Appointment appointment = new Appointment(slotId, patientName, new Date());
        appointmentRepository.save(appointment);
        return appointment;
    }
}