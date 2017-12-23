package example

import java.nio.charset.StandardCharsets
import java.util.Base64
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object HmacSHA256Demo extends App {

  val appSecretKey = "my-secret-key"

  val secKey: SecretKeySpec = new SecretKeySpec(appSecretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256")
  val hmacSha256 = Mac.getInstance("HmacSHA256")
  hmacSha256.init(secKey)

  val payload = "abc123"

  val hash = hmacSha256.doFinal(payload.getBytes(StandardCharsets.UTF_8))
  val actualSign = Base64.getEncoder.encodeToString(hash)

  println(actualSign)


}
