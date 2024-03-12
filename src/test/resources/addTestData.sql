INSERT INTO service (service_id, service_restaurant_booking, service_restaurant_price, service_bar_booking, service_bar_price, service_swimming_pool_booking, service_swimming_pool_price, service_gym_booking, service_gym_price, service_garage_booking, service_garage_price, service_airport_transfer, service_airport_transfer_price)
VALUES ('e87832a7-e9a7-45fc-bc18-48a122632ff1', 0, 0.0, 1, 8.50, 0, 0.0, 1, 12.75, 0, 0.0, 1, 25.00);

INSERT INTO room (room_id, room_category, room_price_per_night, room_availability, room_floor, room_breakfast_include, room_check_in_date, room_check_out_date)
VALUES (101, 'Standard', 100.00, 1, 1, 1, '2024-01-02', '2024-01-07');

INSERT INTO event (event_id, event_name, event_description, event_date, event_time_beginning, event_time_end, event_location, event_capacity, event_organized_company, event_contact_person)
VALUES ('d82d1d8a-ca82-4811-849a-5558e3c3153f', 'Conference Mercedes Benz Co.', 'A conference on emerging technologies', '2024-01-02', '2024-01-02T09:00:00', '2024-01-02T17:00:00', 'Grand Ballroom', 200, 'Tech Events Inc.', 'Kristina Fletcher');

INSERT INTO customer (customer_id, customer_first_name, customer_last_name, customer_email, customer_phone_number, customer_address, customer_loyality_point, customer_credit_card_number, customer_credit_card_expiring_date)
VALUES ('cfa32ac8-5f89-477c-af6b-2e3b1fc2f125', 'Alejandro', 'Rubio', 'alejandro.rubio@gmail.com', '490672082', 'Sommeringstr. 9, 76872 Erlenbach Bei Kandel', 100, '202401111', '2027-01-01');

INSERT INTO payment (payment_id, payment_method, payment_is_paid, payment_transaction_history)
VALUES ('48325ff0-3efc-43c7-bd4c-2896ad9d140f', 'Credit Card', 1, 'No history');

INSERT INTO reservation (reservation_id, reservation_customer_id, reservation_room_id, reservation_event_id, reservation_service_id, reservation_total_amount, reservation_cancelled_info)
VALUES ('92e5fe8a-34c0-4031-ad87-7e915a81b5a1', 'cfa32ac8-5f89-477c-af6b-2e3b1fc2f125', 101, 'd82d1d8a-ca82-4811-849a-5558e3c3153f', 'e87832a7-e9a7-45fc-bc18-48a122632ff1', 2562.24, 'No cancellation');
