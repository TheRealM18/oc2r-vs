# Ship Operations Module
![I Believe I Can Fly](item:oc2rvs:ship_operations_module)

Available on installation, this card adds the **ship** device which comes with the following methods:
- onShip
  - *Check if the ship interface is on an assembled ship. Returns true if it is on a ship*
- getId
  - *Gives the numeric ID of the ship*
- getInertiaData
  - *Returns the inertia data of the ship*
    - InertiaData._mass
      - *Returns the mass of the Ship (kilograms)*
    - InertiaData._centerOfMassInShip
      - *Returns the center of mass of the ship as a vector*
    - InertiaData._momentOfInertiaTensor
      - *Returns the moment of inertia tensor as a 3x3 matrix*
    - InertiaData.momentOfInertiaSpherical
      - *Returns the spherical moment of inertia as a 3x3 matrix*
- getSlug
  - *Returns the slug of the ship*
- getOmega
  - *Returns the rotational velocity of the ship as a vector*
- getShipTransform
  - *Returns the transform of the ship*
    - ShipTransform.shipToWorld
      - *Returns the shipyard-to-worldspace 3x3 transformation matrix*
    - ShipTransform.worldToShip
      - *Returns the worldspace-to-shipyard 3x3 transformation matrix*
    - ShipTransform.positionInWorld
      - *Returns the center mass of the ship in Worldspace as a vector*
    - ShipTransform.positionInShip
      - *Returns the center mass of the ship in the Shipyard as a vector*
    - ShipTransform.shipToWorldRotation
      - *Returns the rotation of the ship as a quaternion*
    - ShipTransform.shipToWorldScaling
      - *Returns the scaling of the ship as a vector*
- getShipAABB
  - *Returns the AABB of the ship*
- getVelocity
  - *Returns the linear velocity of the ship as a vector*
- isStatic
  - *Check if the ship is currently an active physics object*
- setSlug
  - *Sets the slug of the ship*

[Return](index.md)
