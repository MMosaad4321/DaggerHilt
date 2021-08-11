package com.example.daggerhilt.data

import javax.inject.Inject

class LoggerMemoryDataSource @Inject constructor() : LoggerDataSource {
    private val logsMemory = mutableListOf<Log>()


    override fun addLog(msg: String) {
        logsMemory.add(
            Log(
                msg,
                System.currentTimeMillis()
            )
        )

    }

    override fun getAllLogs(callback: (List<Log>) -> Unit) {
        callback(logsMemory)

    }

    override fun removeLogs() {
        logsMemory.clear()
    }

}