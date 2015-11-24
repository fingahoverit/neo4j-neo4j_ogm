// 2-loadSquads -> 45s
USING PERIODIC COMMIT 1000
LOAD CSV WITH HEADERS FROM "file:///C:/temp/neo4j/cypher/csv/squads.csv" AS csvLine

MATCH (y:Year {year: toInt(csvLine.year)})<-[:IN_YEAR]-(worldCup),
      (c:Country {name: csvLine.country})

MERGE (squad:Squad {name: c.name + " Squad for " + worldCup.name })
MERGE (c)-[:NAMED_SQUAD]->(squad)-[:FOR_WORLD_CUP]->(worldCup)

MERGE (p:Player {id: csvLine.player_id})
ON CREATE SET p.name = csvLine.player_name

MERGE (p)-[:IN_SQUAD]->(squad);