# Ship Operations Module

![I Believe I Can Fly!](item:oc2rvs:ship_operations_module)

This device allows the computer to access Ship physics information!
**Note: This device only exists when the computer it is installed on is on a Ship!**

## API
Device name: *ship*

### Methods
*getId():long*
This method attempts to get the ID of the Ship this computer is on.

*getInertiaData():table*
This method gets the current inertia data of the Ship this computer is currently on.
- Returns the inertia data of the Ship as a table containing the keys *_mass*, *_centerOfMassInShip*, *_momentOfInertiaTensor*, and *momentOfInertiaSpherical*.

*getSlug():string*
Thisa method gets the Slug of the Ship this computer is on.

*getOmega():table*
This method gets the angular velocity of the Ship this computer is on.
- Returns the angular velocity of the Ship as a table containing the keys *x*, *y*, and *z*.

*getShipTransform():table*
This method gets the transform data of the Ship this computer is on.
- Returns the transform of the Ship as a table containnig the keys *shipToWorld*, *worldToShip*, *positionInWorld*, *positionInShip*, *shipToWorldRotation*, and *shipToWorldScaling*.

*getShipAABB():table*
This method gets the Axis-Aligned Bounding Box of the Ship this computer is on.
- Returns the AABB of the Ship as a table

*getVelocity():table*
This method gets the linear velocity of the Ship this computer is on.
- Returns the linear velocity of the Ship as a table containing the keys *x*, *y*, and *z*.

*isStatic():boolean*
This method determines whether the Ship the computer is on is set to static.

*setSlug(slug:string)*
This method sets a new Slug for the Ship this computer is currently on.
- *slug* is a string representing the new Slug of the Ship.

[Return](vs.md)
