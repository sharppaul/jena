/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jena.security.impl;

import java.util.Set;

import org.apache.jena.security.SecurityEvaluator;

/**
 * A SecurityEvaluator that can be cached for later use.
 */
public class CachedSecurityEvaluator implements SecurityEvaluator {
	private final SecurityEvaluator wrapped;
	private final Object origPrincipal;

	/**
	 *
	 * @param wrapped
	 * @param runAs
	 */
	public CachedSecurityEvaluator(final SecurityEvaluator wrapped,
			final Object runAs) {
		this.origPrincipal = runAs;
		this.wrapped = wrapped;
	}

	@Override
	public boolean evaluate(final Object principal, final Action action,
			final SecNode graphIRI) {
		return wrapped.evaluate(principal, action, graphIRI);
	}

	@Override
	public boolean evaluate(final Object principal, final Action action,
			final SecNode graphIRI, final SecTriple triple) {
		return wrapped.evaluate(principal, action, graphIRI, triple);
	}

	@Override
	public boolean evaluate(final Object principal, final Set<Action> actions,
			final SecNode graphIRI) {
		return wrapped.evaluate(principal, actions, graphIRI);
	}

	@Override
	public boolean evaluate(final Object principal, final Set<Action> actions,
			final SecNode graphIRI, final SecTriple triple) {
		return wrapped.evaluate(principal, actions, graphIRI, triple);
	}

	@Override
	public boolean evaluateAny(final Object principal,
			final Set<Action> actions, final SecNode graphIRI) {
		return wrapped.evaluateAny(principal, actions, graphIRI);
	}

	@Override
	public boolean evaluateAny(final Object principal,
			final Set<Action> actions, final SecNode graphIRI,
			final SecTriple triple) {
		return wrapped.evaluateAny(principal, actions, graphIRI, triple);
	}

	@Override
	public boolean evaluateUpdate(final Object principal,
			final SecNode graphIRI, final SecTriple from, final SecTriple to) {
		return wrapped.evaluateUpdate(principal, graphIRI, from, to);
	}

	@Override
	public Object getPrincipal() {
		return origPrincipal;
	}

}
