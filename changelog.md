# Changes - 0.8.0
- Replaced `getScale`, `getWorldspacePosition`, `getShipyardPosition`, and `getEulerAngles***` with `getShipTransform`
- Replaced `getMass` with `getInertiaData`
- Replaced `getName`/`setName` with `getSlug`/`setSlug`
- `getOmega` and `getVelocity` now return a `Vector3dc`
- Replaced `getSize` with `getShipAABB`
- Updated documentation
- Fixed JAR naming schema