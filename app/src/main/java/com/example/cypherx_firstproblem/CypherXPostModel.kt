package com.example.cypherx_firstproblem

data class CypherXPostModel(
    var battery_status: String,
    var free_bytes: Long,
    var last_chunk_download_time: String,
    var network_speed_: Long,
    var node_id_: String = "8104362445",
    var used_bandwidth: Long
)