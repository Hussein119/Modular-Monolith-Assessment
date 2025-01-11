package doctorappointment.appointmentconfirmation.Listener;

import doctorappointment.appointmentbooking.Domain.Appointment;
import doctorappointment.doctoravailability.Entity.Slot;
import doctorappointment.doctoravailability.Repository.SlotRepository;
import doctorappointment.appointmentconfirmation.Entity.AppointmentConfirmation;
import doctorappointment.appointmentconfirmation.Event.AppointmentBookedEvent;
import doctorappointment.appointmentconfirmation.Service.AppointmentConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppointmentBookedEventListener {

    @Autowired
    private AppointmentConfirmationService confirmationService;

    @Autowired
    private SlotRepository slotRepository;

    @EventListener
    public void handleAppointmentBookedEvent(AppointmentBookedEvent event) {
        Appointment appointment = event.getAppointment();

        // Fetch the doctor's name using the slotId
        String doctorName = slotRepository.findById(appointment.getSlotId())
                .map(Slot::getDoctorName)
                .orElse("Unknown Doctor");

        // Create the confirmation details
        AppointmentConfirmation confirmation = new AppointmentConfirmation(
                appointment.getPatientName(),
                doctorName,
                appointment.getReservedAt()
        );

        // Send the confirmation
        confirmationService.sendConfirmation(confirmation);
    }
}
