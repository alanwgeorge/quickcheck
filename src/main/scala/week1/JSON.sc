import week1.JSON._
import week1._

val data = JObj(Map(
  "firstName"-> JStr("John"),
  "lastName"-> JStr("Smith"),
  "address" -> JObj(Map(
    "streetAddress" -> JStr("21 2nd Street"),
    "state" -> JStr("NY"),
    "postalCode" -> JNum(10021)
  )),
  "phoneNumbers" -> JSeq(List(
    JObj(Map(
      "type" -> JStr("home"), "number" -> JStr("212-555-1234")
    )),
    JObj(Map(
      "type" -> JStr("`dfaxhome"), "number" -> JStr("212-555-4567")
    ))
  ))
))

show(data)

val f1 = new Function1[JBinding, String] {
  override def apply(v1: (String, JSON)): String = v1 match {
    case (key, value) => key + ":" + show(value)
  }
}
f1("foo", data)

val f2: Function1[JBinding, String] = { case (key, value) => key + ":" + show(value) }
f2("foo", data)

val f3: String => String = {
  case "ping" => "pong"
  case "pong" => "ping"
}
f3("ping")
f3("pong")

val f4: PartialFunction[String, String] = {case "ping" => "pong"}
f4.isDefinedAt("ping")
f4.isDefinedAt("pong")