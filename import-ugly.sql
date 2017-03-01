--select * from stop_time where trip_id like '4.TA.26-14-j17-1.2.H'

--select * from stop_time where stop_stop_id = 8503110

--select * from trip where stop_stop_id = 8503110 OR stop_stop_id = 8503000
--select * from stop_time where trip_id like '4.TA.26-14-j17-1.2.H' AND stop_stop_id = 8503121

--select * from stop where stop_name  like 'Rüti ZH'

--select * from stop_time where trip_id like '4.TA.26-14-j17-1.2.H'

-- 8503110 -> Rapperswil
-- 8503000 -> Zürich HB

SELECT * FROM stop_time AS sta 
JOIN stop_time AS stb
ON sta.trip_id = stb.trip_id
WHERE (sta.stop_stop_id = 8503110
OR sta.stop_stop_id = 8503000)
