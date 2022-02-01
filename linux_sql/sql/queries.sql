select cpu_number, host_id, total_mem from host_info
inner join host_usage hu on host_info.id = hu.host_id
group by cpu_number, host_id, total_mem
order by cpu_number desc, host_id desc;
