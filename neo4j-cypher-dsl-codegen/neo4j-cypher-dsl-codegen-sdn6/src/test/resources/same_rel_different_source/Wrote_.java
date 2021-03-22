package org.neo4j.cypherdsl.codegen.sdn6.models.valid.same_rel_different_source;

import javax.annotation.Generated;
import org.neo4j.cypherdsl.core.MapExpression;
import org.neo4j.cypherdsl.core.Node;
import org.neo4j.cypherdsl.core.NodeBase;
import org.neo4j.cypherdsl.core.Properties;
import org.neo4j.cypherdsl.core.RelationshipBase;
import org.neo4j.cypherdsl.core.SymbolicName;

@Generated(
		value = "org.neo4j.cypherdsl.codegen.core.RelationshipImplBuilder",
		date = "2019-09-21T21:21:00+01:00",
		comments = "This class is generated by the Neo4j Cypher-DSL. All changes to it will be lost after regeneration."
)
public final class Wrote_<E extends NodeBase<?>> extends RelationshipBase<Person_, E, Wrote_<E>> {
	public static final String $TYPE = "WROTE";

	public Wrote_(Person_ start, E end) {
		super(start, $TYPE, end);
	}

	private Wrote_(SymbolicName symbolicName, Node start, Properties properties,
			Node end) {
		super(symbolicName, start, $TYPE, properties, end);
	}

	@Override
	public Wrote_<E> named(SymbolicName newSymbolicName) {
		return new Wrote_<>(newSymbolicName, getLeft(), getDetails().getProperties(), getRight());
	}

	@Override
	public Wrote_<E> withProperties(MapExpression newProperties) {
		return new Wrote_<>(getSymbolicName().orElse(null), getLeft(), Properties.create(newProperties), getRight());
	}
}