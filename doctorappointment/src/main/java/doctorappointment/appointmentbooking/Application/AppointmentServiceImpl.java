package doctorappointment.appointmentbooking.Application;


import doctorappointment.appointmentbooking.Domain.Appointment;
import doctorappointment.doctoravailability.Entity.Slot;
import doctorappointment.appointmentbooking.Infrastructure.AppointmentRepository;
import doctorappointment.doctoravailability.Repository.SlotRepository;
import doctorappointment.appointmentconfirmation.Event.AppointmentBookedEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<Slot> viewAvailableSlots() {
        return slotRepository.findByIsReservedFalse();
    }

    @Override
    public Appointment bookAppointment(String doctorId,String slotId,String patientId, String patientName) {
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
        Appointment appointment = new Appointment(slotId, patientName, new Date(), false);
        appointmentRepository.save(appointment);

        // Publish the event to send a notification
        eventPublisher.publishEvent(new AppointmentBookedEvent(this, appointment));

        return appointment;
    }
}