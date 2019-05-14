/*
 * Copyright (c) 2019 "Neo4j,"
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
package org.springframework.data.neo4j.core.cypher;

import org.apiguardian.api.API;

/**
 * The boolean literal.
 *
 * @author Michael J. Simons
 * @soundtrack Bad Religion - Age Of Unreason
 * @since 1.0
 */
@API(status = API.Status.INTERNAL, since = "1.0")
public final class BooleanLiteral extends Literal<Boolean> {

	static BooleanLiteral TRUE = new BooleanLiteral(true);
	static BooleanLiteral FALSE = new BooleanLiteral(false);

	private BooleanLiteral(boolean content) {
		super(content);
	}

	@Override
	public String asString() {
		return getContent().toString();
	}
}
