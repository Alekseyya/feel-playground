 import $ivy.{
   `com.lihaoyi::upickle:4.0.0`
 }
import upickle.default._


feel(
"""
date and time(now(), "Z")  
 """)


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