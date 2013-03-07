Advanced Java - March 6-8 2013
==============================

Immutability
------------

* safe subtyping ("Liskov Substitutability Principle")
* stable structural identity (immutable hashCode)
* safe covariance
* safe sharing of memory between objects (e.g. immutable lists, trees, etc. can share common substructure, see Okasaki: "Purely Functional Data Structures")
* thread safety

Object Identity
---------------

Reference Identity

* based on heap address
* `a == b`

Structural Identity

* based on properties
* `a.equals(b)`
* contract:
  - if `a.equals(b)` then `a.hashCode() == b.hashCode()`
  - if `a.hashCode() != b.hashCode()` then `!a.equals(b)`

Generics
--------

Variance is what often bites us when we mix parametric polymorphism with subtype polymorphism.

* When `Box` produces `A` (you can get an `A` from a `Box`), covariance is safe:
  - upper-bounded wildcard: `Box<? extends A>`
  - upper-bounded type parameter: `<B extends A>`

* When `Box` consumes `A` (you can put an `A` in a `Box`), contravariance is safe:
  - lower-bounded wildcard: `Box<? super A>`
  - Java doesn't have lower-bounded type parameters :(
