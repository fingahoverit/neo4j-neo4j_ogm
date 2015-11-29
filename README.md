NEO4J with NEO4J-OGM tryout
===============

Integrating neo4j with [Neo4J-OGM](https://github.com/neo4j/neo4j-ogm) on worldcup dataset.

Why Neo4J-OGM (Object Graph Mapping) ?

Because it's up tu date with latest Neo4j release and it provides remote connection.


## Installation

### Prepare IDE

1. Clone the project (or get the zip)
2. Add it to your IDE
3. Use maven automation to configure your project
4. Ready to go!

### Prepare Data
* with external db injection

1. Install version 2.3.1 of [neo4j](http://neo4j.com/download/)
2. Inject scripts : 
	1. copy all files from /src/main/cypher to C:/temp/neo4j/cypher/ (If you are not on windows, consider change the absolute path of LOAD CSV command on scripts files)
	2. Run your Neo4J Database
	3. In your Neo4J Web interface then on the star tab, drag and drop every *.cyp script files
	4. Run he script by their name order
3. 5! 5! 5!


Rock 'n Roll!


## Resources
* Dataset is from [mneedham's neo4j-worldcup](https://github.com/mneedham/neo4j-worldcup)

## License

Covered with [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)