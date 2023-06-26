curl --location 'localhost:8000/api/anonymize' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer 7|ephCoPNLIpEUFWncKLvJ9lJ4PUiZEPqs6cHsTrNH' \
--data '{
  "data": [["ID", "zipcode", "age", "salary", "illness", "name"], ["0", "90210", "35", "50000", "heartburn", "John Smith"], ["1", "90220", "26", "65000", "IBS", "Emily Johnson"], ["2", "90230", "28", "75000", "colon cancer", "Robert Brown"], ["3", "90240", "49", "82000", "IBS", "Sarah Davis"], ["4", "90250", "59", "110000", "common cold", "Charles Miller"], ["5", "90260", "44", "100000", "pneumonia", "Jessica Wilson"], ["6", "90270", "33", "68000", "pneumonia", "Daniel Taylor"], ["7", "90280", "40", "105000", "asthma", "Michelle White"], ["8", "90290", "37", "115000", "colon cancer", "William Clark"]]
,
  "attributes": [
    {"field": "ID",
    "attributeTypeEnum": "INSENSITIVE"
    },
    {
    "field": "zipcode",
    "attributeTypeEnum": "QUASIIDENTIFYING",
    "hierarchy": [
        ["90210", "9021*", "902**", "90***", "9****", "*****"],
        ["90220", "9022*", "902**", "90***", "9****", "*****"],
        ["90230", "9023*", "902**", "90***", "9****", "*****"],
        ["90240", "9024*", "902**", "90***", "9****", "*****"],
        ["90250", "9025*", "902**", "90***", "9****", "*****"],
        ["90260", "9026*", "902**", "90***", "9****", "*****"],
        ["90270", "9027*", "902**", "90***", "9****", "*****"],
        ["90280", "9028*", "902**", "90***", "9****", "*****"],
        ["90290", "9029*", "902**", "90***", "9****", "*****"]
    ]
    },
    {
      "field": "age",
      "attributeTypeEnum": "QUASIIDENTIFYING",
      "hierarchy": [
        ["35", "30-39", "21-40"],
        ["26", "20-29", "21-40"],
        ["28", "20-29", "21-40"],
        ["49", "40-49", "41-60"],
        ["59", "50-59", "41-60"],
        ["44", "40-49", "41-60"],
        ["33", "30-39", "21-40"],
        ["40", "40-49", "41-60"],
        ["37", "30-39", "21-40"]
    ]
    },
    {
        "field": "salary",
        "attributeTypeEnum": "SENSITIVE"
    },
    {
        "field": "illness",
        "attributeTypeEnum": "SENSITIVE"
    },
    {
        "field": "name",
        "attributeTypeEnum": "IDENTIFYING"
    }
  ],
  "privacyModels": [
    {
      "privacyModel": "KAnonymity",
      "parameters": {
        "k": "2"
      }
    },
    {
      "privacyModel": "DistinctLDiversity",
      "parameters": {
        "attribute": "salary",
        "l": "3"
      }
    },
    {
      "privacyModel": "DistinctLDiversity",
      "parameters": {
        "attribute": "illness",
        "l": "1"
      }
    }
  ],
  "suppresionLimit": 0.5
}'