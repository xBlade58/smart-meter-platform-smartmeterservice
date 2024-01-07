package at.fhv.se.smartmeter.application.meter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.se.smartmeter.domain.model.MeterIndividual;
import at.fhv.se.smartmeter.domain.port.inbound.meter.CreateMeterUseCase;
import at.fhv.se.smartmeter.domain.port.outbound.persistence.MeterRepository;

@Service
public class MeterService implements CreateMeterUseCase {

    @Autowired
    private final MeterRepository meterRepo;

    public MeterService(MeterRepository meterRepo) {
        this.meterRepo = meterRepo;
    }

    @Override
    public String createMeter(String serialNumber, String physicalMeterId) {
        MeterIndividual m = new MeterIndividual(serialNumber, physicalMeterId);
        return meterRepo.save(m);
    }
    
}
