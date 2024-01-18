package at.fhv.se.smartmeter.application.meter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.se.smartmeter.application.dto.MeterDTO;
import at.fhv.se.smartmeter.application.port.inbound.meter.AssignHousoldToMeterUseCase;
import at.fhv.se.smartmeter.application.port.inbound.meter.CreateMeterUseCase;
import at.fhv.se.smartmeter.application.port.inbound.meter.GetMeterUseCase;
import at.fhv.se.smartmeter.application.port.inbound.meter.UnassignHouseholdFromMeterUseCase;
import at.fhv.se.smartmeter.application.port.outbound.persistence.MeterRepository;
import at.fhv.se.smartmeter.domain.model.MeterIndividual;
import jakarta.transaction.Transactional;

@Service
public class MeterService implements CreateMeterUseCase, GetMeterUseCase, 
    AssignHousoldToMeterUseCase, UnassignHouseholdFromMeterUseCase {

    @Autowired
    private final MeterRepository meterRepo;


    public MeterService(MeterRepository meterRepo) {
        this.meterRepo = meterRepo;
    }

    @Override
    public String createMeter(String serialNumber, String physicalMeterId) {
        MeterIndividual m = new MeterIndividual(serialNumber, physicalMeterId, null);
        return meterRepo.save(m);
    }

    @Transactional
    @Override
    public void assign(String meterId, String householdId) {
        meterRepo.assignHouseholdToMeter(meterId, householdId);
    }

    @Transactional
    @Override
    public void unassign(String meterId) {
        meterRepo.unassignHouseholdFromMeter(meterId);
    }

    @Override
    public MeterDTO getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public boolean existsById(String id) {
        return meterRepo.existsById(id);
    }
    
}
