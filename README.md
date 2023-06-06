# mirai-message-source
A implementation of message source. 消息源的mirai(Tencent-QQ)实现

**自用，目前只特化了消息接收格式。**

# 改动
- `handlers/Receive.kt`143行
`  chain = PlainText("【**$senderName**】").plus(chain)`
