package at.fhv.se.smartmeter.application.service.meter;

import at.fhv.se.smartmeter.domain.model.MeterIndividual;
import at.fhv.se.smartmeter.domain.port.inbound.meter.CreateMeterUseCase;
import at.fhv.se.smartmeter.domain.port.outbound.persistence.MeterRepository;

public class MeterService implements CreateMeterUseCase {

    
    private final MeterRepository meterRepo;

    public MeterService(MeterRepository meterRepo) {
        this.meterRepo = meterRepo;
    }

    @Override
    public String createMeter(int serialNumber, String manufacturer) {
        MeterIndividual m = new MeterIndividual(serialNumber, manufacturer);
        return meterRepo.save(m);
    }
    
}
