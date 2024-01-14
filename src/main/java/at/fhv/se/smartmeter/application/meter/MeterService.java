package at.fhv.se.smartmeter.application.meter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.se.smartmeter.application.port.inbound.meter.CreateMeterUseCase;
import at.fhv.se.smartmeter.application.port.outbound.persistence.MeterRepository;
import at.fhv.se.smartmeter.domain.model.MeterIndividual;

@Service
public class MeterService implements CreateMeterUseCase {

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
    
}
