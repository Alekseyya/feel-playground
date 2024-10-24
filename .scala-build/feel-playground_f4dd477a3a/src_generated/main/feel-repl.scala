

final class feel$minusrepl$_ {
def args = feel$minusrepl_sc.args$
def scriptPath = """feel-repl.sc"""
/*<script>*/
// import the FEEL engine library
import $ivy.`org.camunda.feel:feel-engine:1.18.0`, org.camunda.feel._, org.camunda.feel.api._

// import a logging library
import $ivy.{
  `org.apache.logging.log4j:log4j-slf4j-impl:2.14.0`,
  `com.lihaoyi::upickle:4.0.0`
  },
org.apache.logging.log4j.core.config.Configurator,
org.apache.logging.log4j.Level

import upickle.default._
// and enable the logging to print warnings
Configurator.setRootLevel(Level.WARN)

// initialize the FEEL engine
val feelEngine = FeelEngineBuilder.create().build()

val feelEngineVersion = classOf[FeelEngine].getPackage.getImplementationVersion

// define a shortcut function for evaluation
def feel(expression: String, context: Map[String, Any] = Map.empty): Unit = {
  val evalResult = feelEngine.evaluateExpression(expression, context)
  printResult(evalResult)
}

def feel(expression: String, jsonContext: String): Unit = {
  parseJsonObject(jsonContext)
    .map(context => feel(expression, context))
}

def unaryTests(expression: String,
               inputValue: Any,
               context: Map[String, Any] = Map.empty): Unit = {
  val evalResult = feelEngine.evaluateUnaryTests(expression, inputValue, context)
  printResult(evalResult)
}

def unaryTests(expression: String,
               jsonInputValue: String,
               jsonContext: String): Unit = {
  parseJsonObject(jsonContext).map { context =>
    val inputValue = parseJson(jsonInputValue)
    unaryTests(expression, inputValue, context)
  }
}

implicit class MySerializer[A](that: A) {
  def toJsonString: String = {
    that match {
      case list: List[_] => list.map(_.toJsonString).mkString("[", ",", "]")
      case m: Map[_, _]  => m.toList.map(_.toJsonString).mkString("{", ",", "}")
      case (left, right) => left.toString + " : " + right.toJsonString
      case x: String     => x.toString
      case x: Int        => x.toString
      case x: Boolean    => x.toString
      case x: DateTime   => x.toString
      case x: LocalDateTime   => x.toString
      case _             => "NuN"
    }
  }
}

private def printResult(evalResult: EvaluationResult): Unit = {
  if (evalResult.isSuccess) {
    //println(fansi.Color.LightGreen(s"> ${evalResult.result}"))
    //Не удалять
    println(s"Type variable : ${evalResult.result.getClass}")
    //println(s"Variable : ${evalResult.result.toString()}")
    val jsonString = evalResult.result.toJsonString
    println(fansi.Color.LightGreen(s"> ${jsonString}"))
  } else {
    println(fansi.Color.LightRed(s"> ${evalResult.failure}"))
  }
}

private def parseJsonObject(json: String): Option[Map[String, Any]] = {
  parseJson(json) match {
    case objectValue: Map[_,_] => Some(objectValue.asInstanceOf[Map[String, Any]])
    case otherValue =>
      println(
        fansi.Color.LightRed(
          s"> Expected a JSON object as variables but found '$otherValue'"))
      None
  }
}

private def parseJson(json: String): Any = {
  val jsonValue = ujson.read(json)
  unpackJson(jsonValue)
}

private def unpackJson(json: ujson.Value): Any = {
  json match {
    case ujson.Obj(objValue) =>
      objValue.map { case (key, value) => key -> unpackJson(value) }.toMap
    case ujson.Arr(arrValue) => arrValue.map(unpackJson).toList
    case primitiveValue      => primitiveValue.value
  }
}

// print on loading the script
// println(
//   fansi.Color.LightBlue(s"===== FEEL Engine REPL ($feelEngineVersion) ======"))
// println(
//   fansi.Color.LightBlue(
//     """> Evaluate FEEL expressions using 'feel("1 + 3")'"""))
// println(
//   fansi.Color.LightBlue(
//     """> Evaluate FEEL unary-tests using 'unaryTests("[2..5]", 4)'"""))
// println(
//   fansi.Color.LightBlue(
//     """> Provide variables as Map using 'feel("x + 3", Map("x" -> 2))'"""))
// println(fansi.Color.LightBlue(
//   """> Provide variables as JSON string using 'feel("x + 3", "{ \"x\" : 2 }")'"""))

// usage: amm --predef feel-repl.sc
/*</script>*/ /*<generated>*//*</generated>*/
}

object feel$minusrepl_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new feel$minusrepl$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export feel$minusrepl_sc.script as `feel-repl`

