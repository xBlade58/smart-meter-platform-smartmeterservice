-- Enable the uuid-ossp extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Inserting sample data into the physical_meter table
INSERT INTO physical_meter (id, name, version, meter_class)
VALUES
  ('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Kaifa Meter 1', 'MA309M', 'ELECTRICITY'),
  (uuid_generate_v4(), 'Kaifa Meter 2', 'MA309M', 'ELECTRICITY');

-- Sample Meter entries
INSERT INTO meter (id, serial_number, physical_meter_id, household_id) VALUES ('b52ac10f-58cc-6172-a567-0e02b2c3d479', 'SN123456', 'f47ac10b-58cc-4372-a567-0e02b2c3d479', '1');
INSERT INTO meter (id, serial_number, physical_meter_id, household_id) VALUES ('bf17c6a0-82ce-4214-adbd-5a7e4ecdb0ff', 'SN188191', 'f47ac10b-58cc-4372-a567-0e02b2c3d479', '2');


-- Sample MeterReadings

INSERT INTO meter_reading (id, reading_time, meter_id, json_properties)
VALUES
  (uuid_generate_v4(), '2023-05-06T12:00:00+00:00'::timestamptz, 'b52ac10f-58cc-6172-a567-0e02b2c3d479', 
    '[{"date": 1683368270, "unit": "kW", "numericalValue": 133, "operationalPropertyDefId": "1.7.0"},
      {"date": 1683368270, "unit": "kWh", "numericalValue": 1136784, "operationalPropertyDefId": "1.8.0"},
      {"date": 1683368270, "unit": "kWh", "numericalValue": 0, "operationalPropertyDefId": "2.7.0"},
      {"date": 1683368270, "unit": "kWh", "numericalValue": 0, "operationalPropertyDefId": "2.8.0"},
      {"date": 1683368270, "unit": "kvarh", "numericalValue": 717736, "operationalPropertyDefId": "4.8.0"},
      {"date": 1683368270, "unit": "kW", "numericalValue": 154, "operationalPropertyDefId": "16.7.0"},
      {"date": 1683368270, "unit": "A", "numericalValue": 0.99, "operationalPropertyDefId": "31.7.0"},
      {"date": 1683368270, "unit": "V", "numericalValue": 229.4, "operationalPropertyDefId": "32.7.0"},
      {"date": 1683368270, "unit": "A", "numericalValue": 0.42, "operationalPropertyDefId": "51.7.0"},
      {"date": 1683368270, "unit": "V", "numericalValue": 228.8, "operationalPropertyDefId": "52.7.0"}]'
  ),
  (uuid_generate_v4(), '2023-05-06T13:00:00+00:00'::timestamptz, 'b52ac10f-58cc-6172-a567-0e02b2c3d479', 
    '[{"date": 1683368270, "unit": "kW", "numericalValue": 140, "operationalPropertyDefId": "1.7.0"},
      {"date": 1683368270, "unit": "kWh", "numericalValue": 1136790, "operationalPropertyDefId": "1.8.0"},
      {"date": 1683368270, "unit": "kWh", "numericalValue": 1, "operationalPropertyDefId": "2.7.0"},
      {"date": 1683368270, "unit": "kWh", "numericalValue": 2, "operationalPropertyDefId": "2.8.0"},
      {"date": 1683368270, "unit": "kvarh", "numericalValue": 717740, "operationalPropertyDefId": "4.8.0"},
      {"date": 1683368270, "unit": "kW", "numericalValue": 160, "operationalPropertyDefId": "16.7.0"},
      {"date": 1683368270, "unit": "A", "numericalValue": 1.1, "operationalPropertyDefId": "31.7.0"},
      {"date": 1683368270, "unit": "V", "numericalValue": 229.9, "operationalPropertyDefId": "32.7.0"},
      {"date": 1683368270, "unit": "A", "numericalValue": 0.49, "operationalPropertyDefId": "51.7.0"},
      {"date": 1683368270, "unit": "V", "numericalValue": 229.0, "operationalPropertyDefId": "52.7.0"}]'
  ),
  (uuid_generate_v4(), '2023-05-06T14:00:00+00:00'::timestamptz, 'b52ac10f-58cc-6172-a567-0e02b2c3d479', 
    '[{"date": 1683368270, "unit": "kW", "numericalValue": 145, "operationalPropertyDefId": "1.7.0"},
      {"date": 1683368270, "unit": "kWh", "numericalValue": 1136792, "operationalPropertyDefId": "1.8.0"},
      {"date": 1683368270, "unit": "kWh", "numericalValue": 3, "operationalPropertyDefId": "2.7.0"},
      {"date": 1683368270, "unit": "kWh", "numericalValue": 4, "operationalPropertyDefId": "2.8.0"},
      {"date": 1683368270, "unit": "kvarh", "numericalValue": 717745, "operationalPropertyDefId": "4.8.0"},
      {"date": 1683368270, "unit": "kW", "numericalValue": 170, "operationalPropertyDefId": "16.7.0"},
      {"date": 1683368270, "unit": "A", "numericalValue": 1.2, "operationalPropertyDefId": "31.7.0"},
      {"date": 1683368270, "unit": "V", "numericalValue": 230.3, "operationalPropertyDefId": "32.7.0"},
      {"date": 1683368270, "unit": "A", "numericalValue": 0.54, "operationalPropertyDefId": "51.7.0"},
      {"date": 1683368270, "unit": "V", "numericalValue": 229.5, "operationalPropertyDefId": "52.7.0"}]'
  ),
  (uuid_generate_v4(), '2023-05-06T15:00:00+00:00'::timestamptz, 'b52ac10f-58cc-6172-a567-0e02b2c3d479', 
    '[{"date": 1683368270, "unit": "kW", "numericalValue": 145, "operationalPropertyDefId": "1.7.0"},
      {"date": 1683368270, "unit": "kWh", "numericalValue": 1136792, "operationalPropertyDefId": "1.8.0"},
      {"date": 1683368270, "unit": "kWh", "numericalValue": 3, "operationalPropertyDefId": "2.7.0"},
      {"date": 1683368270, "unit": "kWh", "numericalValue": 4, "operationalPropertyDefId": "2.8.0"},
      {"date": 1683368270, "unit": "kvarh", "numericalValue": 717745, "operationalPropertyDefId": "4.8.0"},
      {"date": 1683368270, "unit": "kW", "numericalValue": 170, "operationalPropertyDefId": "16.7.0"},
      {"date": 1683368270, "unit": "A", "numericalValue": 1.2, "operationalPropertyDefId": "31.7.0"},
      {"date": 1683368270, "unit": "V", "numericalValue": 230.3, "operationalPropertyDefId": "32.7.0"},
      {"date": 1683368270, "unit": "A", "numericalValue": 0.54, "operationalPropertyDefId": "51.7.0"},
      {"date": 1683368270, "unit": "V", "numericalValue": 229.5, "operationalPropertyDefId": "52.7.0"}]'
  );


