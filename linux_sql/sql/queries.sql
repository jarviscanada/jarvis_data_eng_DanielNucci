-- Group hosts by hardware info (SQL Queries Q1)
select cpu_number, host_id, total_mem from host_info
inner join host_usage as hu on host_info.id = hu.host_id
group by cpu_number, host_id, total_mem
order by cpu_number asc, total_mem desc;

-- Query that shows average memory usage over a 5 minute interval (SQL Queries Q2)
select hu.host_id, hostname, date_trunc('hour', hu.timestamp) + date_part('minute', hu.timestamp):: int / 5 * interval '5 min' as rounded_timestamp, avg((((hi.total_mem / 1024) - (hu.memory_free)) * 100) / (hi.total_mem / 1024)) as avg_used_mem_percent
from host_info as hi
join host_usage as hu on hi.id = hu.host_id
group by rounded_timestamp, hu.host_id, hi.hostname
order by hu.host_id, rounded_timestamp;

-- Group all 5 minute ranges with less than 3 entries to verify healthy server activity (SQL Queries Q3)
select hu.host_id, hi.hostname, date_trunc('hour', hu.timestamp) + date_part('minute', hu.timestamp):: int / 5 * interval '5 min' as rounded_timestamp, count(*) as num_data_points
from host_usage as hu
join host_info as hi on hi.id = hu.host_id
group by hu.host_id, hi.hostname, rounded_timestamp
having count(*) < 3
order by rounded_timestamp;