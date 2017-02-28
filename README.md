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

1. Install version 3.1.1 of [neo4j](http://neo4j.com/download/) 
2. Inject scripts : 
	1. Run your Neo4J Database (db credentials should be neo4j/password or change credentials in Session_Helper class)
	2. copy all files from /src/main/import to [db_path]/import/ 
	3. In your Neo4J Web interface then on the star tab, drag and drop every *.cyp script files
	4. Run he script by their name order
3. 5! 5! 5!


Rock 'n Roll!


## FAQ
* Your try-out is not finished, it ask me "How I'll do this?" where is the answer?

 Please check "ninja" directory in "src/main" directory, fully operational Query class are hidden there :)

## Resources
* Dataset is from [mneedham's neo4j-worldcup](https://github.com/mneedham/neo4j-worldcup)

## License

Covered with [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)