-- Insert Meter entries
INSERT INTO meter (serial_number, manufacturer) VALUES (123, 'ABC Manufacturing');
INSERT INTO meter (serial_number, manufacturer) VALUES (456, 'XYZ Corp');
INSERT INTO meter (serial_number, manufacturer) VALUES (789, 'EFG Ltd');
INSERT INTO meter (serial_number, manufacturer) VALUES (101, 'LMN Industries');
INSERT INTO meter (serial_number, manufacturer) VALUES (202, 'PQR Systems');

-- Insert MeterReading entries with foreign key references to Meter
INSERT INTO meter_reading (timestamp, meter_id, pos_act_inst_power, pos_act_energy_total, neg_act_inst_power,
                           neg_act_energy_total, pos_react_energy_total, neg_react_energy_total, sum_act_instant_power,
                           inst_curr_l1, inst_volt_l1, inst_curr_l2, inst_volt_l2, inst_curr_l3, inst_volt_l3)
VALUES ('2023-01-01 12:00:00', 1, 100, 1000, 50, 500, 200, 200, 150, 10.5, 220.0, 20.0, 230.0, 30.0, 40.0);

INSERT INTO meter_reading (timestamp, meter_id, pos_act_inst_power, pos_act_energy_total, neg_act_inst_power,
                           neg_act_energy_total, pos_react_energy_total, neg_react_energy_total, sum_act_instant_power,
                           inst_curr_l1, inst_volt_l1, inst_curr_l2, inst_volt_l2, inst_curr_l3, inst_volt_l3)
VALUES ('2023-01-02 12:00:00', 2, 120, 1200, 60, 600, 250, 250, 180, 12.5, 225.0, 22.0, 235.0, 32.0, 42.0);

INSERT INTO meter_reading (timestamp, meter_id, pos_act_inst_power, pos_act_energy_total, neg_act_inst_power,
                           neg_act_energy_total, pos_react_energy_total, neg_react_energy_total, sum_act_instant_power,
                           inst_curr_l1, inst_volt_l1, inst_curr_l2, inst_volt_l2, inst_curr_l3, inst_volt_l3)
VALUES ('2023-01-03 12:00:00', 3, 90, 900, 45, 450, 180, 180, 120, 9.5, 210.0, 18.0, 220.0, 28.0, 38.0);

INSERT INTO meter_reading (timestamp, meter_id, pos_act_inst_power, pos_act_energy_total, neg_act_inst_power,
                           neg_act_energy_total, pos_react_energy_total, neg_react_energy_total, sum_act_instant_power,
                           inst_curr_l1, inst_volt_l1, inst_curr_l2, inst_volt_l2, inst_curr_l3, inst_volt_l3)
VALUES ('2023-01-04 12:00:00', 4, 110, 1100, 55, 550, 220, 220, 160, 11.0, 215.0, 20.0, 225.0, 30.0, 40.0);

INSERT INTO meter_reading (timestamp, meter_id, pos_act_inst_power, pos_act_energy_total, neg_act_inst_power,
                           neg_act_energy_total, pos_react_energy_total, neg_react_energy_total, sum_act_instant_power,
                           inst_curr_l1, inst_volt_l1, inst_curr_l2, inst_volt_l2, inst_curr_l3, inst_volt_l3)
VALUES ('2023-01-05 12:00:00', 5, 130, 1300, 65, 650, 270, 270, 200, 14.0, 230.0, 24.0, 240.0, 34.0, 44.0);
