\c host_agent
create table if not exists public.host_info (
    id                  serial not null,
    hostname            varchar not null unique,
    cpu_number          int not null,
    cpu_architecture    varchar not null,
    cpu_model           varchar not null,
    cpu_mhz             float not null,
    l2_cache            int not null,
    total_mem           int not null,
    "timestamp"         timestamp not null,
    primary key (id)
);

create table if not exists public.host_usage (
    "timestamp"         timestamp not null,
    host_id             serial not null,
    memory_free			int not null,
    cpu_idle			int not null,
    cpu_kernel 			int not null,
    disk_io 			int not null,
    disk_available		int not null,
    foreign key (host_id) references host_info(id)
);