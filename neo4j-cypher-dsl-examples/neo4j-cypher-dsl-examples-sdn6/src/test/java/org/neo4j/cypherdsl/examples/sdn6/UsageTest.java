/*
 * Copyright (c) 2019-2022 "Neo4j,"
 * Neo4j Sweden AB [https://neo4j.com]
 *
 * This file is part of Neo4j.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neo4j.cypherdsl.examples.sdn6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.neo4j.cypherdsl.core.Cypher;
import org.neo4j.cypherdsl.examples.sdn6.misc.Example_;

/**
 * @author Michael J. Simons
 * @soundtrack In Flames - I, The Mask
 */
class UsageTest {

	@Test // GH-335
	void defaultUsageOfSelfReferentialNode() {
		Example_ node = Example_.EXAMPLE;
		assertThat(node).isNotNull();
	}

	@Test // GH-335
	void selfReferentialNodesShouldLeadToUsableCode() {
		Example_ node = Example_.EXAMPLE.named("example");
		assertThat(node).isNotNull();
	}

	@Test // GH-335
	void ltolx() {

		var left = Example_.EXAMPLE.named("n");
		var parent = left.withParent(Example_.EXAMPLE.named("m"));
		assertThat(parent.getLeft().getRequiredSymbolicName().getValue()).isEqualTo("n");
	}

	@Test // GH-335
	void rtorx() {

		var parent = Example_.EXAMPLE.withParent(Example_.EXAMPLE.named("m"));
		assertThat(parent.getRight().getRequiredSymbolicName().getValue()).isEqualTo("m");
	}

	@Test // GH-335
	void renamingLRShouldWork() {

		var left = Example_.EXAMPLE.named("n");
		var right = Example_.EXAMPLE.named("m");
		var rel = left.withParent(right).named("r");
		var cypher = Cypher.match(rel)
			.where(right.ID.isEqualTo(Cypher.literalOf(1L)))
			.returning(left, right)
			.build().getCypher();
		assertThat(cypher).isEqualTo("MATCH (n:`Example`)-[r:`BELONGS_TO`]->(m:`Example`) WHERE m.id = 1 RETURN n, m");
	}

	@Test // GH-335
	void renamingShouldWork() {

		var node = Example_.EXAMPLE.named("n");
		var rel = node.withParent(Example_.EXAMPLE).named("r");
		var cypher = Cypher.match(rel)
			.where(node.ID.isEqualTo(Cypher.literalOf(1L)))
			.returning(node)
			.build().getCypher();
		assertThat(cypher).matches(
			"MATCH \\(n:`Example`\\)-\\[r:`BELONGS_TO`]->\\(.+:`Example`\\) WHERE n\\.id = 1 RETURN n");
	}
}
