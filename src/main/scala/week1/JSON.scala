package week1

abstract class JSON
case class JSeq(elems: List[JSON]) extends JSON
case class JObj(bindings: Map[String, JSON]) extends JSON
case class JNum(num: Double) extends JSON
case class JStr(str: String) extends JSON
case class JBool(b: Boolean) extends JSON
case class JNull()  extends JSON

object JSON {
  type JBinding = (String, JSON)

  def show(json: JSON): String = json match {
    case JSeq(elems) => "[" + (elems map(e => show(e).mkString(", "))) + "]"
    case JObj(bindings) =>
      val accocs = bindings map {
        case (key, value) => "\"" + key + "\":" + show(value)
      }
      "{" + (accocs mkString ", ")
    case JNum(num) => num toString
    case JStr(str) => "\"" + str + "\""
    case JBool(b) => b toString
    case JNull() => "null"
  }
}