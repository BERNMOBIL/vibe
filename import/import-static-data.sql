﻿-- The data MUST be located in /tmp/gtfs
TRUNCATE TABLE agency CASCADE;
TRUNCATE TABLE calendar CASCADE;
TRUNCATE TABLE calendar_date CASCADE;
TRUNCATE TABLE route CASCADE;
TRUNCATE TABLE stop CASCADE;
TRUNCATE TABLE trip CASCADE;
TRUNCATE TABLE stop_time CASCADE;
COPY agency FROM '/tmp/gtfs/agency.txt' DELIMITER ',' HEADER CSV;
COPY calendar(service_id,monday,tuesday,wednesday,thursday,friday,saturday,sunday,start_date,end_date) FROM '/tmp/gtfs/calendar.txt' WITH (DELIMITER ',', HEADER, FORMAT CSV);
COPY calendar_date(calendar_service_id,date,exception_type) FROM '/tmp/gtfs/calendar_dates.txt' WITH (DELIMITER ',', HEADER, FORMAT CSV);
COPY route(route_id,agency_id,route_short_name,route_long_name,route_type) FROM '/tmp/gtfs/routes.txt' WITH (DELIMITER ',', HEADER, FORMAT CSV);
COPY stop(stop_id,stop_name,stop_latitude,stop_longitude,location_type,parent_station) FROM '/tmp/gtfs/stops.txt' WITH (DELIMITER ',', HEADER, FORMAT CSV);
COPY trip(route_route_id,calendar_service_id,id,trip_headsign,direction_id) FROM '/tmp/gtfs/trips.txt' WITH (DELIMITER ',', HEADER, FORMAT CSV);
COPY stop_time(trip_id,arrival_time,departure_time,stop_stop_id,stop_sequence,pickup_type,drop_off_type) FROM '/tmp/gtfs/stop_times.txt' WITH (DELIMITER ',', HEADER, FORMAT CSV);