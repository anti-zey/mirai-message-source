package org.meowcat.mesagisto.mirai

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.value
import net.mamoe.mirai.contact.Group

object Config : AutoSavePluginConfig("mesagisto") {
  val enable: Boolean by value()
  val nats: NatsConfig by value()
  val cipher: CipherConfig by value()
  val proxy: ProxyConfig by value()
  val bindings: MutableMap<Long, String> by value()
  private val targetChannelMapper: MutableMap<Long, String> by value()
  fun mapper(target: Long): String? = bindings[target]
  fun mapper(target: Group): String? = bindings[target.id]
  fun migrate() {
    bindings.putAll(targetChannelMapper)
    targetChannelMapper.clear()
  }
}

@Serializable
data class NatsConfig(
  val address: String = "nats://itsusinn.site:4222"
)
@Serializable
data class ProxyConfig(
  val enable: Boolean = false,
  val address: String = "http://127.0.0.1:7890"
)
@Serializable
data class CipherConfig(
  val enable: Boolean = true,
  val key: String = "this-is-an-example-key",
  @SerialName("refuse-plain")
  val refusePlain: Boolean = true
)
