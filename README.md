Advanced Java - March 6-8 2013
==============================

Immutability
------------

* safe subtyping ("Liskov Substitutability Principle")
* stable structural identity (immutable hashCode)
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

Upper Bounded Wildcard: `<? extends A>` representing covariance
Lower Bounded Wildcard: `<? super A>` representing contravariance
Upper Bounded Type Parameter: `<A extends B>` representing covariance

Variance is what bites us when we mix parametric polymorphism with subtype polymorphism
