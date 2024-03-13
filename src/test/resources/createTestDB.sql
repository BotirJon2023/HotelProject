CREATE TABLE IF NOT EXISTS room (
        room_id INTEGER PRIMARY KEY NOT NULL,
        room_category VARCHAR(30) NOT NULL,
        room_price_per_night DOUBLE NOT NULL,
        room_availability BOOLEAN NOT NULL,
        room_floor INTEGER NOT NULL,
        room_breakfast_include BOOLEAN NOT NULL,
        room_check_in_date DATE NOT NULL,
        room_check_out_date DATE NOT NULL
        );

CREATE TABLE IF NOT EXISTS service (
        service_id UUID PRIMARY KEY NOT NULL,
        service_restaurant_booking BOOLEAN NOT NULL,
        service_restaurant_price DOUBLE NOT NULL,
        service_bar_booking BOOLEAN NOT NULL,
        service_bar_price DOUBLE NOT NULL,
        service_swimming_pool_booking BOOLEAN NOT NULL,
        service_swimming_pool_price DOUBLE NOT NULL,
        service_gym_booking BOOLEAN NOT NULL,
        service_gym_price DOUBLE NOT NULL,
        service_garage_booking BOOLEAN NOT NULL,
        service_garage_price DOUBLE NOT NULL,
        service_airport_transfer BOOLEAN NOT NULL,
        service_airport_transfer_price DOUBLE NOT NULL
        );

CREATE TABLE IF NOT EXISTS event (
       event_id UUID PRIMARY KEY NOT NULL,
       event_name VARCHAR(100) NOT NULL,
       event_description VARCHAR(255),
       event_date DATE NULL,
       event_time_beginning TIMESTAMP NULL,
       event_time_end TIMESTAMP NULL,
       event_location VARCHAR(255),
       event_capacity INTEGER NOT NULL,
       event_organized_company VARCHAR(100),
       event_contact_person VARCHAR(100)
       );

CREATE TABLE IF NOT EXISTS customer (
       customer_id UUID PRIMARY KEY NOT NULL,
       customer_first_name VARCHAR(50),
       customer_last_name VARCHAR(50),
       customer_email VARCHAR(100),
       customer_phone_number INTEGER,
       customer_address VARCHAR(255),
       customer_loyality_point VARCHAR(50),
       customer_credit_card_number VARCHAR(50),
       customer_credit_card_expiring_date DATE NULL
       );

CREATE TABLE IF NOT EXISTS payment (
       payment_id UUID PRIMARY KEY NOT NULL,
       payment_method VARCHAR(50) NOT NULL,
       payment_is_paid BOOLEAN NOT NULL,
       payment_transaction_history VARCHAR(50) NOT NULL
       );

CREATE TABLE IF NOT EXISTS reservation (
       reservation_id UUID PRIMARY KEY NOT NULL,
       reservation_customer_id UUID NULL,
       reservation_room_id INT NULL,
       reservation_event_id UUID NULL,
       reservation_service_id UUID NULL,
       reservation_payment_id UUID NULL,
       reservation_total_amount DOUBLE NOT NULL,
       reservation_cancelled_info VARCHAR(255) NOT NULL
       );