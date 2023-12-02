package at.fhv.se.smartmeter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.fhv.se.smartmeter.application.port.inbound.meter.CreateMeterUseCase;
import at.fhv.se.smartmeter.application.port.inbound.meterReading.CreateMeterReadingUseCase;
import at.fhv.se.smartmeter.application.port.inbound.meterReading.GetAllMeterReadingsUseCase;
import at.fhv.se.smartmeter.application.port.outbound.persistence.MeterReadingRepository;
import at.fhv.se.smartmeter.application.port.outbound.persistence.MeterRepository;
import at.fhv.se.smartmeter.application.service.meter.MeterService;
import at.fhv.se.smartmeter.application.service.meterReading.MeterReadingService;

@Configuration
public class BeanConfiguration {
    
    @Bean
    CreateMeterUseCase createMeterUseCase(MeterRepository meterRepository) {
        return new MeterService(meterRepository);
    }

    @Bean
    CreateMeterReadingUseCase createMeterReadingUseCase(MeterReadingRepository meterReadingRepository) {
        return new MeterReadingService(meterReadingRepository);
    }

    @Bean
    GetAllMeterReadingsUseCase getAllMeterReadingsUseCase(MeterReadingRepository meterReadingRepository) {
        return new MeterReadingService(meterReadingRepository);
    }
}
