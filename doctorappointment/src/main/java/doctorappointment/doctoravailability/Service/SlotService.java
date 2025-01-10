package doctorappointment.doctoravailability.Service;

import doctorappointment.doctoravailability.Entity.Slot;
import doctorappointment.doctoravailability.Repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;

    // Get all available slots for a doctor
    public List<Slot> getAvailableSlotsByDoctor(String doctorName) {
        return slotRepository.findByDoctorNameAndIsReservedFalse(doctorName);
    }

    // Get all slots
    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    // Save a slot
    public Slot createSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    // Find a slot by ID
    public Slot getSlotById(UUID slotId) {
        return slotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));
    }

    // Get all available slots (regardless of doctor)
    public List<Slot> getAvailableSlots() {
        return slotRepository.findByIsReservedFalse();
    }

    // Add multiple slots
    public void addSlots(Slot[] slots) {
        for (Slot slot : slots) {
            slotRepository.save(slot);
        }
    }
}