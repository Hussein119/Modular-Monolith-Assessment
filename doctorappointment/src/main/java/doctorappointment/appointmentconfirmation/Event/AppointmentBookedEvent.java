package doctorappointment.appointmentconfirmation.Event;

import doctorappointment.appointmentbooking.Domain.Appointment;
import org.springframework.context.ApplicationEvent;

public class AppointmentBookedEvent extends ApplicationEvent {
    private final Appointment appointment;

    public AppointmentBookedEvent(Object source, Appointment appointment) {
        super(source);
        this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }
}
