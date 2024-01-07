-- Enable the uuid-ossp extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Inserting sample data into the physical_meter table
INSERT INTO physical_meter (id, name, version, meter_class)
VALUES
  ('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Kaifa Meter 1', 'MA309M', 'ELECTRICITY'),
  (uuid_generate_v4(), 'Kaifa Meter 2', 'MA309M', 'ELECTRICITY');

-- Sample Meter entries
INSERT INTO meter (id, serial_number, physical_meter_id) VALUES ('b52ac10f-58cc-6172-a567-0e02b2c3d479', 'SN123456', 'f47ac10b-58cc-4372-a567-0e02b2c3d479');


