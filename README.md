# Doctor Availability Module (Traditional Layered Architecture)

## Layers:

- Controller: Expose REST APIs.
- Service: Business logic for managing slots.
- Repository: Data persistence (use shared database integration style).
  - NoSQL -> Mongoodb
- Entity: Slot class.

> Controller depends on Service.
> Service depends on Repository.
> Controller, Service, and Repository depends on Entity.
