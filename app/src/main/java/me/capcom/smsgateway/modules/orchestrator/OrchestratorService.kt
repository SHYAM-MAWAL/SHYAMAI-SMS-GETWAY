package me.capcom.smsgateway.modules.orchestrator

import android.content.Context
import me.capcom.smsgateway.helpers.SettingsHelper
import me.capcom.smsgateway.modules.gateway.GatewayService
import me.capcom.smsgateway.modules.localserver.LocalServerService
import me.capcom.smsgateway.modules.logs.LogsService
import me.capcom.smsgateway.modules.logs.db.LogEntry
import me.capcom.smsgateway.modules.messages.MessagesService
import me.capcom.smsgateway.modules.ping.PingService
import me.capcom.smsgateway.modules.receiver.ReceiverService
import me.capcom.smsgateway.modules.webhooks.WebHooksService

class OrchestratorService(
    private val messagesSvc: MessagesService,
    private val gatewaySvc: GatewayService,
    private val localServerSvc: LocalServerService,
    private val webHooksSvc: WebHooksService,
    private val receiverService: ReceiverService,
    private val pingSvc: PingService,
    private val logsSvc: LogsService,
    private val settings: SettingsHelper,
) {
    fun start(context: Context, autostart: Boolean) {
        if (autostart && !settings.autostart) {
            return
        }

        try { logsSvc.start(context) } catch (e: Throwable) { }
        try { messagesSvc.start(context) } catch (e: Throwable) { }
        try { webHooksSvc.start(context) } catch (e: Throwable) { }
        try { gatewaySvc.start(context) } catch (e: Throwable) { }

        try {
            localServerSvc.start(context)
        } catch (e: Throwable) {
            logsSvc.insert(LogEntry.Priority.WARN, MODULE_NAME, "Can't start local server: ${e.message}")
        }
        try {
            pingSvc.start(context)
        } catch (e: Throwable) {
            logsSvc.insert(LogEntry.Priority.WARN, MODULE_NAME, "Can't start ping service: ${e.message}")
        }
        try {
            receiverService.start(context)
        } catch (e: Throwable) {
            logsSvc.insert(LogEntry.Priority.WARN, MODULE_NAME, "Can't register receiver: ${e.message}")
        }
    }

    fun stop(context: Context) {
        receiverService.stop(context)
        pingSvc.stop(context)
        localServerSvc.stop(context)

        gatewaySvc.stop(context)
        webHooksSvc.stop(context)
        messagesSvc.stop(context)
        logsSvc.stop(context)
    }
}