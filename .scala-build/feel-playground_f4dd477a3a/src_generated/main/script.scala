

final class script$_ {
def args = script_sc.args$
def scriptPath = """script.sc"""
/*<script>*/
 import $ivy.{
   `com.lihaoyi::upickle:4.0.0`
 }
import upickle.default._


feel(
"""
"Мфдукф"
 """)

feel(
"""for
  fruit in [ "apple", "bananas" ], vegetable in vegetables
return
  { ingredients: [ fruit, vegetable ] }
""", """{
  "vegetables": [ "garlic", "tomato" ],
  "Mike's age": 35
}
""")


feel(
"""
DateTimeNow > mergedTask.relevantEndTime 
""",
"""{
     "DateTimeNow" : "2024-09-18T08:04.000Z",
      "mergedTask": {
          "relevantEndTime": "2024-09-18T11:55:00.000Z",
          "estimatedEndTime": "2024-09-18T11:55:00.000Z",
          "state": "AssignedManual",
          "scheduledEndTime": "2024-09-18T11:55:00.000Z",
          "relevantStartTime": "2024-09-18T11:05:00.000Z",
          "resourceGroupIdentity": "CInBS",
          "endLocationIdentity": "BG106",
          "startLocationIdentity": "BG106",
          "identity": "202409180038_01273212563",
          "scheduledStartTime": "2024-09-18T11:05:00.000Z",
          "cleanupDuration": "PT0S",
          "estimatedStartTime": "2024-09-18T11:05:00.000Z",
          "customDataRelations": [],
          "workingShiftIdentity": "ГРПП_Ж0800-2030_2024-09-18_104092",
          "setupDuration": "PT0S"
      },
      "result": true
  } 
""")
//println(Map("DateTimeNow" -> "2024-09-18T08:04.000Z"))
//val jsonString:String = write(result)
//println(jsonString)
// val jsonString = upickle.write(map)

// println(jsonString)

// val map: Map[String, Int] =
//   Map("Toolkitty" -> 3, "Scaniel" -> 5)
// val jsonString: String = upickle.default.write(map)
// println(jsonString)
/*</script>*/ /*<generated>*//*</generated>*/
}

object script_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new script$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export script_sc.script as `script`

